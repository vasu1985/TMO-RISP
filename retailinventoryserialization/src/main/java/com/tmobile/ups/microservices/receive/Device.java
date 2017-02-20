package com.tmobile.ups.microservices.receive;

public class Device {

	private String serialNumber;
	private String serialType;
	private String productName;
	private boolean isInTransit;
	private boolean isHUAlreadyDelivered;
	private boolean isLostStolen;
	private boolean isValidSerialNumber;
	private String currentStockingLocation;

	public Device() {

	}

	public Device(String serialNumber, String serialType, String productName, boolean isInTransit,
			boolean isHUAlreadyDelivered, boolean isLostStolen, boolean isValidSerialNumber,
			String currentStockingLocation) {
		super();
		this.serialNumber = serialNumber;
		this.serialType = serialType;
		this.productName = productName;
		this.isInTransit = isInTransit;
		this.isHUAlreadyDelivered = isHUAlreadyDelivered;
		this.isLostStolen = isLostStolen;
		this.isValidSerialNumber = isValidSerialNumber;
		this.currentStockingLocation = currentStockingLocation;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getSerialType() {
		return serialType;
	}

	public void setSerialType(String serialType) {
		this.serialType = serialType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public boolean isValidSerialNumber() {
		return isValidSerialNumber;
	}

	public void setValidSerialNumber(boolean isValidSerialNumber) {
		this.isValidSerialNumber = isValidSerialNumber;
	}

	public String getCurrentStockingLocation() {
		return currentStockingLocation;
	}

	public void setCurrentStockingLocation(String currentStockingLocation) {
		this.currentStockingLocation = currentStockingLocation;
	}

	

}
