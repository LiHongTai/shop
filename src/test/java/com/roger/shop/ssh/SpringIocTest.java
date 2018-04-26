package com.roger.shop.ssh;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.roger.shop.BaseTestCase;

public class SpringIocTest extends BaseTestCase {

	@Resource
	private Date date;
	
	@Test
	public void dateShouldNotNull() {
		Assert.assertNotNull(date);
	}
}
