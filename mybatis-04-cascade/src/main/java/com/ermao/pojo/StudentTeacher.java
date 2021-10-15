package com.ermao.pojo;

import lombok.Data;

/**
 * @author Ermao
 * Date: 2021/10/15 19:23
 */
@Data
public class StudentTeacher {
	private int id;
	private String name;

	Teacher teacher;
}
