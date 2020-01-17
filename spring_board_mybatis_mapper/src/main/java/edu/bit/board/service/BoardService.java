package edu.bit.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.vo.BoardVO;

@Service
public class BoardService {
	// 서비스에서는 비즈니스 로직이 들어간다.
	@Autowired
	BoardMapper boardmapper;
	
	//게시판 List를 출력하는 로직이다.
	public List<BoardVO> selectBoardList(){
		return boardmapper.selectBoardList();
	}
	
	//게시판에서 답변을 쓰는 로직 
	public void writeReply(BoardVO boardVO) {
		boardmapper.updateShape(boardVO);
		boardmapper.insertReply(boardVO);
	}
	
	//글 넣기
	public void insertBoard(BoardVO boardVO) {
		boardmapper.insertBoard(boardVO);
	}
	//글쓴거 보여주기
	public BoardVO selectBoardOne(String bId) {
		return boardmapper.selectBoardOne(bId);
	}
	
	//수정
	public void updateBoard(BoardVO boardVO) {
		boardmapper.updateBoard(boardVO);
	}

	public void delete(BoardVO boardVO) {
		boardmapper.delete(boardVO);
		
	}
}
