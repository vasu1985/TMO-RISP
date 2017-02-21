package com.tmobile.ris.microservices.receive;

public class Device extends Product {

	private String serialNumber;
	private String serialType;
	private boolean isInTransit;
	private boolean isHUAlreadyDelivered;
	private boolean isLostStolen;
	private boolean isValidSerialNumber;

	public Device() {

	}

	public Device(String serialNumber, String serialType, String productName, boolean isInTransit,
			boolean isHUAlreadyDelivered, boolean isLostStolen, boolean isValidSerialNumber,
			String currentStockingLocation) {
		super();
		this.serialNumber = serialNumber;
		this.serialType = serialType;
		this.isInTransit = isInTransit;
		this.isHUAlreadyDelivered = isHUAlreadyDelivered;
		this.isLostStolen = isLostStolen;
		this.isValidSerialNumber = isValidSerialNumber;
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

}
