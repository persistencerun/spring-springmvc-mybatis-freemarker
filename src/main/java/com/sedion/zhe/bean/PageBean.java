package com.sedion.zhe.bean;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class PageBean {
	
		private List<BBSMessageBean> list;				// list result of this page
		private int pageNumber;				// page number
		private int pageSize;				// result amount of this page
		private int totalPage;				// total page
		private int totalRow;				// total row
		
		
		public int getTotalPage() {
			return totalPage;
		}
		public void setTotalPage(int totalPage) {
			this.totalPage = totalPage;
		}
		public List<BBSMessageBean> getList() {
			return list;
		}
		public void setList(List<BBSMessageBean> list) {
			this.list = list;
		}
		public int getPageNumber() {
			return pageNumber;
		}
		public void setPageNumber(int pageNumber) {
			this.pageNumber = pageNumber;
		}
		public int getPageSize() {
			return pageSize;
		}
		public void setPageSize(int pageSize) {
			if (0 != pageSize) {
				if (0 != totalRow%pageSize) {
					totalPage = totalRow/pageSize + 1;									
				}else {
					totalPage = totalRow/pageSize;														
				}
			}		
			this.pageSize = pageSize;
		}
		public int getTotalRow() {
			return totalRow;
		}
		public void setTotalRow(int totalRow) {
			this.totalRow = totalRow;
		}
}
