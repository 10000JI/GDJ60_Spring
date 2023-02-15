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

	//전체 row의 갯수를 담을 변수
	private Long totalCount;
	
	
	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Pager() {
		this.perPage=10L;
	}
	
	//startRow, lastRow 계산하는 메서드
	public void makeRow() {
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getPage()*this.getPerPage();
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
