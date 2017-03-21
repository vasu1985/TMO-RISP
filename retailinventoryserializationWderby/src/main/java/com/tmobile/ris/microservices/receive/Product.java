package com.tmobile.ris.microservices.receive;

public class Product {

	private String skuId;
	private String productType; // {Serialized, Nonserialized};
	private String state;// {Sellable, Return, New, Loaner, Demo};
	private String productName;
	private String currentStockingLocation;
	private boolean isInTransit;
	private boolean isHUAlreadyDelivered;
	private boolean isLostStolen;

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCurrentStockingLocation() {
		return currentStockingLocation;
	}

	public void setCurrentStockingLocation(String currentStockingLocation) {
		this.currentStockingLocation = currentStockingLocation;
	}

	public boolean isInTransit() {
		return isInTransit;
	}

	public void setInTransit(boolean isInTransit) {
		this.isInTransit = isInTransit;
	}

	public boolean isHUAlreadyDelivered() {
		return isHUAlreadyDelivered;
	}

	public void setHUAlreadyDelivered(boolean isHUAlreadyDelivered) {
		this.isHUAlreadyDelivered = isHUAlreadyDelivered;
	}

	public boolean isLostStolen() {
		return isLostStolen;
	}

	public void setLostStolen(boolean isLostStolen) {
		this.isLostStolen = isLostStolen;
	}

}
