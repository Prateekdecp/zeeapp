package com.zee.zee5app.service;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.repository.SubscriptionRepo;

public class SubscriptionService {
	SubscriptionRepo subscriptionrepo=SubscriptionRepo.getInstance();
	private SubscriptionService() {
		// TODO Auto-generated constructor stub
	}
	private static SubscriptionService subservice=null;
	public static SubscriptionService getInstance()
	{
		if(subservice==null)
			subservice=new SubscriptionService();
		return subservice;
	}
	public String addSubscription(Subscription subscription)
	{
		return this.subscriptionrepo.addSubcription(subscription);
	}
	public Subscription getUserById(String id)
	{
		return this.subscriptionrepo.getUserById(id);
	}
	public Subscription[] getAllUsers()
	{
		return this.subscriptionrepo.getSubscriptions();
	}
	public String modifySubscription(String id,Subscription subscription)
	{
		return this.subscriptionrepo.modifySubscription(id, subscription);
	}
}
