package com.mdb255.wedding.domain.viewmodel;

import java.math.BigDecimal;

public class PurchaseViewModel {

	private Integer registryItemId;
	private String purchasedByNames;
	private String purchasedByEmail;
	private String customDescription;
	private BigDecimal price;
	private String deliveryMethod;

	public Integer getRegistryItemId() {
		return registryItemId;
	}

	public void setRegistryItemId(Integer registryItemId) {
		this.registryItemId = registryItemId;
	}

	public String getPurchasedByNames() {
		return purchasedByNames;
	}

	public void setPurchasedByNames(String purchasedByNames) {
		this.purchasedByNames = purchasedByNames;
	}

	public String getPurchasedByEmail() {
		return purchasedByEmail;
	}

	public void setPurchasedByEmail(String purchasedByEmail) {
		this.purchasedByEmail = purchasedByEmail;
	}

	public String getCustomDescription() {
		return customDescription;
	}

	public void setCustomDescription(String customDescription) {
		this.customDescription = customDescription;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}
	
	@Override
	public String toString() {
		return "PurchaseViewModel [registryItemId=" + registryItemId
				+ ", purchasedByNames=" + purchasedByNames
				+ ", purchasedByEmail=" + purchasedByEmail
				+ ", customDescription=" + customDescription + ", price="
				+ price + ", deliveryMethod=" + deliveryMethod + "]";
	}
}
