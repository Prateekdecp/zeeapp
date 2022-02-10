package com.zee.zee5app.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.utils.CustomListSerializer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="subsscription")
public class Subscription implements Comparable<Subscription>{
	
	

	@Id
	@Column(name="subid")
	private String id;
	
	@NotBlank
	private String type;
	
	@NotBlank
    private String dateOfPurchase;
	
	@NotBlank
    private String paymentMode;
    
    @NotNull
    private int amount;
    
    @NotBlank
    private String status;
    
    @NotBlank
    private String autoRenewal;
    
    @NotNull
    private String expiryDate;
    

	@Override
	public int compareTo(Subscription o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

	@OneToOne
	@JoinColumn(name="regid")
//	@JsonSerialize(using=CustomListSerializer.class)
	@JsonProperty(access = Access.WRITE_ONLY)
	private User register;
	

	


}
