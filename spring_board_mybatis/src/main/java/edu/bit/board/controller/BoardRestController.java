package edu.bit.board.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;

/*@Controller + @ResponseBody == @RestController */

@RestController
@RequestMapping("/rest/*")
public class BoardRestController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/list")
	public List<BoardVO>  list(Model model){
		
		System.out.println("list");
		
		return boardService.selectBoardList();
		
	}
}
