package com.mdb255.wedding.test.domain.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mdb255.wedding.domain.datamodel.Purchase;
import com.mdb255.wedding.domain.datamodel.RegistryItem;
import com.mdb255.wedding.domain.util.HibernateConfigurator;
import com.mdb255.wedding.test.domain.service.WeddingTestService;

public class WeddingTestServiceImpl implements WeddingTestService {
	
	private static Logger log = LoggerFactory.getLogger(WeddingTestServiceImpl.class);
	
	private HibernateConfigurator hibernateConfigurator;
	
	public WeddingTestServiceImpl(String dbUrl, String dbPw) {
		hibernateConfigurator = new HibernateConfigurator(dbUrl, dbPw);
	}

	@Override
	public Long createRegistryItem(RegistryItem model) {
		Session session = hibernateConfigurator.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		
		Object newId = session.save(model);
		log.info("Saved new registryItem. id={}", newId);
		
		session.getTransaction().commit();
		
		return Long.parseLong(newId.toString());
	}
	
	@Override
	public List<Purchase> getPurchasesIndex(String purchasedByEmail) {
		Session session = hibernateConfigurator.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		List<Purchase> result = session.createCriteria(Purchase.class)
				.add(Restrictions.eq("purchasedByEmail", purchasedByEmail))
				.list();
		
		session.getTransaction().commit();
		
		// Remove the RegistryItem to avoid object with circular references
		for (Purchase purchaseItem : result) {
			purchaseItem.setRegistryItem(null);
		}
		
		return result;
	}

	@Override
	public void deletePurchasesByEmail(String purchasedByEmail) {
		log.info("Start delete purchase. purchasedByEmail={}", purchasedByEmail);
		
		Session session = hibernateConfigurator.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		
		Purchase purchaseToDelete = (Purchase) session.createCriteria(Purchase.class)
				.add(Restrictions.eq("purchasedByEmail", purchasedByEmail))
				.uniqueResult();
		
		session.delete(purchaseToDelete);
		log.info("Done delete purchase");
		
		session.getTransaction().commit();
	}

	@Override
	public void deleteRegistryItemsByDescription(String description) {
		log.info("Start delete registryItem. description={}", description);
		
		Session session = hibernateConfigurator.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		
		RegistryItem registryItem = (RegistryItem) session.createCriteria(RegistryItem.class)
				.add(Restrictions.eq("description", description))
				.uniqueResult();
		
		session.delete(registryItem);
		log.info("Done delete registryItem");
		
		session.getTransaction().commit();
	}
}
