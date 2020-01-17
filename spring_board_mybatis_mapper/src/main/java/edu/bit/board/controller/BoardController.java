package edu.bit.board.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.board.page.Criteria;
import edu.bit.board.page.PageMaker;
import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;

@Controller
public class BoardController {
	@Inject
	BoardService boardservice;
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list");
		model.addAttribute("list", boardservice.selectBoardList());
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view");
		
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(BoardVO boardVO,Model model) {
		System.out.println("write");
	
		boardservice.insertBoard(boardVO);
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest req ,Model model) {
		System.out.println("content_view");
		
		String bId=req.getParameter("bId");
		model.addAttribute("content_view", boardservice.selectBoardOne(bId));
		
		return "content_view";
	}
	
	@RequestMapping("/modify")
	public String modify(BoardVO boardVO,Model model) {
		System.out.println("modify");
		
		boardservice.updateBoard(boardVO);
		
		return "redirect:list";
	}
	
	  @RequestMapping("/delete")
	  public String delete(BoardVO boardVO,Model model) {
	  System.out.println("delete");
	  
	  boardservice.delete(boardVO);
	  
	  return "redirect:list";
	  
	  }
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest req ,Model model) {
		System.out.println("reply_view");
		
		String bId = req.getParameter("bId");
		model.addAttribute("reply_view", boardservice.selectBoardOne(bId));
		
		return "reply_view";
	}
	// ������ 2�� ����. step�÷��ִ°� �� �ڱ� �ڽŰ� �־��ִ°�
	@RequestMapping("/reply")
	public String reply(BoardVO boardVO, Model model) {
		System.out.println("reply");
	
		boardservice.writeReply(boardVO);
		
		return "redirect:list";
	}
	//����¡ ó�� ����Ʈ
	@RequestMapping("/list2")
	public String list2(Criteria criteria, Model model) {
		System.out.println("list2");
		
		PageMaker pm = new PageMaker();
		pm.setCri(criteria);

		System.out.println(criteria.getPerPageNum());
		System.out.println(criteria.getPage());
		
		int totalCount = boardservice.selectCountBoard();
		System.out.println("��ü �Խù� �� : "+ totalCount);
		//��ü �� ����
		pm.setTotalCount(totalCount);
		
		//criteria�� �־ ����¡�� �����;��Ѵ�.
		//ó������ 1~10�� ���´� 
		List<BoardVO> boardList = boardservice.selectBoardList(criteria);
		
		model.addAttribute("list2",boardList);
		model.addAttribute("pageMaker", pm);
		return "list2";
	}
	
	

}