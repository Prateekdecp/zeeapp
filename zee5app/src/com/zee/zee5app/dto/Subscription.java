package com.zee.zee5app.dto;

import lombok.Data;

@Data
public class Subscription {
	private String subID;
	private String dateOfPurchase;
	private String status;
	private String paymentMode;
	private boolean autoRenewal;
	private String expiryDate;
	private String serviceCountry;
}
