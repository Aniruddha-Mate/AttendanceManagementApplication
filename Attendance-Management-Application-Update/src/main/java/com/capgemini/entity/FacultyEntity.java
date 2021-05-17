package com.capgemini.entity;



import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;


@Entity
@Table(name = "Faculties")
public class FacultyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="faculties_generations")
	@SequenceGenerator(name="faculties_generations", sequenceName = "faculties_sequences", allocationSize=1)
	private int facultyId;
	
	@Column(name = "first_name")
	@NotEmpty
	@NotNull
	@Size(min=2, message="Not a valid first name")
	private String firstName;
	
	@Column(name = "last_name")
	@NotEmpty
	@NotNull
	@Size(min=2, message="Not a valid last name")
	private String lastName;
	
	@Pattern(regexp = "^[a-zA-Z0-9]([.-](?![.-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$",message="please provide valid username.It can contains alphanumeric and _.It can be started only with alphabets ") 
	@Column(name="Username") 
	private String userName; 
	 
	@Pattern(regexp ="(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&].{8,}",
			message="It can be minimum of 8 characters and maximum 10 characters.It contains at least one digit,one lowercase alphabet,one uppercase alphabet,one special character which includes !@#$%&*()-+=^.")
	@Column(name="Password") 
	private String password;
    
	@Column(name = "email_id", unique=true)
	@Email
	@Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "invalid email")
	@NotEmpty
	private String emailId;
	
    @NotEmpty
	@Pattern(regexp="^(?:m|M|male|Male|f|F|female|Female)$", message="Invalid Entry")
	private String gender;
    
    @NotNull
    private LocalDate dateOfBirth;
    
    @Column(name="Mobile_Number", unique=true)
    @NotEmpty
    @Pattern(regexp="(^[6-9][0-9]{9}$)", message="Invalid Mobile Number")
    private String mobileNo;
    
    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, mappedBy="facultyentity")
  	private List<SubjectEntity> subjectList;


	public List<SubjectEntity> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<SubjectEntity> subjectList) {
		this.subjectList = subjectList;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public FacultyEntity() {
		super();
	}

	public FacultyEntity(int facultyId, @NotEmpty @Size(min = 2, message = "Not a valid first name") String firstName,
			@NotEmpty @Size(min = 2, message = "Not a valid last name") String lastName,
			@Pattern(regexp = "^[a-zA-Z0-9]([.-](?![.-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$", message = "please provide valid username.It can contains alphanumeric and _.It can be started only with alphabets ") String userName,
			@Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&].{8,}", message = "It can be minimum of 8 characters and maximum 10 characters.It contains at least one digit,one lowercase alphabet,one uppercase alphabet,one special character which includes !@#$%&*()-+=^.") String password,
			@Email @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "invalid email") @NotEmpty String emailId,
			@NotEmpty @Pattern(regexp = "^(?:m|M|male|Male|f|F|female|Female)$", message = "Invalid Entry") String gender,
			@NotNull LocalDate dateOfBirth,
			@NotEmpty @Pattern(regexp = "(^[6-9][0-9]{9}$)", message = "Invalid Mobile Number") String mobileNo,
			List<SubjectEntity> subjectList) {
		super();
		this.facultyId = facultyId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.mobileNo = mobileNo;
		this.subjectList = subjectList;
	}
	
	
	
}