package com.forex.wizard.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.forex.wizard.entity.Purchase;

@Component
public interface PurchaseDao extends JpaRepository<Purchase, Integer>  {
	public Purchase findById(int id);
	
	@Query("SELECT p FROM Purchase p WHERE p.membership = :periodOfMonth")
	public List<Purchase> getDetailsOfSubscribersAccordingToThePeriodOfMonth(@Param("periodOfMonth") String periodOfMonth);
}
