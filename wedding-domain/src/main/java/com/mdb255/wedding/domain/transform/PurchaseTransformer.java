package com.mdb255.wedding.domain.transform;

import java.util.Date;

import org.hibernate.Session;

import com.mdb255.wedding.domain.datamodel.Purchase;
import com.mdb255.wedding.domain.datamodel.RegistryItem;
import com.mdb255.wedding.domain.viewmodel.PurchaseViewModel;

public class PurchaseTransformer {

	public static Purchase fromViewModel(PurchaseViewModel vm, Session currentSession) {
		Purchase result = new Purchase();
		result.setCreateDt(new Date());
		result.setCustomDescription(vm.getCustomDescription());
		result.setDeliveryMethod(vm.getDeliveryMethod());
		result.setPrice(vm.getPrice());
		result.setPurchasedByEmail(vm.getPurchasedByEmail());
		result.setPurchasedByNames(vm.getPurchasedByNames());
		
		RegistryItem ri = (RegistryItem) currentSession.load(RegistryItem.class, vm.getRegistryItemId());
		result.setRegistryItem(ri);

		return result;
	}
}
