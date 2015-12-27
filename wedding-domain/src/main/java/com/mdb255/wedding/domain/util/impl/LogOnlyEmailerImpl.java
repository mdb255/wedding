package com.mdb255.wedding.domain.util.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mdb255.wedding.domain.util.EmailComposer;
import com.mdb255.wedding.domain.util.Emailer;

public class LogOnlyEmailerImpl implements Emailer {
	
	private static Logger log = LoggerFactory.getLogger(LogOnlyEmailerImpl.class);

	@Override
	public void sendEmail(EmailComposer composer) {
		log.info("Log-only implementation of email sender. details=" + composer.toString());
	}
}
