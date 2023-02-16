package com.iu.s1.util;

public class Pagination {
	//Product
	//DB 에서 일정한 갯수 꺼내오고, JSP에 뿌려줄 애들을 계산하는 거 연습하기
	
	
	//한 페이지에 출력할 ROW의 개수
	private Long perPage;
	//Client가 보고싶은 페이지 번호(parameter)
	private Long page;
	
	//Table에서 조회할 시작번호
	private Long startRow;
	//Table에서 조회할 끝번호
	private Long lastRow;
	
	//전체 ROW의 개수를 담을 변수
	private Long totalCount;
	
	//전체 page개수
	private Long totalPage;
	
	//한 블럭당 출력할 번호의 개수
	private Long perBlock;
	
	private Long startNum;
	private Long lastNum;
	
	private Boolean before;
	private Boolean after;
	
	
	public Pagination() {
		this.perPage=10L;
	}
	
	//startNum, lastNum
	public void maskNum(Long totalCount) {
		this.totalPage=totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() !=0) {
			totalPage++;
		}
		
		if(this.getPage()>totalPage) {
			this.setPage(totalPage);
		}
		
		Long totalBlock = totalPage/this.getPerBlock();
			if(totalPage%this.getPerBlock() !=0) {
				totalBlock++;
		}
			
		Long curBlock=this.getPage()/this.getPerBlock();
		if(this.getPage() % this.getPerBlock() !=0) {
			curBlock++;
		}
		
		this.startNum =(curBlock-1)*this.getPerBlock()+1;
		this.lastNum =curBlock*this.getPerBlock();
		
		this.after = true;
		
		//마지막 페이지 설정
		if(curBlock==totalBlock) {
			lastNum=totalPage;
			this.after=false;
		}
		if(curBlock==1) {
			this.before=true;
		}
	}
		
	
	
	
	//startRow, lastRow 계산하는 메서드
	public void makeRow() {
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getPage()*this.getPerPage();
	}
	
	//page 기본값 1페이지로 설정
		public Long getPage() {
			if(this.page==null || this.page<1) {
				this.page=1L;
			}
			return page;
		}
		public void setPage(Long page) {
			this.page = page;
		}
		
	//perPage 페이지당 게시물 개수 설정	
	public Long getPerPage() {
		if(this.perPage == null || this.perPage ==0) {
			this.perPage = 10L;
		}
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
		
	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public Long getPerBlock() {
		return perBlock;
	}

	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
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

	public Boolean getBefore() {
		return before;
	}

	public void setBefore(Boolean before) {
		this.before = before;
	}

	public Boolean getAfter() {
		return after;
	}

	public void setAfter(Boolean after) {
		this.after = after;
	}
	
	
	
	
}
