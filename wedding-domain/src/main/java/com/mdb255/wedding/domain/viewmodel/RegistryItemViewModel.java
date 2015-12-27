package com.mdb255.wedding.domain.viewmodel;

import java.util.List;

public class RegistryItemViewModel {

	private int registryItemId;
	private String category;
	private Boolean isPurchasable;
	private Integer qtyRemaining;
	private List<Integer> prices;
	private String priceRange;
	private String description;
	private String imageUrl;
	
	public int getRegistryItemId() {
		return registryItemId;
	}

	public void setRegistryItemId(int registryItemId) {
		this.registryItemId = registryItemId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Boolean getIsPurchasable() {
		return isPurchasable;
	}

	public void setIsPurchasable(Boolean isPurchasable) {
		this.isPurchasable = isPurchasable;
	}

	public Integer getQtyRemaining() {
		return qtyRemaining;
	}

	public void setQtyRemaining(Integer qtyRemaining) {
		this.qtyRemaining = qtyRemaining;
	}

	public List<Integer> getPrices() {
		return prices;
	}

	public void setPrices(List<Integer> prices) {
		this.prices = prices;
	}
	
	public String getPriceRange() {
		return priceRange;
	}

	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	@Override
	public String toString() {
		return "RegistryItemViewModel [registryItemId=" + registryItemId
				+ ", category=" + category + ", isPurchasable=" + isPurchasable
				+ ", qtyRemaining=" + qtyRemaining + ", prices=" + prices
				+ ", priceRange=" + priceRange + ", description=" + description
				+ ", imageUrl=" + imageUrl + "]";
	}
}
