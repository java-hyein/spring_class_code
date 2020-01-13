package com.javalec.ex;

public class Triangle {
	
	private double under;
	private double height;
	
	
	public double calTri() {
		
		return (under * height) / 2 ;
	}

	public double getUnder() {
		return under;
	}
	public void setUnder(double under) {
		this.under = under;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
}
