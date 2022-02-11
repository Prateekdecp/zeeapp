package com.zee.zee5app.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Lazy;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import java.lang.*;
import java.math.BigDecimal;
import java.math.BigInteger;

//@Data
@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Entity // (entity class for ORM Mapping)
@Table(name = "register", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") })

public class User implements Comparable<User> {

	@Id
	@Column(name = "regid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@Size(max = 50)
	@NotBlank
	private String firstName;

	@Size(max = 50)
	@NotBlank
	private String lastName;

	@Size(max = 50)
	@Email
	private String email;

	@Size(max = 100)
	@NotBlank
	private String password;

//	@NotNull
	private BigInteger contactnumber;

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return this.getId().compareTo(o.getId());
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "regID"), inverseJoinColumns = @JoinColumn(name = "roleId"))
	private Set<Role> roles = new HashSet<>();

//	@OneToOne(mappedBy = "register", cascade = CascadeType.ALL)
//	private Subscription subscription;
//
//	@OneToOne(mappedBy = "register", cascade = CascadeType.ALL)
////	@JsonIgnore
//	private Login login;
	
	public User(String username,String email,String password,String firstName,String lastName) {
		this.username=username;
		this.email=email;
		this.password=password;
		this.firstName=firstName;
		this.lastName=lastName;
	}

}
