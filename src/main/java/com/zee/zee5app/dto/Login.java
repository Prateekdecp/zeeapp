package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
@Table(name="login")
public class Login {
	
	@Id
	@Column(name="username")
	private String userName;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String regId;
	
	@NotNull
	private ROLE role;

}
