package edu.bit.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.vo.BoardVO;

@Service
public class BoardService {
	// ���񽺿����� ����Ͻ� ������ ����.
	@Autowired
	BoardMapper boardmapper;
	
	//�Խ��� List�� ����ϴ� �����̴�.
	public List<BoardVO> selectBoardList(){
		return boardmapper.selectBoardList();
	}
	
	//�Խ��ǿ��� �亯�� ���� ���� 
	public void writeReply(BoardVO boardVO) {
		boardmapper.updateShape(boardVO);
		boardmapper.insertReply(boardVO);
	}
	
	//�� �ֱ�
	public void insertBoard(BoardVO boardVO) {
		boardmapper.insertBoard(boardVO);
	}
	//�۾��� �����ֱ�
	public BoardVO selectBoardOne(String bId) {
		return boardmapper.selectBoardOne(bId);
	}
	
	//����
	public void updateBoard(BoardVO boardVO) {
		boardmapper.updateBoard(boardVO);
	}

	public void delete(BoardVO boardVO) {
		boardmapper.delete(boardVO);
		
	}
}
