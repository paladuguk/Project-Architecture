package com.test.model;

public class StudentModel {

	protected int sno;
	protected String sname;
	protected String course;
	protected int age;

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "StudentModel [sno=" + sno + ", sname=" + sname + ", course="
				+ course + ", age=" + age + "]";
	}

	public StudentModel(int sno, String sname, String course, int age) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.course = course;
		this.age = age;
	}
	
	public StudentModel(){
		//no-op
	}

}
