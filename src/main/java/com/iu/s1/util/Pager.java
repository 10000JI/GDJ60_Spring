package com.iu.s1.util;

public class Pager {
	
	//한 페이지에 출력할 row 갯수
	private Long perPage;
	//Client가 보고싶은 페이지 번호(parameter)
	private Long page;
	
	//테이블에서 조회 할 시작번호
	private Long startRow;
	//테이블에서 조회 할 끝번호
	private Long lastRow;
	
	private Long startNum;
	private Long lastNum;
	
	public Pager() {
		this.perPage=10L;
	}
	
	public Long getStartNum() {
		return startNum;
	}


	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	//startRow, lastRow 계산하는 메서드
	public void makeRow() {
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getPage()*this.getPerPage();
	}
	
	//startNum, lastNum
	public void makeNum(Long totalCount) {
		//1. 전체 row의 갯수 구하기
		//2. 총 page의 갯수 구하기
		//ex> totalCount가 135 getPerPage가 10이면 14개 페이지
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount % this.getPerPage() != 0) {
			//totalPage = totalPage+1;
			//totalPage+=1;
			totalPage++;
		}
		//3. 한 블럭에 출력할 번호의 갯수
		//1-5페이지
		Long perBlock = 5L;
		
		//4. 총 블럭의 수 구하기
		//1-5페이지 구성하는 블럭 몇개?
		//14개의 페이지가 있으면 총 3개의 블럭
		Long totalBlock = totalPage / perBlock;
		if(totalPage % perBlock != 0) {
			totalBlock++;
		}
		
		//5. page 번호로 현재 블럭 번호 구하기
		// page 1-5 curBlock=1
		// page 6-10 curBlock=2
		// page 11-15 curBlock=3
		Long curBlock = this.getPage() / perBlock;
		if(this.getPage() % perBlock != 0) {
			curBlock++;
		}
		
		//6.curBlock의 시작번호와 끝번호를 계산
		/** curBlock	satartNum	lastNum
		 *  1			1			5
		 * 	2			6			10
		 *	3			11			15
		 */	
		this.startNum=(curBlock-1)*(perBlock)+1;
		this.lastNum= perBlock*curBlock;
	}
	
	public Long getPerPage() {
		if(this.perPage==null || this.perPage ==0) {
			this.perPage=10L;
		}
		
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	
	public Long getPage() {
		if(this.page==null || this.page<1) {
			this.page=1L;
		}
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	
}
