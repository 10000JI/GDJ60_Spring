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
	
	//BoardFileList
	public List<BoardFileDTO> getBoardFileList(BbsDTO bbsDTO) throws Exception;

	//BoardFileDetail
	public BoardFileDTO getBoardFileDetail(BoardFileDTO boardFileDTO) throws Exception; 
	
	//BoardFileDelte
	//update 전 delete로 선택한건 지우자
	public int setBoardFileDelete(Long fileNum) throws Exception;
}
