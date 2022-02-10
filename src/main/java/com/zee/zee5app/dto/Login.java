package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zee.zee5app.utils.CustomListSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString
@Table(name="login")
public class Login {
	
	@Id
	@Column(name="username")
	private String userName;
	
	@NotBlank
	private String password;
	
	@OneToOne(fetch=FetchType.LAZY)
//	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
//	@JsonSerialize(using=CustomListSerializer.class)
	@JoinColumn(name="regid",nullable=false)
	@JsonProperty(access = Access.WRITE_ONLY)
	private User register; 
	

}
