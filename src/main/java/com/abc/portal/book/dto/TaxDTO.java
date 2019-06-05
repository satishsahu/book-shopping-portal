package com.abc.portal.book.dto;

public class TaxDTO {

	private String taxType;
	private int tax;
	
	public TaxDTO() {
	}
	
	public TaxDTO(String taxType, int tax) {
		super();
		this.taxType = taxType;
		this.tax = tax;
	}

	public String getTaxType() {
		return taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}
	
}
