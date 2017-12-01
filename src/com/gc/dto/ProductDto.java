package com.gc.dto;

import java.io.Serializable;

public class ProductDto implements Serializable {
	/**
	 * The serialization runtime associates with each serializable class a version
	 * number, called a serialVersionUID, which is used during deserialization to
	 * verify that the sender and receiver of a serialized object have loaded
	 * classes for that object that are compatible with respect to serialization.
	 */
	private static final long serialVersionUID = 1L;
	private String itemName;	
	private String description;
	private int quantity;
	private double itemPrice;

	public ProductDto() {

		
	}

	public ProductDto(String itemName, String description, int quantity, double itemPrice) {
		super();
		this.itemName = itemName;
		this.quantity = quantity;
		this.description = description;
		this.itemPrice = itemPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "Primary key assigned as 0, represents us assigning null to the query: " + itemName +  ", description" + description + ", quantity" + quantity
				+ ", itemPrice" + itemPrice;
	}

}
