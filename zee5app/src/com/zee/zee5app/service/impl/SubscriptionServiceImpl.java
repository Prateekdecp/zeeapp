package com.zee.zee5app.service.impl;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.repository.SubscriptionRepo2;
import com.zee.zee5app.repository.impl.SubscriptionRepoImpl;
import com.zee.zee5app.service.SubscriptionService2;

public class SubscriptionServiceImpl implements SubscriptionService2 {
	
	private SubscriptionServiceImpl() {
		
	}
	
	private static SubscriptionService2 subscripton;
	public static SubscriptionService2 getInstance()
	{
		if(subscripton==null)
			subscripton=new SubscriptionServiceImpl();
		return subscripton;
	}
	
	SubscriptionRepo2 subscriptionservice=SubscriptionRepoImpl.getInstance();
	
	@Override
	public String addSubcription(Subscription subscription) {
		// TODO Auto-generated method stub
		return subscriptionservice.addSubcription(subscription);
	}

	@Override
	public String updateSubscription(String id, Subscription subscription) {
		// TODO Auto-generated method stub
		return subscriptionservice.modifySubscription(id, subscription);
	}

	@Override
	public Subscription getSubscriptionById(String id) {
		// TODO Auto-generated method stub
		return subscriptionservice.getSubscriptionById(id);
	}

	@Override
	public Subscription[] getAllSubscriptions() {
		// TODO Auto-generated method stub
		return subscriptionservice.getSubscriptions();
	}

	@Override
	public String deleteSubscriptionById(String id) {
		// TODO Auto-generated method stub
		return subscriptionservice.deleteSubscriptionById(id);
	}

}
