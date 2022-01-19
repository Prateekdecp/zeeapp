package com.zee.zee5app.repository.impl;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.repository.SubscriptionRepo2;

public class SubscriptionRepoImpl implements SubscriptionRepo2 {
	private Subscription[] subscriptions=new Subscription[100];
	private static int count=0;
	
	private SubscriptionRepoImpl()
	{
		
	}
	
	private static SubscriptionRepo2 subscription;
	public static SubscriptionRepo2 getInstance()
	{
		if(subscription==null)
			subscription=new SubscriptionRepoImpl();
		return subscription;
	}
	@Override
	public Subscription[] getSubscriptions() {
		// TODO Auto-generated method stub
		return subscriptions;
	}

	@Override
	public String addSubcription(Subscription subscription) {
		// TODO Auto-generated method stub
		if(count==subscriptions.length)
		{
			Subscription temp[]=new Subscription[subscriptions.length*2];
			System.arraycopy(subscriptions, 0, temp, 0, subscriptions.length);
			subscriptions=temp;
		}
		subscriptions[count++]=subscription;
		return "success";
	}

	@Override
	public Subscription getSubscriptionById(String subId) {
		// TODO Auto-generated method stub
		for (Subscription subscription : subscriptions) {
			if(subscription!=null && subscription.getSubID().equals(subId))
				return subscription;
		}
		return null;
	}

	@Override
	public String modifySubscription(String subId, Subscription subscription) {
		// TODO Auto-generated method stub
		for(Subscription subscription1:subscriptions)
		{
			if(subscription1!=null && subscription1.getSubID().equals(subId))
			{
				subscription1=subscription;
				return "success";
			}
		}
		return "id does not exist";
	}
	@Override
	public String deleteSubscriptionById(String id) {
		// TODO Auto-generated method stub
		Subscription[] temp=new Subscription[subscriptions.length];
		boolean flag=false;
		for(int i=0,k=0;i<subscriptions.length;i++)
		{
			if(subscriptions[i]!=null && subscriptions[i].getSubID().equals(id))
			{
				flag=true;
				continue;
			}
			else
			{
				temp[k++]=subscriptions[i];
			}
		}
		subscriptions=temp;
		return flag?"success":"id was not available";
	}

}
