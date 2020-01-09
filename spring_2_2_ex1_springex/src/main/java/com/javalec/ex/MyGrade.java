package com.javalec.ex;

public class MyGrade {
	
	private double eng;
	private double math;
	private double kor;
	
	private Grade grade;
	
	public void grade() {
		grade.avgGrade(eng, kor, math);
	}
	
	public void getInfo() {
		System.out.println("국어 :" + kor);
		System.out.println("수학 :" + eng);
		System.out.println("영어 :" + math);
		grade();
	}

	public double getEng() {
		return eng;
	}

	public void setEng(double eng) {
		this.eng = eng;
	}

	public double getMath() {
		return math;
	}
	public void setMath(double math) {
		this.math = math;
	}

	public double getKor() {
		return kor;
	}

	public void setKor(double kor) {
		this.kor = kor;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	

}
