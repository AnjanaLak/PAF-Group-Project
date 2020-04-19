package com.paymentServiceFunction.PaymentProjectAPI;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Payment 
{
	private int paymentId;
	private String name;
	private String paymentType;
	private double paymentAmount;
	private String paymentDate;
	public int getPaymentId() {
		return paymentId;
		
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", name=" + name + ", paymentType=" + paymentType
				+ ", paymentAmount=" + paymentAmount + ", paymentDate=" + paymentDate + "]";
	}
	
	

}
