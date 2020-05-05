package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {

	public WebDriver Idriver;
	WaitHelper waithelper;

	public SearchCustomerPage(WebDriver rDriver) {
		Idriver = rDriver;
		PageFactory.initElements(rDriver, this);
		waithelper = new WaitHelper(Idriver);
	}

	@FindBy(how = How.ID, using = "SearchEmail")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(how = How.ID, using = "SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;

	@FindBy(how = How.ID, using = "search-customers")
	@CacheLookup
	WebElement btnSearch;

	@FindBy(how = How.XPATH, using = "//table[@role='grid']")
	@CacheLookup
	WebElement tblSearchResult;

	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;

	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody")
	@CacheLookup
	List<WebElement> tableRows;

	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody//td")
	@CacheLookup
	List<WebElement> tableColumns;

	@FindBy(how = How.XPATH, using = "//i[@class='fa fa-angle-down']")
	@CacheLookup
	WebElement btnArrowdown;

	public void setEmail(String email) {
		waithelper.waitForElement(txtEmail, 30);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void clickOnArrow() {
		btnArrowdown.click();
		

		waithelper.waitForElement(btnArrowdown, 30);
	}

	public void clickSearch() {
		btnSearch.click();
		waithelper.waitForElement(btnSearch, 30);

	}

	public int getNoOfRow() {
		return (tableRows.size());

	}

	public int getNoOfColumsw() {
		return (tableColumns.size());

	}

	public boolean searchCustomerByEmail(String email) {
		boolean flag = false;
		for (int i = 1; i <= getNoOfRow(); i++) {
			String emailid = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println("EmailId: " + emailid);

			if (emailid.equals(email)) {
				flag = true;
			}
		}

		return flag;
	}

}
