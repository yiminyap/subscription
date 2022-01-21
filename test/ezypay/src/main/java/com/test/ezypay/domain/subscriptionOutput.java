package com.test.ezypay.domain;

import java.math.BigDecimal;
import java.util.Set;

public class subscriptionOutput {
	private BigDecimal amount;
	private String subscriptionType;
	private Set<String> invoiceDates;

	public subscriptionOutput() {

	}

	public subscriptionOutput(BigDecimal amount, String subscriptionType, Set<String> invoiceDates) {
		this.amount = amount;
		this.subscriptionType = subscriptionType;
		this.invoiceDates = invoiceDates;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public String getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public Set<String> getInvoiceDates() {
		return invoiceDates;
	}

	public void setInvoiceDates(Set<String> invoiceDates) {
		this.invoiceDates = invoiceDates;
	}

	@Override
	public String toString() {
		return "subscriptionOutput [amount=" + amount + ", subscriptionType=" + subscriptionType + ", invoiceDates="
				+ invoiceDates + ", getAmount()=" + getAmount() + ", getSubscriptionType()=" + getSubscriptionType()
				+ ", getInvoiceDates()=" + getInvoiceDates() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
