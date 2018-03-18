package com.test.common;

import java.util.List;

public class Page<T> {
	private Integer currentPage; // 当前是第几页
	private Integer pageSize = 10;  // 一页显示多少条
	private Integer totalSize; // 一共多少条
	private Integer totalPage; // 一共多少页
	private List<T> result;
	public Page() {
		super();
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}
	public List<T> getResult() {
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}
	public Integer getStartNo() {
		return (currentPage-1)*pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	
	//private Integer 
}
