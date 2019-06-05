package com.abc.portal.book.dto;

import java.util.List;

public class PurchaseDTO {

	private String BookName;
	private List<TaxDTO> taxes;

	public PurchaseDTO() {
	}

	public PurchaseDTO(String bookName, List<TaxDTO> taxes) {
		super();
		BookName = bookName;
		this.taxes = taxes;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public List<TaxDTO> getTaxes() {
		return taxes;
	}

	public void setTaxes(List<TaxDTO> taxes) {
		this.taxes = taxes;
	}

}
