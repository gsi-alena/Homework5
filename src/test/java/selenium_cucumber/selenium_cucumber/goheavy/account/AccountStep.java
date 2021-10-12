package selenium_cucumber.selenium_cucumber.goheavy.account;

import static org.junit.Assert.fail;

import java.util.HashMap;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import selenium_cucumber.selenium_cucumber.general.Setup;
import selenium_cucumber.selenium_cucumber.general.Steps;
import selenium_cucumber.selenium_cucumber.goheavy.account.page.AccountPage;
import selenium_cucumber.selenium_cucumber.goheavy.login.page.LoginPage;

public class AccountStep extends Steps {

	private AccountPage accountPage;
    boolean fieldvalidationresult = false;
    
	public AccountStep() {
		accountPage = new AccountPage();

	}

	@Override
	public void checkPage() {
		String path = accountPage.getPagePath().toLowerCase();
		Assert.assertTrue(" The path privide is not correct in the url. path: " + path,
				accountPage.getCurrentUrl().toLowerCase().contains(path));

		try {
			accountPage.waitForSpinningElementDissapear();
			accountPage.getFrom();
		} catch (Exception e) {
			fail("The view do not match with Account page.");
		}
	}

	public void openAccountSetting() {
		HashMap<String, WebElement> li = accountPage
				.getMenu(By.xpath("//span[@aria-label='setting']/ancestor::span[@class='ant-menu-title-content']"));
		WebElement setting = li.get("Settings");
		Setup.getActions().moveToElement(setting).click().perform();
		Setup.getWait().thread(400);
		accountPage.waitForSpinningElementDissapear();
		WebElement el2 = setting.findElement(By.xpath("//span[@aria-label='profile']/ancestor::li[@role='menuitem']"));
		Setup.getActions().moveToElement(el2).click().perform();
		accountPage.waitForSpinningElementDissapear();
		Setup.getWait().thread(4000);

	}

	public void fillValidData() {
		accountPage.getFromElements();
	}

	public void clicksUpdate() {
		Setup.getActions().moveToElement(accountPage.getUpdateButton()).click().perform();

	}

	public void checkSpinningAppears() {
		accountPage.waitForSpinningElementDissapear();

	}

	public void checkUpdateMessage(String message) {

		WebElement notifEle = accountPage.getPopupMessage();
		Setup.getWait().thread(2);
		WebElement parent = notifEle
				.findElement(By.xpath("ancestor::div[contains(@class,'ant-notification-topRight')]"));

		// Checking messages match
		Assert.assertEquals("Save notification message was not found.", message.toLowerCase(),
				notifEle.getText().toLowerCase());
		
		// Checking that popup is in the right
		String style = parent.getAttribute("style");
		Assert.assertTrue("Popup is not in the right corner.", style.contains("right: 0px"));

	}
	
	public void the_user_insert_no_valid_data_in_field(String baddata,String fieldname) {
	    accountPage.setFieldData(baddata,fieldname);
	   
	}

	
	public void the_system_displays_an_error_message(String errormessage) {
	   
	    accountPage.validation_error_message(errormessage);	   
	}

}
