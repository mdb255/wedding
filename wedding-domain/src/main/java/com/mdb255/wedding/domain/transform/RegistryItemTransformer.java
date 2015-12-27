package com.mdb255.wedding.domain.transform;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.mdb255.wedding.domain.datamodel.RegistryItem;
import com.mdb255.wedding.domain.viewmodel.RegistryItemViewModel;

public class RegistryItemTransformer {

	public static RegistryItemViewModel toViewModel(RegistryItem model) {
		RegistryItemViewModel result = new RegistryItemViewModel();
		
		result.setRegistryItemId(model.getRegistryItemId());
		result.setCategory(model.getCategory());
		result.setDescription(model.getDescription());
		result.setIsPurchasable(model.isIsPurchasable());
		
		if (model.isIsPurchasable()) {
			result.setImageUrl(model.getDescription() + ".jpeg");
		} else {
			result.setImageUrl("Your Suggestion.jpeg");
		}
		
		int qtyRemaining = model.getInitialStock() - model.getPurchases().size();
		if (qtyRemaining < 0) {
			qtyRemaining = 0;
		}
		result.setQtyRemaining(qtyRemaining);
		
		List<String> strPrices = Arrays.asList(StringUtils.split(model.getPriceRange(), ","));
		List<Integer> prices = strPrices.stream().map(p -> Integer.parseInt(p)).collect(Collectors.toList());
		result.setPrices(prices);
		
		if (strPrices.size() > 1) {
			result.setPriceRange(MessageFormat.format("(${0} to ${1})", strPrices.get(0), strPrices.get(strPrices.size() - 1)));
		}
		
		return result;
	}
}
