package com.ermao.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author Ermao
 * Date: 2021/7/22 5:26
 */
@Data
public class BLOG {
	private String id;
	private String title;
	private String author;
	private Date createTime;
	private int views;
}
