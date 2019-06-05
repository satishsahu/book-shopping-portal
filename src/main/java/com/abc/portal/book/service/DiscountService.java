package com.abc.portal.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.portal.book.entity.Discount;
import com.abc.portal.book.repository.BookRepository;
import com.abc.portal.book.repository.DiscountRepository;

@Service
public class DiscountService {

	@Autowired
	DiscountRepository discountRepository;

	public List<Discount> getDiscountDetails() {
		return discountRepository.findAll();
	}

	public List<Discount> saveAllDiscounts(List<Discount> discounts) {
		return discountRepository.saveAll(discounts);
	}
	
	public List<Discount> getDiscountbyCategory(String category) {
		return discountRepository.getDiscountbyCategory(category);
	}

	public Discount saveSingleDiscount(Discount discount) {
		return discountRepository.save(discount);
	}
}
