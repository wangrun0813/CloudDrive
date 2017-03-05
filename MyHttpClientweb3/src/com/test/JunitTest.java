package com.test;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.service.Userservice;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:springmvc-servlet.xml")
public class JunitTest extends AbstractJUnit4SpringContextTests{
	@Resource
	protected Userservice userserviceimpl;
	@Test
	public void getfileidid(){
		Assert.assertEquals("6",	userserviceimpl.getfileidid(2));		
	}
	
	
	@Test(expected=NullPointerException.class)
	public void getfileidid3(){
		Assert.assertEquals("4",	userserviceimpl.getfileidid(8));
		
	}
	
	@Test
	public void getsharefile(){
		Assert.assertEquals("success",	userserviceimpl.getsharefile("d41d8cd98f00b204e9800998ecf8427e","1234"));
		
	}
	
	@Test
	public void getsharefile2(){
		Assert.assertEquals("fail",	userserviceimpl.getsharefile("d41d8cd98f00b204e9800998ecf8427e","123"));
		
	}
	
	
	@Test(expected=NullPointerException.class)
	public void getsharefile3(){
		Assert.assertEquals("fail",	userserviceimpl.getsharefile("d41d8cd98f00b204e9800998ecf8427","123"));	
	}
	
	
	

}
