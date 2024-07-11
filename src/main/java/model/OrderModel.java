package model;

import java.time.LocalDate;

public class OrderModel {
	private String customerName;
	private LocalDate orderDate;
	private String customerAddress;
	private String phone;
	private String deliveryStatus;
	private String payableAmount;
	private String paymentMethod;
	
	public OrderModel() {}

	public OrderModel(String customerName, LocalDate orderDate, String customerAddress, String phone, String deliveryStatus, String payableAmount, String paymentMethod) {
		super();
		
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.customerAddress = customerAddress;
		this.phone = phone;
		this.deliveryStatus = deliveryStatus;
		this.payableAmount = payableAmount;
		this.paymentMethod = paymentMethod;
		
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(String payableAmount) {
		this.payableAmount = payableAmount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

}
