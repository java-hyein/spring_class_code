package edu.bit.board.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	// 쿼리가 2개 들어간다. step올려주는것 과 자기 자신것 넣어주는것
	@RequestMapping("/reply")
	public String reply(BoardVO boardVO,Model model) {
		System.out.println("reply");
	
		boardservice.writeReply(boardVO);
		
		return "redirect:list";
	}

}
