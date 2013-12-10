package com.tenzing.autotest.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration("file:src/main/resources/spring-config.xml")
public class ContextTests extends AbstractTestNGSpringContextTests {
	
	@Autowired 
	protected ApplicationContext context;
	
	

}
