package com.mdb255.wedding.domain.service;

import java.util.List;

import com.mdb255.wedding.domain.viewmodel.GenericResponseViewModel;
import com.mdb255.wedding.domain.viewmodel.PurchaseViewModel;
import com.mdb255.wedding.domain.viewmodel.RegistryItemViewModel;
import com.mdb255.wedding.domain.viewmodel.RsvpViewModel;

public interface WeddingService {

	List<RegistryItemViewModel> getRegistryItems(String category);
	
	GenericResponseViewModel createPurchases(List<PurchaseViewModel> purchasesVm);

	GenericResponseViewModel createRsvps(List<RsvpViewModel> rsvpsVm);
	
	List<RsvpViewModel> getRsvpsIndex();
}
