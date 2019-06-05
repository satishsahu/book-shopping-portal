package com.abc.portal.book.dto;

import java.util.List;

public class ReceiptDTO {

	private List<PurchaseDTO> purchases;
	private double totalAmount;
	
	public ReceiptDTO() {
	}
	
	public ReceiptDTO(List<PurchaseDTO> purchases, double totalAmount) {
		super();
		this.purchases = purchases;
		this.totalAmount = totalAmount;
	}

	public List<PurchaseDTO> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<PurchaseDTO> purchases) {
		this.purchases = purchases;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
