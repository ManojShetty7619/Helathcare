package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient {
	@Id
	private int patientId;
	private String patientName;
	private String password;
	// private String patientPrescription;
	private int tablets;

	public int getTablets() {
		return tablets;
	}

	public void setTablets(int tablets) {
		this.tablets = tablets;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

//	public String getPatientPrescription() {
//		return patientPrescription;
//	}
//
//	public void setPatientPrescription(String patientPrescription) {
//		this.patientPrescription = patientPrescription;
//	}

}
