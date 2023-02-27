package com.iu.s1.board;

public interface BoardDAO extends BbsDAO{
	
	//list

	//detail
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception;
	
	//insert(add)

	//fileAdd
	public int setBoardFileAdd(BoardFileDTO boardFileDTO) throws Exception;
	
	//update

	
	//delete

}
