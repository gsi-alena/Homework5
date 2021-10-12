package selenium_cucumber.selenium_cucumber.goheavy.account.page;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;

import net.bytebuddy.implementation.FieldAccessor.FieldNameExtractor;
import selenium_cucumber.selenium_cucumber.general.PageObject;
import selenium_cucumber.selenium_cucumber.general.Setup;

public class AccountPage extends PageObject {
	private String formScroll = "//*[@id=\"account-settings\"]/ancestor::div[@class=\"templateStyles__ContentDiv-sc-144t9h2-1 bcVeZj\"]";
	
	String fieldname;
	WebElement field; 
	String fieldtext;
	
	public AccountPage() {
		super();
		this.urlpath = "accountsettings";
	}

	public WebElement getFrom() {
		return this.getWebElement(By.cssSelector("#account-settings"));

	}

	public void getFromElements() {
//		HashMap<String, WebElement> 

		// Setting avatar
		WebElement photo = this.getWebElement(By.xpath("//input[@type='file']"));
		//String url = (String) Setup.getValueStore("avatar");
		//photo.sendKeys(url);

		// Scrolling the page to get the element activated
		this.scroll(formScroll, By.id("addressStateId"));

		// Getting State
		WebElement stateInput = this.getWebElement(By.id("addressStateId"));
		Setup.getActions().moveToElement(stateInput).click().perform();

		// Getting State menu
		List<WebElement> addressStateId_list = this.getWebElements(By.xpath(
				"//div[@id='addressStateId_list']/ancestor::div[contains(@class,'ant-select-dropdown')]/descendant::div[contains(@class,'ant-select-item ant-select-item-option')]/span"));
		Integer v = addressStateId_list.size();
		WebElement addr = addressStateId_list.get(new Random().nextInt(v));
		Setup.getActions().moveToElement(addr).click().perform();

	}

	public WebElement getUpdateButton() {
		return this.getWebElement(By.xpath("//*[@id=\"account-settings\"]//button"));
	}

	public WebElement getPopupMessage() {
		Setup.getWait().visibilityOfElement(By.xpath("//div[@class='ant-notification-notice-message']"),
				"Not element message");
		return this.getWebElement(By.xpath("//div[@class='ant-notification-notice-message']"));

	}
	////Homework 4
	public void setFieldData(String pbaddata,String pfieldname)
	{
		fieldname = pfieldname;
		if (fieldname.equals("First Name")) {
			  field = getWebElement(By.id("firstName"));
			  field.sendKeys(pbaddata);			  
		}else if (fieldname.equals("Last Name")) {
			  field = getWebElement(By.id("lastName"));
			  field.sendKeys(pbaddata);			  
		}else if (fieldname.equals("Email")) {
			  field = getWebElement(By.id("email"));
			  field.sendKeys(pbaddata);			  
		}else if (fieldname.equals("Mobile")) {
			  field = getWebElement(By.id("mobilePhone"));
			  field.clear();
			  field.sendKeys(pbaddata);			  
		}else if (fieldname.equals("Address")) {
			  field = getWebElement(By.id("address"));
			  field.sendKeys(pbaddata);			  
		}else if (fieldname.equals("City")) {
			  field = getWebElement(By.id("addressCity"));
			  field.sendKeys(pbaddata);			  
		}else if (fieldname.equals("Zip Code")) {
			  field = getWebElement(By.id("addressZipCode"));
			  field.clear();
			  field.sendKeys(pbaddata);
		}
	}
	
	public void validation_error_message(String errormessage) {
		
		/*if (fieldname.equals("First Name")) { Variant 1 Jose
			Setup.getWait().textAppear("Only letters and special characters (' -) are allowed. 50 characters maximum");
		}else if (fieldname.equals("First Name")) {
			Setup.getWait().textAppear("Only letters and special characters (' -) are allowed. 50 characters maximum");
		}else if (fieldname.equals("Email")) {
			Setup.getWait().textAppear("Please, enter a valid email address");
		}else*if (fieldname.equals("Mobile")) {
			Setup.getWait().textAppear("Please, enter a valid mobile number");
		}/*else if (fieldname.equals("Address")) {
			Setup.getWait().textAppear("The only special characters allowed are (. - , '). 50 characters maximum");
		}else if (fieldname.equals("City")) {
			Setup.getWait().textAppear("Only letters and special characters (' -) are allowed. 50 characters maximum");
		}else if (fieldname.equals("Zip Code")) {
			Setup.getWait().textAppear("Please, enter a valid ZIP code");
		}
		*/
		//Variant 2
		WebElement field1 = null;
		if(fieldname.equals("First Name")){
		 field1= getWebElement(By.xpath("//input[@id='firstName']/ancestor::div[contains(@class,'ant-form-item-control')]/descendant::div[@role='alert']"));
		}else if(fieldname.equals("Last Name")) {
			field1= getWebElement(By.xpath("//input[@id='lastName']/ancestor::div[contains(@class,'ant-form-item-control')]/descendant::div[@role='alert']"));	
		}else if(fieldname.equals("Email")) {
			field1= getWebElement(By.xpath("//input[@id='email']/ancestor::div[contains(@class,'ant-form-item-control')]/descendant::div[@role='alert']"));	
		}else if(fieldname.equals("Mobile")) {
			field1= getWebElement(By.xpath("//input[@id='mobilePhone']/ancestor::div[contains(@class,'ant-form-item-control')]/descendant::div[@role='alert']"));	
		}else if(fieldname.equals("Address")) {
			field1= getWebElement(By.xpath("//textarea[@id='address']/ancestor::div[contains(@class,'ant-form-item-control')]/descendant::div[@role='alert']"));	
		}else if(fieldname.equals("City")) {
			field1= getWebElement(By.xpath("//input[@id='addressCity']/ancestor::div[contains(@class,'ant-form-item-control')]/descendant::div[@role='alert']"));	
		}else if(fieldname.equals("Zip Code")) {
			field1= getWebElement(By.xpath("//input[@id='addressZipCode']/ancestor::div[contains(@class,'ant-form-item-control')]/descendant::div[@role='alert']"));	
		}
		
		String text =field1.getText();
		boolean response1 = (field1.getText()).equals(errormessage);
		Assert.assertTrue(response1);
	}   
}
