package com.abc.portal.book.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.portal.book.dto.PurchaseDTO;
import com.abc.portal.book.dto.ReceiptDTO;
import com.abc.portal.book.dto.TaxDTO;
import com.abc.portal.book.entity.Book;
import com.abc.portal.book.entity.Discount;
import com.abc.portal.book.entity.TaxNDuty;
import com.abc.portal.book.repository.BookRepository;
import com.abc.portal.book.repository.DiscountRepository;
import com.abc.portal.book.repository.TaxNDutyRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	DiscountRepository discountRepository;

	@Autowired
	TaxNDutyRepository taxNDutyRepository;

	public List<Book> getBookDetails() {
		return bookRepository.findAll();
	}

	public List<Book> saveAllBooks(List<Book> books) {
		return bookRepository.saveAll(books);
	}

	public Book saveSingleBook(Book book) {
		return bookRepository.save(book);
	}

	public ReceiptDTO purchase(List<Long> bookIds) {

		List<TaxNDuty> taxNDutys = taxNDutyRepository.findAll();
		List<PurchaseDTO> purchaseDtos = new ArrayList<>();
		Double totalAmount = 0d;
		for (Long bookId : bookIds) {
			Book book = bookRepository.findById(bookId).get();

			List<TaxDTO> taxDtos = new ArrayList<>();
			// non-mgmt-books
			if (discountRepository.getDiscountbyCategory(book.getCategory()).isEmpty()) {
				if (book.isImported()) {
					for (TaxNDuty taxNDuty : taxNDutys) {
						if (taxNDuty.getType().equalsIgnoreCase("imported")) {
							TaxDTO tax = new TaxDTO(taxNDuty.getType(), taxNDuty.getTax());
							taxDtos.add(tax);
							totalAmount += book.getPrice() - book.getPrice() * taxNDuty.getTax() / 100;
						}
					}
					PurchaseDTO purchaseDto = new PurchaseDTO(book.getName(), taxDtos);
					purchaseDtos.add(purchaseDto);
				} else {
					for (TaxNDuty taxNDuty : taxNDutys) {
						TaxDTO tax = new TaxDTO(taxNDuty.getType(), taxNDuty.getTax());
						taxDtos.add(tax);
						totalAmount += book.getPrice() - book.getPrice() * taxNDuty.getTax() / 100;
					}
					PurchaseDTO purchaseDto = new PurchaseDTO(book.getName(), taxDtos);
					purchaseDtos.add(purchaseDto);
				}
			} else {// mgmt-books

			}
		}

		if (totalAmount <= 500) {
			totalAmount = totalAmount - totalAmount * 5 / 100;
		} else if (totalAmount > 500 && totalAmount <= 1000) {
			totalAmount = totalAmount - totalAmount * 10 / 100;
		} else if (totalAmount > 1000 && totalAmount <= 1500) {
			totalAmount = totalAmount - totalAmount * 15 / 100;
		}

		ReceiptDTO receiptDTO = new ReceiptDTO(purchaseDtos, Math.round(totalAmount));
		return receiptDTO;
	}
}
