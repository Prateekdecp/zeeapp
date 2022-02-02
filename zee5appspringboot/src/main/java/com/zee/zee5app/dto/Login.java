package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="login")
public class Login {
	
	@Id
	@Column(name="username")
	private String userName;
	private String password;
	
	private String regId;
	private ROLE role;

}
