package com.jxyy.test;

import org.apache.log4j.Logger;

public class LogDemo {

	public static Logger logger = Logger.getLogger(LogDemo.class.getName());
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");*/
		LogDemo ldDemo = new LogDemo();
		int a = 4;
		int b = 0;
		try {
			logger.warn("com.jxyy.test.LogDemo.div(int a,int b)方法可能发生除零异常");
			ldDemo.div(a, b);
			logger.debug("com.jxyy.test.LogDemo.div(int a,int b) a="+a+",b="+b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("com.jxyy.test.LogDemo.div(int a,int b)a="+a+",b="+b+",产生除零异常");
			e.printStackTrace();
		}
	}
	
	public void div(int a,int b){
		int c = a/b;
		System.out.println(c);
	}

}
