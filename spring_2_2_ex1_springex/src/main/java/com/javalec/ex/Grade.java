package com.javalec.ex;

public class Grade {
	
	private double eng;
	private double math;
	private double kor;
	
	
	public void avgGrade(double eng, double math, double kor) {
		double avg = (eng+math+kor) /3.0;
		
		System.out.println("점수 평균 : " + avg);
		
		if(avg > 10) {
			System.out.println("당신의 등급 : 수");
		}else if (avg > 8) {
			System.out.println("당신의 등급 : 우");
		}else if (avg > 7) {
			System.out.println("당신의 등급 : 미");
		}
		else if (avg > 6) {
			System.out.println("당신의 등급 : 양");
		}else{
			System.out.println("당신의 등급 : 가");
		}
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

	
}
