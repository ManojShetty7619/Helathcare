package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MedicineDetails {
	@Id
	private String tabletList;
	private int tabletCount;
//	private String patientPrescription;
//
//	public String getPatientPrescription() {
//		return patientPrescription;
//	}
//
//	public void setPatientPrescription(String patientPrescription) {
//		this.patientPrescription = patientPrescription;
//	}

	public String getTabletList() {
		return tabletList;
	}

	public void setTabletList(String tabletList) {
		this.tabletList = tabletList;
	}

	public int getTabletCount() {
		return tabletCount;
	}

	public void setTabletCount(int tabletCount) {
		this.tabletCount = tabletCount;
	}

}
