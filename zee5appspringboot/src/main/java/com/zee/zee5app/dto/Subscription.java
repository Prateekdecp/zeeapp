package com.zee.zee5app.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;

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
	
	@NotNull
	private String type;
	
	@NotNull
    private Date dateOfPurchase;
	
	@NotBlank
    private Date paymentMode;
    
    @NotNull
    private int amount;
    
    @NotBlank
    private String status;
    
    @NotBlank
    private String autoRenewal;
    
    @NotNull
    private String expiryDate;
    
    @NotBlank
    private String regid;

	@Override
	public int compareTo(Subscription o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

	

	


}
