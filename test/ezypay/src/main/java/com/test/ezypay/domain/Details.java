package com.test.ezypay.domain;

import java.math.BigDecimal;

public class Details {
	private BigDecimal amount;
	private String subscriptionType;
	private String dayOfWeek;
	private String dayOfMonth;
	private String startDate;
	private String endDate;

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

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getDayOfMonth() {
		return dayOfMonth;
	}

	public void setDayOfMonth(String dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Details [amount=" + amount + ", subscriptionType=" + subscriptionType + ", dayOfWeek=" + dayOfWeek
				+ ", dayOfMonth=" + dayOfMonth + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}



}
