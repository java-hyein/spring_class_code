package edu.bit.board.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.bit.board.vo.BoardVO;

public interface BoardService {

	List<BoardVO> selectBoardList();
	
	//public void insertB(@Param("boardVO") BoardVO boardVO);
	public void insertBoard(@Param("bName") String bName, @Param("bTitle") String bTitle, @Param("bContent") String bContent);
	
	@Select("select * from mvc_board where bId = #{bId}")
	public BoardVO contentView(int bId);

	public void modify(@Param("bId")int bId,@Param("bName") String bName,@Param("bTitle") String bTitle,@Param("bContent") String bContent);

	public void delete(@Param("bId")int bId);

	@Select("select * from mvc_board where bId = #{bId}")
	public BoardVO reply_view(int bId);

	public void reply(@Param("boardVO") BoardVO boardVO);
	
	@Update("update mvc_board set bHit = bHit+1 where bId = #{bId}")
	public void upHit(int bId);
	
	@Update("update mvc_board set bStep = bStep+1 where bGroup = #{bGroup} and bStep > #{bStep}")
	public void replyShape(BoardVO boardVO);
	
	

	
	
}
