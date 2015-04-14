package com.test.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "student", catalog = "test")
public class Student implements java.io.Serializable {

	// Fields

	private Integer sno;
	private String sname;
	private Integer age;
	private String course;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(Integer sno) {
		this.sno = sno;
	}

	/** full constructor */
	public Student(Integer sno, String sname, Integer age, String course) {
		this.sno = sno;
		this.sname = sname;
		this.age = age;
		this.course = course;
	}

	// Property accessors
	@Id
	@Column(name = "Sno", unique = true, nullable = false)
	public Integer getSno() {
		return this.sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	@Column(name = "Sname", length = 45)
	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Column(name = "age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "course", length = 45)
	public String getCourse() {
		return this.course;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", age=" + age
				+ ", course=" + course +  "]";
	}

	public void setCourse(String course) {
		this.course = course;
	}

}