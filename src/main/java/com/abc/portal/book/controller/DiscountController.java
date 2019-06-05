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
import com.abc.portal.book.entity.Discount;
import com.abc.portal.book.service.BookService;
import com.abc.portal.book.service.DiscountService;

@RestController
@RequestMapping("/discount")
public class DiscountController {

	@Autowired
	DiscountService discountService;

	@GetMapping("/all")
	public ResponseEntity<List<Discount>> getDiscountDetails() {
		return new ResponseEntity<List<Discount>>(discountService.getDiscountDetails(), HttpStatus.OK);
	}

	@PostMapping("/save/all")
	public ResponseEntity<List<Discount>> saveDiscounts(@RequestBody List<Discount> discounts) {
		return new ResponseEntity<List<Discount>>(discountService.saveAllDiscounts(discounts), HttpStatus.CREATED);
	}

	@PostMapping("/save/single")
	public ResponseEntity<Discount> saveSingleBook(@RequestBody Discount discount) {
		return new ResponseEntity<Discount>(discountService.saveSingleDiscount(discount), HttpStatus.CREATED);
	}
}
