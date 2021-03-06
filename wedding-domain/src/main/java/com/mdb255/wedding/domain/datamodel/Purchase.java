package com.mdb255.wedding.domain.datamodel;

// Generated by Hibernate Tools

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Purchase generated by hbm2java
 */
@Entity
@Table(name = "purchase", catalog = "weddingdb")
public class Purchase implements java.io.Serializable {

	private Integer purchaseId;
	private RegistryItem registryItem;
	private String purchasedByNames;
	private String purchasedByEmail;
	private String customDescription;
	private BigDecimal price;
	private String deliveryMethod;
	private Date createDt;

	public Purchase() {
	}

	public Purchase(RegistryItem registryItem, String purchasedByNames,
			String purchasedByEmail, String customDescription,
			BigDecimal price, String deliveryMethod, Date createDt) {
		this.registryItem = registryItem;
		this.purchasedByNames = purchasedByNames;
		this.purchasedByEmail = purchasedByEmail;
		this.customDescription = customDescription;
		this.price = price;
		this.deliveryMethod = deliveryMethod;
		this.createDt = createDt;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "purchase_id", unique = true, nullable = false)
	public Integer getPurchaseId() {
		return this.purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "registry_item_id", nullable = false)
	public RegistryItem getRegistryItem() {
		return this.registryItem;
	}

	public void setRegistryItem(RegistryItem registryItem) {
		this.registryItem = registryItem;
	}

	@Column(name = "purchased_by_names", nullable = false, length = 75)
	public String getPurchasedByNames() {
		return this.purchasedByNames;
	}

	public void setPurchasedByNames(String purchasedByNames) {
		this.purchasedByNames = purchasedByNames;
	}

	@Column(name = "purchased_by_email", nullable = false, length = 60)
	public String getPurchasedByEmail() {
		return this.purchasedByEmail;
	}

	public void setPurchasedByEmail(String purchasedByEmail) {
		this.purchasedByEmail = purchasedByEmail;
	}

	@Column(name = "custom_description", nullable = false, length = 60)
	public String getCustomDescription() {
		return this.customDescription;
	}

	public void setCustomDescription(String customDescription) {
		this.customDescription = customDescription;
	}

	@Column(name = "price", nullable = false, precision = 10)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "delivery_method", nullable = false, length = 10)
	public String getDeliveryMethod() {
		return this.deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_dt", nullable = false, length = 19)
	public Date getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

}
