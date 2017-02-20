package com.tmobile.ups.microservices.receive;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stock {

	@Id
	private String stockinLocId;
	private String stockingLocNam;
	private String storeType;
	private boolean isAbleToRecieve;
	private boolean isDarkStore;

	public Stock() {

	}

	public Stock(String stockinLocId, String stockingLocNam, String storeType, boolean isAbleToRecieve,
			boolean isDarkStore) {
		super();
		this.stockinLocId = stockinLocId;
		this.stockingLocNam = stockingLocNam;
		this.storeType = storeType;
		this.isAbleToRecieve = isAbleToRecieve;
		this.isDarkStore = isDarkStore;
	}

	public String getStockinLocId() {
		return stockinLocId;
	}

	public void setStockinLocId(String stockinLocId) {
		this.stockinLocId = stockinLocId;
	}

	public String getStockingLocNam() {
		return stockingLocNam;
	}

	public void setStockingLocNam(String stockingLocNam) {
		this.stockingLocNam = stockingLocNam;
	}

	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}

	public boolean isAbleToRecieve() {
		return isAbleToRecieve;
	}

	public void setAbleToRecieve(boolean isAbleToRecieve) {
		this.isAbleToRecieve = isAbleToRecieve;
	}

	public boolean isDarkStore() {
		return isDarkStore;
	}

	public void setDarkStore(boolean isDarkStore) {
		this.isDarkStore = isDarkStore;
	}


}
