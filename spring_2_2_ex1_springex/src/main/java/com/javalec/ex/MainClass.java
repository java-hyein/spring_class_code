package com.javalec.ex;

import javax.security.auth.login.AppConfigurationEntry;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		/*
		 * //MyCalculation 객체 생성 MyCalculation myCal = new MyCalculation();
		 * 
		 * // 의존성 주입 <- IOC가 사용되었다 myCal.setCal(new Calculation());
		 * 
		 * myCal.setFirstNum(10); myCal.setSecoundNum(2);
		 * 
		 * //호출 myCal.add(); myCal.sub(); myCal.mul(); myCal.div();
		 */

		// Spring 활용
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

		// BMI
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

		
		/*
		 * //grade String configLocation = "classpath:appCTX3.xml";
		 * AbstractApplicationContext ctx = new
		 * GenericXmlApplicationContext(configLocation);
		 * 
		 * MyGrade grade1 = ctx.getBean("grade1", MyGrade.class);
		 * 
		 * grade1.getInfo();
		 */
		 

		
		/*
		 * //Tri String configLocation = "classpath:appCTX3.xml";
		 * AbstractApplicationContext ctx = new
		 * GenericXmlApplicationContext(configLocation);
		 * 
		 * Triangle tri = ctx.getBean("tri", Triangle.class);
		 * 
		 * tri.setUnder(5); tri.setHeight(5);
		 * 
		 * System.out.println(tri.calTri());
		 */
		
		
		/*
		 * //Student String configLocation = "classpath:appCTX3.xml";
		 * AbstractApplicationContext ctx = new
		 * GenericXmlApplicationContext(configLocation);
		 * 
		 * studentInfo sInfo = ctx.getBean("sInfo", studentInfo.class);
		 * sInfo.getStudentInfo();
		 * 
		 * Student student2 = ctx.getBean("student2", Student.class);
		 * sInfo.setStudent(student2); sInfo.getStudentInfo();
		 */
		
		
		/*
		 * String configLocation = "classpath:appCTX3.xml"; AbstractApplicationContext
		 * ctx = new GenericXmlApplicationContext(configLocation);
		 * 
		 * Pencil pencil = ctx.getBean("pencil", Pencil.class); pencil.use();
		 * 
		 * Pencil pencil4b = ctx.getBean("pencil4b", Pencil.class); pencil4b.use();
		 */
		 
		/*
		 * AnnotationConfigApplicationContext ctx = new
		 * AnnotationConfigApplicationContext(AppConfig.class);
		 * 
		 * Student2 student1 = ctx.getBean("student1", Student2.class);
		 * 
		 * System.out.println("이름 : " + student1.getName()); System.out.println("나이 : "
		 * + student1.getAge()); System.out.println("취미 : " + student1.getHobbys());
		 * System.out.println("키 : " + student1.getHeight());
		 * System.out.println("몸무게 : " + student1.getWeight());
		 * 
		 * Student2 student2 = ctx.getBean("student2", Student2.class);
		 * 
		 * System.out.println("==============="); System.out.println("이름 : " +
		 * student2.getName()); System.out.println("나이 : " + student2.getAge());
		 * System.out.println("취미 : " + student2.getHobbys()); System.out.println("키 : "
		 * + student2.getHeight()); System.out.println("몸무게 : " + student2.getWeight());
		 * 
		 * Rectangle rec = ctx.getBean("rectangle", Rectangle.class);
		 * System.out.println("==============="); System.out.println("넓이 : " +
		 * rec.getArea());
		 */
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		ctx.load("classpath:appCTX3.xml");
		ctx.refresh();
		System.out.println("ctx.close(); 호출전");
		ctx.close();
		System.out.println("ctx.close(); 호출후");	
	}
}
