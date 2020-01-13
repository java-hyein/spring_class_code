package edu.bit.ex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller /* service repositoty // * Spring MVC 그림에서의 Controller */
public class ContentController {
	private static final Logger logger = LoggerFactory.getLogger(ContentController.class);
	@RequestMapping("/board/content")
	public String content(Model model) {
		logger.info("/board/content 실행");
		model.addAttribute("id",30);
		return "board/content";
	}
}
