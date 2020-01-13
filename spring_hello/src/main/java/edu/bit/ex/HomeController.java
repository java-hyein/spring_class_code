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
@Controller /* service repositoty // * Spring MVC �׸������� Controller */
//@Component 
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	/*
	 * @RequestMapping : ��Ʈ�� ġ�� �����ԵǸ� http://localhost:8282/ex/ <== (/ex/)���ý�Ʈ�н�
	 * ������ root�̴� GET ������� http://localhost:8282/ex/ �ڵ带 ġ�� �Ǹ�, �Ʒ� �Լ�(home())�� ź��
	 */
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		/* model�� �Լ����� �Դ�// model�� ���� :������ �Ǵ� ��ü ���� */
		model.addAttribute("serverTime", formattedDate);

		return "home";
		/*
		 * servlet-context ���� home�� ������ ������ �ϰ� �����س��� <beans:property name="suffix"
		 * value=".jsp" />
		 */
	}
	@RequestMapping("/board/view")

	public String view() {
		logger.info("/board/view ����");
		return "board/view";
	}
}
