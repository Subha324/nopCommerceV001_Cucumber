package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.CustomerPage;
import pageObjects.SearchCustomerPage;
import pageObjects.loginPage;

public class BaseClass {
	public WebDriver myDriver;
	public loginPage Ip;
	public CustomerPage addcust;
	public SearchCustomerPage searchCust;
	
	//Created for generating random string for Email id
	public static String randomstring() {
		
		String generatedString1=RandomStringUtils.randomAlphabetic(6);
		return(generatedString1);
	}
}
