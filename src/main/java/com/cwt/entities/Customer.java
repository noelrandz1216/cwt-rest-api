package com.cwt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cust_id")
	private Integer custId;
	

	@NotBlank(message="First name must not be blank")
	@Size(min=2, max=20, message="First Name length must be between 2 and 20")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message="Last name must not be blank")
	@Size(min=2, max=20, message="Last Name length must be between 2 and 20")
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank(message="Email must not be blank")
	@Email
	@Column(name="email", unique = true, nullable=false)
	private String email;
	
	@NotBlank(message="Location must not be blank")
	private String location;
	
}
