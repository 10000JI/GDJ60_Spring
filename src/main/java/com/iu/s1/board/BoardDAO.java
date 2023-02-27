package com.iu.s1.board;

import java.util.List;

public interface BoardDAO extends BbsDAO{
	
	//list

	//detail
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception;
	
	//insert(add)

	//fileAdd
	public int setBoardFileAdd(BoardFileDTO boardFileDTO) throws Exception;
	
	//update

	
	//delete
	
	//BoardFile
	public List<BoardFileDTO> getBoardFileList(BbsDTO bbsDTO) throws Exception;

}
