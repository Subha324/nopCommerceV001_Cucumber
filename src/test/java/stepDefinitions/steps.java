package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CustomerPage;
import pageObjects.SearchCustomerPage;
import pageObjects.loginPage;

public class steps extends BaseClass {
	

	@Given("User Launch the Chrome browser")
	public void user_Launch_the_Chrome_browser() {
		WebDriverManager.chromedriver().setup();

		myDriver = new ChromeDriver();
		myDriver.manage().window().maximize();

		Ip = new loginPage(myDriver);
		
		addcust=new CustomerPage(myDriver);
	}

	@When("User open URL {string}")
	public void user_open_URL(String url) {
		myDriver.get(url);
	}

	@When("User enters Email as  {string} and password as {string}")
	public void user_enters_Email_as_and_password_as(String email, String password) {
		Ip.setUserName(email);
		Ip.setUserPassword(password);

	}

	@When("Click login")
	public void click_login() {
		Ip.clickLogin();

	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
		if (myDriver.getPageSource().contains("Login was unsuccessful")) {
			myDriver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, myDriver.getTitle());
		}
      
	}

	@Then("Click on logout")
	public void click_on_logout() throws Exception {
		Ip.clickLogout();
		Thread.sleep(2000);

	}

	@Then("close")
	public void close() {
		myDriver.close();
		myDriver.quit();
		myDriver = null;

	}
	
	
	// ************************Add customers*******************************************************
	
	
	@Then("User can view Dashboard")
	public void user_can_view_Dashboard() {
		addcust=new CustomerPage(myDriver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addcust.getPageTitle());
	}

	@When("User Click on customer Menu")
	public void user_Click_on_customer_Menu() throws Exception {
		Thread.sleep(3000);
		addcust.clickOnCustomerMenu();
	   
	}

	@When("Click on Customers Menu item")
	public void click_on_Customers_Menu_item() throws Exception {
		Thread.sleep(3000);
		addcust.clickOnCustomerList();;
	   
	}

	@When("Click on Add new button")
	public void click_on_Add_new_button() throws Exception {
		Thread.sleep(3000);
		addcust.addNewCustomer();
	    
	}

	@Then("User can view Add new customer page")
	public void user_can_view_Add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addcust.getPageTitle());
		
	   
	}

	@When("User enter Customer info")
	public void user_enter_Customer_info() throws Exception {
		
		String email=randomstring()+"@gmail.com";
		addcust.setEmail(email);
		addcust.setPassword("test123");
		addcust.setFirstName("Subha");
		addcust.setLastName("utest");
		addcust.setDOB("7/07/1990");
		addcust.setCompanyName("QAtest");
		addcust.setGenderFemale("Female");
		//addcust.setCustomerRole("Guests");
		//addcust.setManagerOfVendors("Vendor 2");
		addcust.setAdmincomment("This is my first role");
		Thread.sleep(3000);
		//addcust.setCustomerRole("Guests");
		//addcust.setManagerOfVendors("Vendor 2");
		
		
		
	   
	}

	@When("Click on Save button")
	public void click_on_Save_button() throws Exception {
		Thread.sleep(3000);
		addcust.clickOnSave();
		
	    
	}

	@Then("User can view Confirmation Message {string}")
	public void user_can_view_Confirmation_Message(String msg) {
	   Assert.assertTrue(myDriver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
	}

	@Then("Close browser")
	public void close_browser() {
		myDriver.close();
	    
	}
//************************************Searching a Customer BY Email ID ******************************************************************

	@When("Click on Arrowdown button")
	public void click_on_Arrowdown_button() throws Exception {
		Thread.sleep(2000);
		 searchCust = new SearchCustomerPage(myDriver); 
		 searchCust.clickOnArrow();
	}

	
	
	
	@When("Enter Customer Email")
	public void enter_Customer_Email() {
		 searchCust = new SearchCustomerPage(myDriver);
		searchCust.setEmail("brenda_lindgren@nopCommerce.com");
	   
	}

	@When("Click on Search button")
	public void click_on_Search_button() throws Exception {
		searchCust.clickSearch();
		Thread.sleep(2000);
	    
	}

	@Then("User should found Email in the Serach table")
	public void user_should_found_Email_in_the_Serach_table() {
		boolean status=searchCust.searchCustomerByEmail("brenda_lindgren@nopCommerce.com");
		Assert.assertEquals(true,status);
		
	    	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
