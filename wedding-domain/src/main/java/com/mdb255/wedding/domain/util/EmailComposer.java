package com.mdb255.wedding.domain.util;

import lombok.Getter;

public abstract class EmailComposer {
	
	// Ideally we don't depend on a concrete mailer implementation like this, but convenient for storage for now
	@Getter protected javax.mail.Session mailSession;
	
	@Getter protected String recipient;
	
	@Getter protected String sender;
	
	@Getter protected String subject;
	
	@Getter protected String messageBody;
	
	// Doesn't include mailSession
	@Override
	public String toString() {
		return "EmailComposer [recipient=" + recipient + ", sender=" + sender
				+ ", subject=" + subject + ", messageBody=" + messageBody + "]";
	}
}
