package com.raipeng.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestUtil {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		StringBuffer buffer = new StringBuffer("");
		buffer.append("android,java,ios,");
		int is = buffer.lastIndexOf(",");
		System.out.println("is:"+is);
		if(is > 0){
			//buffer.deleteCharAt(buffer.lastIndexOf(","));
			buffer.deleteCharAt(buffer.length()-1);
			System.out.println("buffer:"+buffer.toString());
		}else{
			System.out.println(buffer.toString());
		}
	}

}
