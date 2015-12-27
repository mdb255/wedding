package com.mdb255.wedding.domain.viewmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RsvpViewModel {

	private String firstName;
	private String lastName;
	private String email;
	private boolean attdReception;
	private boolean attdBoat;
	private boolean attdNone;
	private String dinner;
	private String dessert;
	private String guestType;
	private String submitterEmail;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAttdReception() {
		return attdReception;
	}

	public void setAttdReception(boolean attdReception) {
		this.attdReception = attdReception;
	}

	public boolean isAttdBoat() {
		return attdBoat;
	}

	public void setAttdBoat(boolean attdBoat) {
		this.attdBoat = attdBoat;
	}

	public boolean isAttdNone() {
		return attdNone;
	}

	public void setAttdNone(boolean attdNone) {
		this.attdNone = attdNone;
	}

	public String getDinner() {
		return dinner;
	}

	public void setDinner(String dinner) {
		this.dinner = dinner;
	}

	public String getDessert() {
		return dessert;
	}

	public void setDessert(String dessert) {
		this.dessert = dessert;
	}

	public String getGuestType() {
		return guestType;
	}

	public void setGuestType(String guestType) {
		this.guestType = guestType;
	}

	public String getSubmitterEmail() {
		return submitterEmail;
	}

	public void setSubmitterEmail(String submitterEmail) {
		this.submitterEmail = submitterEmail;
	}

	@Override
	public String toString() {
		return "RsvpViewModel [firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", attdReception="
				+ attdReception + ", attdBoat=" + attdBoat + ", attdNone="
				+ attdNone + ", dinner=" + dinner + ", dessert=" + dessert
				+ ", guestType=" + guestType + ", submitterEmail="
				+ submitterEmail + "]";
	}
}
