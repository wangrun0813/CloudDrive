package mytest;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.tools.FileTools;

public class ToolsTest {
//	@Test
//	public void A(){
//		FileTools fileTools=new FileTools();
//		Assert.assertEquals("qweqr.txt", fileTools.getfilename("4"));
//	}
	
	@Test
	public void sharefile(){
		FileTools fileTools=new FileTools();
		Assert.assertEquals("d41d8cd98f00b204e9800998ecf8427e",	fileTools.sharefile("13","1234"));
	}
	@Test
	public void sharefile2(){
		FileTools fileTools=new FileTools();
		Assert.assertEquals("d41d8cd98f00b204e9800998ecf8427e",	fileTools.sharefile("1","1234"));
	}
	
	@Test
	public void sharefile3(){
		FileTools fileTools=new FileTools();
		Assert.assertEquals("d41d8cd98f00b204e9800998ecf8427e",	fileTools.sharefile("13","11231211"));
	}
	
	
	

}
