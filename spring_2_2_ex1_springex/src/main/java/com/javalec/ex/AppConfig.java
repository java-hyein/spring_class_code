package com.javalec.ex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public Student2 student1() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("수영");
		hobbys.add("요리");
		
		Student2 student = new Student2("이진이", 16 , hobbys);
		student.setHeight(70);
		student.setWeight(6.3);
		
		return student;
	}
	
	@Bean
	public Student2 student2() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("잠");
		hobbys.add("간식");
		
		Student2 student = new Student2("이진", 16 , hobbys);
		student.setHeight(70);
		student.setWeight(6.3);
		return student;
	}
	
	@Bean
	public Rectangle rectangle() {
		Rectangle rec = new Rectangle(3, 5);
		return rec;
	}
	
	
}
