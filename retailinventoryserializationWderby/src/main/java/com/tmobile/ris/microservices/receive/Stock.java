package com.tmobile.ris.microservices.receive;

import java.util.concurrent.atomic.AtomicLong;
import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;


public class Stock implements PdxSerializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static AtomicLong COUNTER = new AtomicLong(0L);
	//private static final long serialVersionUID = 1L;
	
	transient private Long stockingLocationId;
	transient private String stockingLocNam;
	transient private String storeType;
	transient private boolean isAbleToRecieve;
	transient private boolean isDarkStore;

	public Stock(){
		 stockingLocationId = COUNTER.incrementAndGet();
		
	}

	public Stock(Long stockinLocId, String stockingLocNam, String storeType, boolean isAbleToRecieve,
			boolean isDarkStore) {
		super();
		this.stockingLocationId = stockinLocId;
		this.stockingLocNam = stockingLocNam;
		this.storeType = storeType;
		this.isAbleToRecieve = isAbleToRecieve;
		this.isDarkStore = isDarkStore;
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
	@Override
	public String toString() {
		return "Stock [stockingLocationId=" + stockingLocationId + ", stockingLocNam=" + stockingLocNam + ", storeType="
				+ storeType + ", isAbleToRecieve=" + isAbleToRecieve + ", isDarkStore=" + isDarkStore + "]";
	}
	//private Object unreadFields;
	public void fromData(PdxReader reader) {
		//this.unreadFields = reader.readUnreadFields();
		this.stockingLocationId = reader.readLong("stockingLocationId");
		this.stockingLocNam = reader.readString("stockingLocNam");
		this.storeType = reader.readString("storeType");
		this.isAbleToRecieve = reader.readBoolean("isAbleToRecieve");
		this.isDarkStore = reader.readBoolean("isDarkStore");		
	}

	public void toData(PdxWriter writer) {
		//writer.writeUnreadFields(this.unreadFields);
		writer.writeLong("stockingLocationId", stockingLocationId)
		.writeString("stockingLocNam", stockingLocNam)
		.writeString("storeType", storeType)
		.writeBoolean("isAbleToRecieve", isAbleToRecieve)
		.writeBoolean("isDarkStore", isDarkStore);
		
	}

}
