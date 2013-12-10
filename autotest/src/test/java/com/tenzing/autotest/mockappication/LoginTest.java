package com.tenzing.autotest.mockappication;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@Cucumber.Options(

features = "MockApp",  // See /src/test/resources
format = {
        "html:target/reports/cucumber/html",
        "json:target/reports/cucumber.json"},
tags = { "@login" })


@Test // Hook to TestNG
@ContextConfiguration("file:src/main/resources/spring-config.xml")
public class LoginTest {
	
	
}
