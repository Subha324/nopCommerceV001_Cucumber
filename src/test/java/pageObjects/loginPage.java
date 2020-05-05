package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
 public WebDriver Idriver;
 public loginPage(WebDriver rDriver) {
	 Idriver= rDriver;
	 PageFactory.initElements(rDriver, this);
 }
 
 @FindBy(id="Email")
 @CacheLookup
 WebElement txtEmail;
 
 
 @FindBy(id="Password")
 @CacheLookup
 WebElement txtPassword;
 

 @FindBy(xpath="//input[@value='Log in']")
 @CacheLookup
 WebElement  btnLogin;

 @FindBy(linkText="Logout")
 @CacheLookup
 WebElement  InkLogout;
 
 
 public void setUserName(String uname) {
	 txtEmail.clear();
	 txtEmail.sendKeys(uname);
	
 }
 
 public void setUserPassword(String pwd) {
	 txtPassword.clear();
	 txtPassword.sendKeys(pwd);
	
 }
 
 
 public void clickLogout() {
	 InkLogout.click();
 }
 
 
 public void clickLogin() {
	 btnLogin.click();
 }
}
