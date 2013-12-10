package com.tenzing.autotest.mockapplication;

import org.springframework.beans.factory.annotation.Autowired;

import com.tenzing.autotest.constants.CredentialsType;
import com.tenzing.autotest.constants.Outcome;
import com.tenzing.autotest.mockapplication.view.LoginView;
import com.tenzing.autotest.utils.BrowserDriver;
import com.tenzing.autotest.utils.ContextTests;

public class Navigation extends ContextTests {
	@Autowired
	private User validUser;
	@Autowired
	private User invalidUser;
	
	private User user;

	public void given_I_navigate_to_the_mock_application(){
		BrowserDriver.loadPage("http://localhost/MockApplication/html/MockApplication.html");
		LoginView.isDisplayedCheck();
	}

	public void when_I_try_to_login(String credentialsType) {
		//Spring data
		if (validUser !=null){ System.out.println("===========valid user from Spring");}
		if (invalidUser !=null){ System.out.println("========invalid user from Spring");}
		
		
		CredentialsType ct = CredentialsType.credentialsTypeForName(credentialsType);
		switch(ct){
			case VALID:
				// use TestNG data if available
				user = validUser!=null ? validUser: Users.createValidUser();
			break;
			case INVALID:
				// use TestNG data if available
				user = invalidUser!=null ? invalidUser : Users.createInvalidUser();
			break;
		}
		LoginView.login(user.getUsername(), user.getPassword());
	}
	
	public void then_I_login(String outcomeString){
		Outcome outcome = Outcome.outcomeForName(outcomeString);
		switch(outcome){
			case SUCCESS:
				LoginView.checkLoginSuccess();
			break;
			case FAILURE:
				LoginView.checkLoginErrors();
			break;
		}
	}
	
	
}
