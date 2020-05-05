package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerPage {
	public WebDriver Idriver;

	// ******************
	// Constructor**************************************************************

	public CustomerPage(WebDriver rDriver) {
		Idriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	// ******************************Identification*************************************************

	@FindBy(xpath = "//a[@href='#']//span[contains(text(),'Customers')]")	WebElement linkCustomerMenu;
	@FindBy(xpath = "//li[@class='treeview menu-open']//ul[@class='treeview-menu']//li//span[@class='menu-item-title'][contains(text(),'Customers')]")	WebElement linkCustomerMenu_list;
	@FindBy(xpath = "//a[@class='btn bg-blue']")	WebElement AddNewCustomerBtn;
	@FindBy(xpath = "//div[@class='opened panel-heading']/span")	WebElement Page_Title;
	@FindBy(xpath = "//input[@id='Email']")	WebElement txtCustomerEmailId;
	@FindBy(xpath = "//input[@id='Password']")	WebElement txtCustomerPassword;
	@FindBy(xpath = "//input[@id='FirstName']")	WebElement txtCustomerFirstName;
	@FindBy(xpath = "//input[@id='LastName']")	WebElement txtCustomerLastName;

	@FindBy(xpath = "//input[@id='Gender_Female']")	WebElement Gender_Female_Btn;

	@FindBy(xpath = "//input[@id='Gender_Male']")	WebElement Gender_Male_Btn;

	@FindBy(xpath = "//input[@id='DateOfBirth']")	WebElement txtDate_Of_Birth;

	@FindBy(xpath = "//input[@id='Company']")	WebElement txtCompany_Name;

	@FindBy(xpath = "//input[@id='IsTaxExempt']")	WebElement IS_tax_Button;

	@FindBy(xpath = "/input[@value='1']")	WebElement Newsletter_btn;

	@FindBy(xpath = "//div[@class='k-multiselect-wrap k-floatwrap']")	WebElement txtCustomerRole;

	@FindBy(xpath = "//li[contains(text(),'Administrators')]")	WebElement list_item_Admin;

	@FindBy(xpath = "//li[contains(text(),'Forum Moderators')]")	WebElement list_item_Moderator;

	@FindBy(xpath = "//li[contains(text(),'Guests')]")	WebElement list_item_Guest;

	@FindBy(xpath = "//li[contains(text(),'Registered')]")	WebElement list_item_Registered;
	@FindBy(xpath = "//li[contains(text(),'Vendors')]")	WebElement list_item_Vendors;

	@FindBy(xpath = "//*[@id='VendorId']")	WebElement List_Manager_Vender;
	@FindBy(xpath = "//*[@id='AdminComment']")	WebElement txtAdmin_Comment;
	@FindBy(xpath = "//button[@name='save']")	WebElement SaveBtn;
	@FindBy(xpath = "//*[@id='SelectedCustomerRoleIds_taglist']/li/span")	WebElement customerRoleRegister;

	// *************************Action
	// Method******************************************************
	
	public String getPageTitle() {
		return Idriver.getTitle();
	}
	
	
	public void clickOnCustomerMenu() {
		linkCustomerMenu.click();

	}

	public void clickOnCustomerList() {
		linkCustomerMenu_list.click();
	}

	public void addNewCustomer() {
		AddNewCustomerBtn.click();
	}

	public void verifyPageTitle() {
		Page_Title.isDisplayed();
	}

	public void setEmail(String email) {

		txtCustomerEmailId.sendKeys(email);
	}

	public void setPassword(String pwd) {

		txtCustomerPassword.sendKeys(pwd);
	}

	public void setFirstName(String fName) {

		txtCustomerFirstName.sendKeys(fName);
	}

	public void setLastName(String lName) {

		txtCustomerLastName.sendKeys(lName);
	}

	public void setGenderFemale(String gender) {

		if (gender.equals("Female")) {

			Gender_Female_Btn.click();
		} else if (gender.equals("Male")) {
			Gender_Male_Btn.click();
		}
	}

	public void setGenderMale() {

		Gender_Male_Btn.click();
	}

	public void setDOB(String DateOfBirth) {

		txtDate_Of_Birth.sendKeys(DateOfBirth);
	}

	public void setCompanyName(String CompanyName) {

		txtCompany_Name.sendKeys(CompanyName);
	}

	public void clickOnTax() {

		IS_tax_Button.click();
	}

	public void clickOnNewletter(String email) {

		Newsletter_btn.click();
	}

	public void setCustomerRole(String role) throws Exception {
		WebElement listItem = null;
		if (!role.equals("Vendors")) {

			customerRoleRegister.click();
		}
		txtCustomerRole.click();
		Thread.sleep(2000);

		if (role.equals("Administrators")) {
			listItem = list_item_Admin;

		} else if (role.equals("Forum Moderators"))

		{
			listItem = list_item_Moderator;
		} else if (role.equals("Guests")) {
			listItem = list_item_Guest;
		} else if (role.equals("Vendors")) {
			listItem = list_item_Vendors;
		}
//listItem.click();
		JavascriptExecutor js=(JavascriptExecutor)Idriver;
		js.executeScript("arguments[0].click(, args);",listItem);
	}

	public void setManagerOfVendors(String value) {

		Select drp = new Select(List_Manager_Vender);
		drp.selectByVisibleText(value);

	}

	public void clickOnSave() {
		
				SaveBtn.click();
	}

	public void setAdmincomment(String content) {
		txtAdmin_Comment.sendKeys(content);
	}

}
