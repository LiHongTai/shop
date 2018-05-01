package com.roger.shop.util;

import org.springframework.util.StringUtils;

import static com.roger.shop.constant.SeperateConstant.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QueryParamExecutor {

	public static String contains(String str) {
		StringBuilder builder = new StringBuilder();
		builder.append(PERCENTAGE);
		if (!StringUtils.isEmpty(str))
			builder.append(str);
		builder.append(PERCENTAGE);
		return builder.toString();
	}

	public static String startWith(String str) {
		StringBuilder builder = new StringBuilder();
		builder.append(PERCENTAGE);
		if (!StringUtils.isEmpty(str))
			builder.append(str);
		builder.append(PERCENTAGE);
		return builder.toString();
	}

	public static String endWith(String str) {
		StringBuilder builder = new StringBuilder();
		builder.append(PERCENTAGE);
		if (!StringUtils.isEmpty(str))
			builder.append(str);
		return builder.toString();
	}

	public static String in(String ids) {
		List<String> idList = Arrays.asList(ids.split(COMMA));
		ids = idList.stream()//
				.map(id -> id)//
				.collect(Collectors.joining(COMMA, "(", ")"));
		return ids;
	}
}
