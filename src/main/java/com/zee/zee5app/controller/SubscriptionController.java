package com.zee.zee5app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.payload.response.MessageResponse;
import com.zee.zee5app.service.SubscriptionService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/")
public class SubscriptionController {

	@Autowired
	SubscriptionService subscriptionService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/addSubscription")
	public ResponseEntity<?> addSubscription(@Valid@RequestBody Subscription subscription) throws InvalidAmountException{
		Subscription subscription2=subscriptionService.addSubscription(subscription);
		return subscription2!=null?ResponseEntity.ok(subscription2):ResponseEntity.badRequest().body(new MessageResponse("error"));
	}
}
