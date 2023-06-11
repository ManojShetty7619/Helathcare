package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.MedicineDetailsRepository;
import com.app.dao.PatientRepository;
import com.app.dao.PharmacyRepository;
import com.app.model.MedicineDetails;
import com.app.model.Patient;
import com.app.model.Pharmacy;

@Service
public class HealthCareService {
	@Autowired
	private MedicineDetailsRepository medicineDetailsRepository;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private PharmacyRepository pharmacyRepository;

	public MedicineDetails addMedicineDetails(MedicineDetails medicineDetails) {
		return medicineDetailsRepository.save(medicineDetails);
	}

	public List<MedicineDetails> getMedidineList() {
		return medicineDetailsRepository.findAll();
	}

	public Patient addPatient(Patient patient) {
		return patientRepository.save(patient);
	}

	public List<Patient> getPatientDetails() {
		return patientRepository.findAll();
	}

	public Pharmacy addPharmacyDetails(Pharmacy pharmacy) {
		return pharmacyRepository.save(pharmacy);
	}

	public List<Pharmacy> getPharmacydetails() {
		return pharmacyRepository.findAll();
	}

}
