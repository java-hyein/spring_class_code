package edu.bit.board.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.bit.board.service.LoginService;
import edu.bit.board.vo.UserVO;

@Controller
@RequestMapping("/member")
public class LoginController {

	@Inject
	LoginService loginservice;

	// Login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest req, RedirectAttributes rttr) {

		System.out.println("login ȣ��()");

		HttpSession session = req.getSession();

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");

		UserVO login = loginservice.loginUser(id, pw);

		if (login == null) {
			// RedirectAttributes - ���ΰ�ħ�ϸ� ���ư��� ������
			rttr.addFlashAttribute("msg", false);
		} else {
			// �α����� ��Ų��? �ᱹ�� ����ó��
			session.setAttribute("member", login);
		}
		return "redirect:/";
	}

	// LogOut
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {

		System.out.println("logout");

		session.invalidate();

		return "redirect:/";
	}

}
