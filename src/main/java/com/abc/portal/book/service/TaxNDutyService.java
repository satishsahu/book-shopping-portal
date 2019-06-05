package com.abc.portal.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.portal.book.entity.TaxNDuty;
import com.abc.portal.book.repository.TaxNDutyRepository;

@Service
public class TaxNDutyService {

	@Autowired
	TaxNDutyRepository taxNDutyRepository;
	
	public List<TaxNDuty> getTaxNDutyDetails(){
		return taxNDutyRepository.findAll();
	}
	
	public List<TaxNDuty> saveAllTaxNDuties(List<TaxNDuty> taxNDuties){
		return taxNDutyRepository.saveAll(taxNDuties);
	}
	
	public TaxNDuty saveSingleTaxNDuty(TaxNDuty taxNDuty){
		return taxNDutyRepository.save(taxNDuty);
	}
}
