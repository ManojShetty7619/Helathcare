package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pharmacy {
	@Id
	private int pharmacyId;
	private String pharmacyName;
	private String delivaryManager;
	private String delivaryteam;

	public int getPharmacyId() {
		return pharmacyId;
	}

	public void setPharmacyId(int pharmacyId) {
		this.pharmacyId = pharmacyId;
	}

	public String getPharmacyName() {
		return pharmacyName;
	}

	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}

	public String getDelivaryManager() {
		return delivaryManager;
	}

	public void setDelivaryManager(String delivaryManager) {
		this.delivaryManager = delivaryManager;
	}

	public String getDelivaryteam() {
		return delivaryteam;
	}

	public void setDelivaryteam(String delivaryteam) {
		this.delivaryteam = delivaryteam;
	}

}
