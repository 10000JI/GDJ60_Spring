package com.iu.s1.board;

import org.springframework.web.multipart.MultipartFile;

public interface BoardService extends BbsService{
	
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception;

}
