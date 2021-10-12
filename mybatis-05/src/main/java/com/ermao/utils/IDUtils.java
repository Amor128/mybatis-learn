package com.ermao.utils;

import org.junit.Test;

import java.util.UUID;

/**
 * @author Ermao
 * Date: 2021/7/22 5:35
 */
public class IDUtils {

	public static String getID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
