package com.mdb255.wedding.domain.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdb255.wedding.domain.datamodel.Purchase;
import com.mdb255.wedding.domain.datamodel.RegistryItem;
import com.mdb255.wedding.domain.datamodel.Rsvp;
import com.mdb255.wedding.domain.service.WeddingService;
import com.mdb255.wedding.domain.transform.PurchaseTransformer;
import com.mdb255.wedding.domain.transform.RegistryItemTransformer;
import com.mdb255.wedding.domain.transform.RsvpTransformer;
import com.mdb255.wedding.domain.util.Emailer;
import com.mdb255.wedding.domain.util.HibernateConfigurator;
import com.mdb255.wedding.domain.util.impl.GiftCardEmailComposer;
import com.mdb255.wedding.domain.viewmodel.GenericResponseViewModel;
import com.mdb255.wedding.domain.viewmodel.PurchaseViewModel;
import com.mdb255.wedding.domain.viewmodel.RegistryItemViewModel;
import com.mdb255.wedding.domain.viewmodel.RsvpViewModel;

public class WeddingServiceImpl implements WeddingService {
	
	private static Logger log = LoggerFactory.getLogger(WeddingServiceImpl.class);
	
	@Autowired
	private Emailer emailer;
	
	private HibernateConfigurator hibernateConfigurator;
	private String baseUrl;
	
	public WeddingServiceImpl(String dbUrl, String dbPw, String baseUrl) {
		this.hibernateConfigurator = new HibernateConfigurator(dbUrl, dbPw);
		this.baseUrl = baseUrl;
	}
	
	@Override
	public List<RegistryItemViewModel> getRegistryItems(String category) {
		Session session = hibernateConfigurator.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		List<RegistryItem> allRegistryItems = session.createCriteria(RegistryItem.class)
				.add(Restrictions.eq("category", category))
				.addOrder(Order.asc("isPurchasable"))
				.list();
		
		log.info("Got reg item results. count={}", allRegistryItems.size());
		
		List<RegistryItemViewModel> result = allRegistryItems.stream().map(ri -> RegistryItemTransformer.toViewModel(ri)).collect(Collectors.toList());
		
		session.getTransaction().commit();

		return result;
	}
	
	@Override
	public GenericResponseViewModel createPurchases(List<PurchaseViewModel> purchasesVm) {
		Session session = hibernateConfigurator.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		List<Purchase> newPurchaseList = purchasesVm.stream().map(vm -> PurchaseTransformer.fromViewModel(vm, session)).collect(Collectors.toList());
		
		for (Purchase purchaseItem : newPurchaseList) {
			Object newId = session.save(purchaseItem);
			log.info("Saved new purchase. id={}", newId);
		}
		session.getTransaction().commit();
		
		// Gift card email
		String giftPageUrl = createGiftCardUrl(purchasesVm);
		sendGiftCardEmail(purchasesVm.get(0).getPurchasedByEmail(), giftPageUrl);
		
		GenericResponseViewModel result = new GenericResponseViewModel();
		result.setSuccessful(true);
		result.setErrorMessage("");
		
		return result;
	}
	
	@Override
	public GenericResponseViewModel createRsvps(List<RsvpViewModel> rsvpVmList) {
		Session session = hibernateConfigurator.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		List<Rsvp> newRsvpList = rsvpVmList.stream().map(vm -> RsvpTransformer.fromViewModel(vm)).collect(Collectors.toList());
		
		for (Rsvp rsvpItem : newRsvpList) {
			Object newId = session.save(rsvpItem);
			log.info("Saved new rsvp. id={}", newId);
		}
		session.getTransaction().commit();
		
		GenericResponseViewModel result = new GenericResponseViewModel();
		result.setSuccessful(true);
		result.setErrorMessage("");
		
		return result;
	}
	
	@Override
	public List<RsvpViewModel> getRsvpsIndex() {
		Session session = hibernateConfigurator.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		
		List<Rsvp> allRsvps = session.createCriteria(Rsvp.class).list();
		List<RsvpViewModel> result = allRsvps.stream().map(r -> RsvpTransformer.toViewModel(r)).collect(Collectors.toList());
		
		session.getTransaction().commit();
		
		return result;
	}
	
	private String createGiftCardUrl(List<PurchaseViewModel> purchasesVm) {
		String result = null;
		List<String> itemsList = purchasesVm.stream().map(vm -> vm.getCustomDescription()).collect(Collectors.toList());
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			String from = URLEncoder.encode(purchasesVm.get(0).getPurchasedByNames(), "UTF-8");
			String items = URLEncoder.encode(mapper.writeValueAsString(itemsList), "UTF-8");
			result = MessageFormat.format("{0}/gift.html#/?from={1}&items={2}", baseUrl, from, items);
		} catch (UnsupportedEncodingException | JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
	
	private void sendGiftCardEmail(String emailRecipient, String giftPageUrl) {
		emailer.sendEmail(new GiftCardEmailComposer(emailRecipient, giftPageUrl));
	}
}
