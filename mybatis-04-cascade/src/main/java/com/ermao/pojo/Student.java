package com.ermao.pojo;

import lombok.Data;

/**
 * @author Ermao
 * Date: 2021/7/20 21:08
 */
@Data
public class Student {
	private int id;
	private String name;

	// 学生需要关联一个老师
	private int tid;
}
