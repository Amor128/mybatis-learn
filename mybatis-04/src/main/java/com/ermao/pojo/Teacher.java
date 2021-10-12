package com.ermao.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author Ermao
 * Date: 2021/7/20 21:09
 */
@Data
public class Teacher {
	private int id;
	private String name;

	private List<Student> students;
}
