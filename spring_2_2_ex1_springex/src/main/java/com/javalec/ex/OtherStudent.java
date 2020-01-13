package com.javalec.ex;
import javax.annotation.*;


public class OtherStudent{
	private String name;
	private String age;
	private String gradeNum;
	private String classNum;	
	
	public OtherStudent() {}
	
	public OtherStudent(String name, String age, String gradeNum, String classNum) {
		this.name = name;
		this.age = age;
		this.gradeNum = gradeNum;
		this.classNum = classNum;
	}
	
	@PostConstruct
	public void initMethod() {
		System.out.println("initMethod() 호출");
	}
	@PreDestroy
	public void destroyMethod() {
		System.out.println("destroyMethod() 호출");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGradeNum() {
		return gradeNum;
	}

	public void setGradeNum(String gradeNum) {
		this.gradeNum = gradeNum;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

}
