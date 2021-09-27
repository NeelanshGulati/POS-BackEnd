package com.nagarro.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Orders {
	@Id
	private int oId;
	private String date;
	private int totalPrice;
	private int customerId;

	public int getoId() {
		return oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Orders [oId=" + oId + ", date=" + date + ", totalPrice=" + totalPrice + ", customerId=" + customerId
				+ "]";
	}

	public Orders(int oId, String date, int totalPrice, int customerId) {
		super();
		this.oId = oId;
		this.date = date;
		this.totalPrice = totalPrice;
		this.customerId = customerId;
	}

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

}
