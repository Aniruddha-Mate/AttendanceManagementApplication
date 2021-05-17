package com.capgemini.entity;


import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;




@Entity
@Table(name = "Attendances")
public class AttendanceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="attendances_generations")
	@SequenceGenerator(name="attendances_generations",sequenceName="attendances_sequences",allocationSize=1)
	private int attendanceId;
	
	@NotNull
    private LocalDate currentDate;
	
    @NotEmpty(message="Please Enter Valid Status (Present/Absent)")
    @Pattern(regexp="(absent|Absent|present|Present)", message="Please enter valid Status")
	private String status;
    
    
    @ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="roll_no")
	private StudentEntity studentEntity;
    
    

    @ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name="subject_id")
    private SubjectEntity subjectEntity;
    
    @Column(name="subjectCode")
    private int subjectId;
    
    @Column(name="rollnumber")
    private int studentId;
    
	/*
	 * public int getSubjectId() { return subjectEntity.getSubjectId(); }
	 * 
	 * public int getStudentId() { return studentEntity.getStudentId(); }
	 */
    
    @JsonIgnore
    public StudentEntity getStudentEntity() {
		return studentEntity;
	}
    public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	@JsonIgnore
	public void setStudentEntity(StudentEntity studentEntity) {
		this.studentEntity = studentEntity;
	}

	public int getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(LocalDate currentDate) {
		this.currentDate = currentDate;
	}
	
	@JsonIgnore
	public SubjectEntity getSubjectEntity() {
		return subjectEntity;
	}
    
	@JsonIgnore
	public void setSubjectEntity(SubjectEntity subjectEntity) {
		this.subjectEntity = subjectEntity;
	}


	public AttendanceEntity() {
		super();
	}

	public AttendanceEntity(int attendanceId, @NotNull LocalDate currentDate,
			@NotEmpty(message = "Please Enter Valid Status (Present/Absent)") @Pattern(regexp = "(absent|Absent|present|Present)", message = "Please enter valid Status") String status,
			StudentEntity studentEntity, SubjectEntity subjectEntity) {
		super();
		this.attendanceId = attendanceId;
		this.currentDate = currentDate;
		this.status = status;
		this.studentEntity = studentEntity;
		this.subjectEntity = subjectEntity;
	}

	
	
}




