package com.mdb255.wedding.test.domain.service;

import java.util.List;

import com.mdb255.wedding.domain.datamodel.Purchase;
import com.mdb255.wedding.domain.datamodel.RegistryItem;

public interface WeddingTestService {

	Long createRegistryItem(RegistryItem model);
	
	List<Purchase> getPurchasesIndex(String purchasedByEmail);

	void deletePurchasesByEmail(String purchasedByEmail);

	void deleteRegistryItemsByDescription(String description);
}
