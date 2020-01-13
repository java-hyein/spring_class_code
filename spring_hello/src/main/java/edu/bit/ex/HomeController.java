package edu.bit.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller /* service repositoty // * Spring MVC 그림에서의 Controller */
//@Component 
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	/*
	 * @RequestMapping : 루트로 치고 들어오게되면 http://localhost:8282/ex/ <== (/ex/)컨택스트패스
	 * 까지가 root이다 GET 방식으로 http://localhost:8282/ex/ 코드를 치게 되면, 아래 함수(home())를 탄다
	 */
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		/* model은 함수에서 왔다// model의 역할 :데이터 또는 객체 전달 */
		model.addAttribute("serverTime", formattedDate);

		return "home";
		/*
		 * servlet-context 에서 home만 눌러도 나오게 하게 설정해놓음 <beans:property name="suffix"
		 * value=".jsp" />
		 */
	}
	@RequestMapping("/board/view")

	public String view() {
		logger.info("/board/view 실행");
		return "board/view";
	}
}
