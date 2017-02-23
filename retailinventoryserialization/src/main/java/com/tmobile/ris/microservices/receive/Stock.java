package com.tmobile.ris.microservices.receive;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long stockingLocationId;
	private String stockingLocNam;
	private String storeType;
	private boolean ableToRecieve;
	private boolean darkStore;

	public Stock() {

	}

	public Stock(Long stockinLocId, String stockingLocNam, String storeType, boolean isAbleToRecieve,
			boolean isDarkStore) {
		super();
		this.stockingLocationId = stockinLocId;
		this.stockingLocNam = stockingLocNam;
		this.storeType = storeType;
		this.ableToRecieve = isAbleToRecieve;
		this.darkStore = isDarkStore;
	}

	public Long getStockinLocId() {
		return stockingLocationId;
	}

	public void setStockinLocId(Long stockinLocId) {
		this.stockingLocationId = stockinLocId;
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
		return ableToRecieve;
	}

	public void setAbleToRecieve(boolean isAbleToRecieve) {
		this.ableToRecieve = isAbleToRecieve;
	}

	public boolean isDarkStore() {
		return darkStore;
	}

	public void setDarkStore(boolean isDarkStore) {
		this.darkStore = isDarkStore;
	}

}
