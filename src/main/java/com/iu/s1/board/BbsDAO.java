package com.iu.s1.board;

import java.util.List;

import com.iu.s1.util.Pager;

public interface BbsDAO {
	
	//totalCount
	public Long getTotalCount(Pager pager) throws Exception;
	
	//list
	public List<BbsDTO> getBoardList(Pager pager) throws Exception;  
	//최상위 부모형인 BbsDTO로 선언
	
	//insert(add)
	public int setBoardAdd(BbsDTO bbsDTO) throws Exception;
	
	//update
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception;
	
	//delete
	public int setBoardDelete(BbsDTO bbsDTO) throws Exception;

}
