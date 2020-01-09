package com.javalec.ex;

public class MyCalculation {
	
	Calculation cal;//현재 객체 없음
	private int firstNum;
	private int secondNum;
	
	//MyCalculation 생성자
	MyCalculation(){}
	
	//Calculation cal;private int firstNum;private int secoundNum; 의 get /set
	public Calculation getCal() {
		return cal;
	}

	public void setCal(Calculation cal) {
		this.cal = cal;
	}

	public int getFirstNum() {
		return firstNum;
	}

	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}

	public int getSecondNum() {
		return secondNum;
	}

	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}

	
	public void add() {
		cal.addition(firstNum, secondNum);
	}
	
	public void sub() {
		cal.subtraction(firstNum, secondNum);
	}
	
	public void mul() {
		cal.multiplication(firstNum, secondNum);
	}
	
	public void div() {
		cal.division(firstNum, secondNum);
	}
	
	/*
	 * public int getFirstNum() { return firstNum; }
	 * 
	 * public void setFirstNum(int firstNum) { this.firstNum = firstNum; }
	 * 
	 * public int getSecondNum() { return secondNum; }
	 * 
	 * public void setSecondNum(int secondNum) { this.secondNum = secondNum; }
	 */
	
	
}
