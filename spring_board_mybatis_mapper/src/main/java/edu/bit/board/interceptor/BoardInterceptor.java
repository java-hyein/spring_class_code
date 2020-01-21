package edu.bit.board.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import edu.bit.board.vo.UserVO;

public class BoardInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException{
		System.out.println("preHandler ���� ");
		//session ��ü�� ������
		HttpSession session = request.getSession();
		//login ó���� ����ϴ� ����� ������ ��� �ִ� ��ü�� ������
		UserVO member = (UserVO) session.getAttribute("member");
		
		if(member == null) {
			//�α����� �ȵǾ��ִ� ���������� �α��� ������ �ٽ� �������� (redirect)
			response.sendRedirect(request.getContextPath());
			return false;//���̻� ��Ʈ�ѷ� ��û�� ���� �ʵ��� false�� ��ȯ��
		}
		//preHanlder�� return�� ��Ʈ�ѷ� ��û  uri�� ���� �Ǵ��� �ȵǴ��ĸ� �㰡�ϴ� �ǹ���
		// ���� true�� �ϸ� ��Ʈ�ѷ� uri�� ���Ե�.
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		super.postHandle(request, response, handler, modelAndView);
		System.out.println("postHandle ����");
	}
	
}
