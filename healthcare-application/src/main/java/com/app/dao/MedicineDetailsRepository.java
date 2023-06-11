package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.MedicineDetails;

@Repository
public interface MedicineDetailsRepository extends JpaRepository<MedicineDetails, String> {

	MedicineDetails findByTabletList(String tabletList);

}
