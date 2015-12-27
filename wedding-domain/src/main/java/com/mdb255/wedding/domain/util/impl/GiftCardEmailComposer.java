package com.mdb255.wedding.domain.util.impl;

import java.text.MessageFormat;
import java.util.Properties;

import javax.mail.PasswordAuthentication;

import com.mdb255.wedding.domain.util.EmailComposer;

public class GiftCardEmailComposer extends EmailComposer {
	
	public GiftCardEmailComposer(String emailRecipient, String giftPageUrl) {
		
		// FIXME Add gmail credentials (not encrypted - don't use personal account)
		this.sender = "example-gmail@gmail.com";
		String password = "example-password";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		this.mailSession = javax.mail.Session.getInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(sender, password);
				}
			}
		);
		
		this.recipient = emailRecipient;
		
		this.subject = "Your Wedding Registry gift card";
				
		StringBuilder messageBuilder = new StringBuilder()
		.append("<p>Hello.</p>")
		.append(MessageFormat.format("<p>Thanks again for your generous gift from our registry! You can access your printable gift card <a href=''{0}''>here</a>.</p>", giftPageUrl))
		.append("<p>Hope to see you on our big day!</p><br />")
		
		// FIXME Customize email message
		.append("<p>- Bride and Groom</p>");
		
		this.messageBody = messageBuilder.toString();
	}
}
