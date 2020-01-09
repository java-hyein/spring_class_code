package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		/*//MyCalculation 객체 생성
		MyCalculation myCal = new MyCalculation();
		
		// 의존성 주입 <- IOC가 사용되었다
		myCal.setCal(new Calculation());
		
		myCal.setFirstNum(10);
		myCal.setSecoundNum(2);
		
		//호출
		myCal.add();
		myCal.sub();
		myCal.mul();
		myCal.div();*/
		
		//Spring 활용
		/*
		 * String configLocation = "classpath:appCTX.xml"; // XML이니까 설정 파일이다.
		 * (src/main/resources에서 spring bean config file 로 appCTX.xml을 만들어준다.) //
		 * Spring의 IOC 컨테이너 AbstractApplicationContext ctx = new
		 * GenericXmlApplicationContext(configLocation);
		 * 
		 * MyCalculation myCal = ctx.getBean("myCal", MyCalculation.class);
		 * 
		 * myCal.add(); myCal.sub(); myCal.mul(); myCal.div();
		 */
		
		//BMI
		/*
		 * String configLocation = "classpath:appCTX2.xml"; AbstractApplicationContext
		 * ctx = new GenericXmlApplicationContext(configLocation);
		 * 
		 * MyInfo myInfo = ctx.getBean("myInfo", MyInfo.class);
		 * 
		 * myInfo.getInfo();
		 */
		
		/*
		 * //circle String configLocation = "classpath:appCTX3.xml";
		 * AbstractApplicationContext ctx = new
		 * GenericXmlApplicationContext(configLocation);
		 * 
		 * Circle circle = ctx.getBean("circle", Circle.class); circle.setRadius(5);
		 * System.out.println(circle.getArea());
		 */
		
		//grade
		String configLocation = "classpath:appCTX3.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
						
		MyGrade grade1 = ctx.getBean("grade1", MyGrade.class);
		
		grade1.getInfo();
	}
	
}
