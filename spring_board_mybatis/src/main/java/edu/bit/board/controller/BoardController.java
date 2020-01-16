package edu.bit.board.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@RequestMapping("/list")
	public String list(Model model){
		System.out.println("list");
		List<BoardVO> list = boardService.selectBoardList();
		
		model.addAttribute("list",list);
		
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model){
		System.out.println("write_view");
		
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(BoardVO boardVO, Model model){
		System.out.println("write");
		
		//boardService.insertB(boardVO);
		boardService.insertBoard(boardVO.getbName(),boardVO.getbTitle(),boardVO.getbContent());
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(BoardVO boardVO, Model model){
		System.out.println("content_view");
		
		boardService.upHit(boardVO.getbId());
		model.addAttribute("content_view", boardService.contentView(boardVO.getbId()));
		
		return "content_view";
	}
	

	@RequestMapping("/modify")
	public String modify(BoardVO boardVO, Model model){
		System.out.println("modify");
		
		boardService.modify(boardVO.getbId(),boardVO.getbName(),boardVO.getbTitle(),boardVO.getbContent());
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(BoardVO boardVO, Model model){
		System.out.println("delete");
		
		boardService.delete(boardVO.getbId());
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(BoardVO boardVO, Model model){
		System.out.println("reply_view");
		
		model.addAttribute("reply_view", boardService.reply_view(boardVO.getbId()));

		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(BoardVO boardVO, Model model){
		System.out.println("reply");
		
		boardService.replyShape(boardVO);
		
		boardService.reply(boardVO);
		
		return "redirect:list";
	}
	
	
	
}
