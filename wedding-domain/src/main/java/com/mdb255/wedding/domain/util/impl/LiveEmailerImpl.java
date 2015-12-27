package com.mdb255.wedding.domain.util.impl;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mdb255.wedding.domain.util.EmailComposer;
import com.mdb255.wedding.domain.util.Emailer;

public class LiveEmailerImpl implements Emailer {
	
	private static Logger log = LoggerFactory.getLogger(LiveEmailerImpl.class);

	@Override
	public void sendEmail(EmailComposer composer) {
		try {
			Message message = new MimeMessage(composer.getMailSession());
			message.setFrom(new InternetAddress(composer.getSender()));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(composer.getRecipient()));
			message.setSubject(composer.getSubject());
			message.setContent(composer.getMessageBody(), "text/html");
 
			Transport.send(message);
			log.info("Done sending email");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
