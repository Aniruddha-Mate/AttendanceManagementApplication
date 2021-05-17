package com.capgemini.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;



@Entity
@Table(name="Admin")
public class AdminEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="admins_generations")
	@SequenceGenerator(name="admins_generations", sequenceName = "admins_sequences", allocationSize=1)
	@Column(name="AdminId")
	private int id;
	
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$",message="please provide valid username.It can contains alphanumeric and _.It can be started only with alphabets ")
	@Column(name="Username")
	private String username;
	
	@NotNull
	@Pattern(regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",message="It can be minimum of 8 characters and maximum 10 characters.It contains at least one digit,one lowercase alphabet,one uppercase alphabet,one special character which includes !@#$%&*()-+=^.")
	@Column(name="Password")
	private String password;
	

	public AdminEntity() {
		super();
	}
	
	public AdminEntity(int id,
			@NotNull @Pattern(regexp = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$", message = "please provide valid username.It can contains alphanumeric and _.It can be started only with alphabets ") String username,
			@NotNull @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "It can be minimum of 8 characters and maximum 10 characters.It contains at least one digit,one lowercase alphabet,one uppercase alphabet,one special character which includes !@#$%&*()-+=^.") String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
