package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.MedicineDetailsRepository;
import com.app.dao.PatientRepository;
import com.app.dao.PharmacyRepository;
import com.app.model.MedicineDetails;
import com.app.model.Patient;
import com.app.model.Pharmacy;
import com.app.service.HealthCareService;

@RestController
public class HealthCareController {

	@Autowired
	private HealthCareService medicineDetailsService;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private PharmacyRepository pharmacyRepository;

	@Autowired
	private MedicineDetailsRepository medicineDetailsRepository;

	@RequestMapping("/addMedicineList")
	public MedicineDetails addMedicineList(@RequestBody MedicineDetails medicineDetails) {
		return medicineDetailsService.addMedicineDetails(medicineDetails);
	}

	@GetMapping("/getMedicineList")
	public List<MedicineDetails> getmedicineList() {
		return medicineDetailsService.getMedidineList();
	}

	@RequestMapping("/addPatientDetails")
	public Patient addPatientdetails(@RequestBody Patient patient) {
		return medicineDetailsService.addPatient(patient);
	}

	@GetMapping("/getpatientDetails")
	public List<Patient> getPatientDetails() {
		return medicineDetailsService.getPatientDetails();
	}

	@RequestMapping("/addPharmacydetails")
	public Pharmacy addPharmacyDetails(@RequestBody Pharmacy pharmacy) {
		return medicineDetailsService.addPharmacyDetails(pharmacy);
	}

	@GetMapping("/getPharmacyDetails")
	public List<Pharmacy> getPharmacyDetails() {
		return medicineDetailsService.getPharmacydetails();
	}

	@PostMapping("/validatepatient")
	public String validatePatient(HttpServletRequest httpServletRequest) {

		String str = "";
		String patientName = httpServletRequest.getHeader("patientName");
		String password = httpServletRequest.getHeader("password");
		String tabletList = httpServletRequest.getHeader("patientPrescription");
		String pharmacyName = httpServletRequest.getHeader("pharmacyName");

		String requiredTablet = httpServletRequest.getHeader("requiredTablet");
		int patientNeedTablet = Integer.valueOf(requiredTablet);

		Patient patient = patientRepository.findByPatientName(patientName);
		int tabletbefororder = patient.getTablets();

		MedicineDetails medicineLists = medicineDetailsRepository.findByTabletList(tabletList);
		String medicineList = medicineLists.getTabletList();
		int tabletCount = medicineLists.getTabletCount();

		Pharmacy pharmacy = pharmacyRepository.findByPharmacyName(pharmacyName);

		if (password.equals(patient.getPassword())) {
//			pharmacyRepository.save(pharmacy);
			str = "Valid patient";
			System.out.println(str);
			if (tabletList.equals(medicineList)) {

//				pharmacy.getDelivaryManager();
				System.out.println("Start order");

				if (patientNeedTablet <= tabletCount) {

					str = "select tablets :";
					System.out.println(str);
					System.out.println("selected tablets :" + patientNeedTablet);
					tabletCount = tabletCount - patientNeedTablet;
					int tabletAfterOrder = tabletbefororder + patientNeedTablet;
					String manager = pharmacy.getDelivaryManager();
					String delivaryTeam = pharmacy.getDelivaryteam();

					if (manager != null && delivaryTeam != null) {
						str = "Started delivary";
						System.out.println(str);

						if (tabletAfterOrder > tabletbefororder) {
							str = "order delivered";
						} else {
							str = "oder not delivered";
						}
					} else {
						str = "Delivary team is not available";
					}

				} else {
					str = "requred amount of table is not available";
				}

			} else {
				str = "Medicine out of stock";
			}
		} else {
			str = "Invalid Patient";
		}

		return str;

	}
}
