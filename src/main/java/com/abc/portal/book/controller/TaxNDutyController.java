package com.abc.portal.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.portal.book.entity.Book;
import com.abc.portal.book.entity.TaxNDuty;
import com.abc.portal.book.service.BookService;
import com.abc.portal.book.service.TaxNDutyService;

@RestController
@RequestMapping("/taxnduty")
public class TaxNDutyController {

	@Autowired
	TaxNDutyService taxNDutyService;

	@GetMapping("/all")
	public ResponseEntity<List<TaxNDuty>> getTaxNDutyDetails() {
		return new ResponseEntity<List<TaxNDuty>>(taxNDutyService.getTaxNDutyDetails(), HttpStatus.OK);
	}

	@PostMapping("/save/all")
	public ResponseEntity<List<TaxNDuty>> saveTaxNDuties(@RequestBody List<TaxNDuty> taxNDuties) {
		return new ResponseEntity<List<TaxNDuty>>(taxNDutyService.saveAllTaxNDuties(taxNDuties), HttpStatus.CREATED);
	}

	@PostMapping("/save/single")
	public ResponseEntity<TaxNDuty> saveSingleBook(@RequestBody TaxNDuty taxNDuty) {
		return new ResponseEntity<TaxNDuty>(taxNDutyService.saveSingleTaxNDuty(taxNDuty), HttpStatus.CREATED);
	}
	
}
