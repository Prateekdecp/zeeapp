package com.zee.zee5app.service;

import com.zee.zee5app.dto.Subscription;

public interface SubscriptionService2 {
	public String addSubcription(Subscription subscription);
	public String updateSubscription(String id, Subscription subscription);
	public Subscription getSubscriptionById(String id);
	public Subscription[] getAllSubscriptions();
	public String deleteSubscriptionById(String id);
}
