package com.mdb255.wedding.domain.transform;

import com.mdb255.wedding.domain.datamodel.Rsvp;
import com.mdb255.wedding.domain.viewmodel.RsvpViewModel;

public class RsvpTransformer {

	public static Rsvp fromViewModel(RsvpViewModel vm) {
		Rsvp result = new Rsvp();
		result.setFirstName(vm.getFirstName());
		result.setLastName(vm.getLastName());
		result.setEmail(vm.getEmail());
		result.setAttdReception(vm.isAttdReception());
		result.setAttdBoat(vm.isAttdBoat());
		result.setAttdNone(vm.isAttdNone());
		result.setDinner(vm.getDinner());
		result.setDessert(vm.getDessert());
		result.setGuestType(vm.getGuestType());
		result.setSubmitterEmail(vm.getSubmitterEmail());
		
		return result;
	}
	
	public static RsvpViewModel toViewModel(Rsvp model) {
		RsvpViewModel result = new RsvpViewModel();
		result.setFirstName(model.getFirstName());
		result.setLastName(model.getLastName());
		result.setEmail(model.getEmail());
		result.setAttdReception(model.isAttdReception());
		result.setAttdBoat(model.isAttdBoat());
		result.setAttdNone(model.isAttdNone());
		result.setDinner(model.getDinner());
		result.setDessert(model.getDessert());
		result.setGuestType(model.getGuestType());
		result.setSubmitterEmail(model.getSubmitterEmail());
		
		return result;
	}
}
