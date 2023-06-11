package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Pharmacy;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Integer> {

	Pharmacy findByPharmacyName(String pharmacyName);
}
