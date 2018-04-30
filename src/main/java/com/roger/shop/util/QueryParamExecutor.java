package com.roger.shop.util;

import org.springframework.util.StringUtils;

public class QueryParamExecutor {

	private static final String PERCENTAGE = "%";
	
	public static String contains(String str) {
		StringBuilder builder = new StringBuilder();
		builder.append(PERCENTAGE);
		if(!StringUtils.isEmpty(str))
			builder.append(str);
		builder.append(PERCENTAGE);
		return builder.toString();
	}
	
	
	public static String startWith(String str) {
		StringBuilder builder = new StringBuilder();
		builder.append(PERCENTAGE);
		if(!StringUtils.isEmpty(str))
			builder.append(str);
		builder.append(PERCENTAGE);
		return builder.toString();
	}
	
	
	public static String endWith(String str) {
		StringBuilder builder = new StringBuilder();
		builder.append(PERCENTAGE);
		if(!StringUtils.isEmpty(str))
			builder.append(str);
		return builder.toString();
	}
}
