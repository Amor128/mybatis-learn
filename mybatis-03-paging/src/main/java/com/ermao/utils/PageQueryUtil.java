package com.ermao.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ermao
 * Date: 2021/10/14 11:42
 */
public class PageQueryUtil extends HashMap<String, Object> {
	//当前页码
	private int currentPage;
	//每页条数
	private int pageSize;

	public PageQueryUtil(Map<String, String> params) {
		this.putAll(params);

		//分页参数
		this.currentPage = Integer.parseInt(params.get("currentPage"));
		this.pageSize = Integer.parseInt(params.get("pageSize"));
		this.put("start", (currentPage - 1) * pageSize);
		this.put("currentPage", currentPage);
		this.put("pageSize", pageSize);
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	@Override
	public String toString() {
		return "PageUtil{" +
				"page=" + currentPage +
				", limit=" + pageSize +
				'}';
	}
}
