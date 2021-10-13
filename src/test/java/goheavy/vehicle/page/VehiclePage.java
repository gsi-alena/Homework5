package goheavy.vehicle.page;
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

public class VehiclePage extends PageObject{
	private String formScroll = "//div[contains(@class,'ant-steps ant-steps-horizontal ant-steps-label-horizontal')]/ancestor::div[@class='templateStyles__ContentDiv-sc-144t9h2-1 bcVeZj']";
	String url = "C:\\Users\\windows10\\eclipse-workspace\\Homework04\\src\\main\\resources\\avatar.png";
	public VehiclePage() {
		super();
		this.urlpath = "vehicleinsurance";
	}
	public WebElement getForm1() {
		return this.getWebElement(By.xpath("//form[@id='step-one-form']"));
	}
	public WebElement getForm2() {
		return this.getWebElement(By.xpath("//form[@id='step-two-form']"));
	}
	public WebElement getForm3() {
		return this.getWebElement(By.xpath("//form[@id='step-three-form']"));
	}
	public WebElement getAddVehicleButton() {
		return this.getWebElement(By.xpath("//button[contains(@class,'ant-btn ant-btn-primary')]"));
	}
	public WebElement getNextButtonStep1() {
		return this.getWebElement(By.xpath("//form[@id='step-one-form']/descendant::button[@type='submit']"));
	}
	public WebElement getNextButtonStep2() {
		return this.getWebElement(By.xpath("//form[@id='step-two-form']/descendant::button[@type='submit']"));
	}
	public WebElement getDoneButtonStep3() {
		return this.getWebElement(By.xpath("//form[@id='step-three-form']/descendant::button[@type='submit']"));
	}
	public void stepOne() {
		//Estoy en Vehicles/Vehicle ////span[contains(@class,'styles__BreadcrumbContentWrapper-sc-1nf8gtd-1 hixHxD')]
		//Vehicle Info
		WebElement i = getWebElement(By.xpath("//label[@title='VIN Image']"));
		boolean a = i.getText().equals("VIN Image");
		Assert.assertTrue(i.getText().equals("VIN Image"));
	}
	public void stepTwo() {
		//Estoy en Vehicles/Vehicle ////span[contains(@class,'styles__BreadcrumbContentWrapper-sc-1nf8gtd-1 hixHxD')]
		//Vehicle Info
		WebElement i = getWebElement(By.xpath("//label[@title='Vehicle Model']"));
		boolean a = i.getText().equals("Vehicle Model");
		Assert.assertTrue(i.getText().equals("Vehicle Model"));
	}
	public void stepThree() {
		//Estoy en Vehicles/Vehicle ////span[contains(@class,'styles__BreadcrumbContentWrapper-sc-1nf8gtd-1 hixHxD')]
		//Vehicle Info
		WebElement i = getWebElement(By.xpath("//label[@title='Current Insurance Certificate Picture']"));
		boolean a = i.getText().equals("Current Insurance Certificate Picture");
		Assert.assertTrue(i.getText().equals("Current Insurance Certificate Picture"));
	}
	//Arreglar
	public boolean isVehicleList() {
		//Estoy en Vehicles
		WebElement i = getWebElement(By.xpath("//div[contains(@class,'ant-steps-item-title')]"));
		boolean a = i.getText().equals("Vehicle");
		Assert.assertTrue(i.getText().equals("Vehicle"));
		return a;
	}

	public void setVehicleType() {
		waitForSpinningElementDissapear();
		Setup.getWait().thread(500);
		this.getWebElement(By.xpath("//input[@id='vehicleTypeId'and @role='combobox']")).click();
		this.getWebElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']")).click();
		Setup.getWait().thread(500);	
	}
	public void setYear() {
		waitForSpinningElementDissapear();
		Setup.getWait().thread(500);
		this.getWebElement(By.xpath("//input[@placeholder='Enter the vehicle year']")).click();
		this.getWebElement(By.xpath("//table[@class='ant-picker-content']")).click();
		Setup.getWait().thread(500);
	}
	public void setSaveFormElementsStep1() {//setear los elementos de esta vista
        stepOne();//verifico si estoy en la vista 1
		// Vin Photo
		WebElement bot= this.getWebElement(By.xpath("//span[contains(.,'Click')]/ancestor::button[@type='button']"));
		WebElement photo = this.getWebElement(By.xpath("//label[@title='VIN Image']/ancestor::div[contains(@class,'ant-row ant-form-item')]/descendant::input[@type='file']"));
		photo.sendKeys(url);
		
		// Scrolling the page to get the element activated
		//this.scroll(formScroll, By.id("vin"));

		// Set VIN
		WebElement vin = this.getWebElement(By.id("vin"));
		vin.clear();
		vin.sendKeys("11111111111111111");
		
		// Setting VehicleType
		setVehicleType();		
		
		// this.getWebElement(By.id("vehicleTypeId_list")).sendKeys("LeolaCoby");
		// Setting Make
		WebElement make = this.getWebElement(By.id("make"));
		make.clear();
		make.sendKeys("MakeAlena1");
		//Setup.getActions().moveToElement(make).click().perform();

		//Setting Vehicle Year
		setYear();
		
		// Scrolling the page to get the element activated
			this.scroll(formScroll, By.id("payload"));
				
	    //Setting Playload
		WebElement playload = this.getWebElement(By.id("playload"));
		playload.clear();
		playload.sendKeys("50");
	    
		//Dimensions
		//Long
		WebElement long1 = this.getWebElement(By.id("long"));
		long1.clear();
		long1.sendKeys("50");
		//Width
		WebElement width1 = this.getWebElement(By.id("width"));
		width1.clear();
		width1.sendKeys("20");
		//Height
		WebElement height1 = this.getWebElement(By.id("height"));
		height1.clear();
		height1.sendKeys("35");
		
		//Getting Floorspace 
		WebElement floorspace = this.getWebElement(By.id("floorSpace"));
		
		//Getting loadingSpace 
		WebElement loadingSpace = this.getWebElement(By.id("loadingSpace"));
		
		
	}
	public void setSaveFormElementsStep2() {
//		HashMap<String, WebElement> 

		//Vehicle model
		WebElement model = this.getWebElement(By.id("model"));
		model.clear();
		model.sendKeys("ModelA");
        
		//Color
		WebElement color = this.getWebElement(By.id("color"));
		color.clear();
		color.sendKeys("Green");
		
		//Trim
		WebElement trim = this.getWebElement(By.id("trim"));
		trim.clear();
		trim.sendKeys("TrimA");
		
		//Transmission
		WebElement trans = this.getWebElement(By.id("transmission"));
		trans.clear();
		trans.sendKeys("TransA");
		
		// Scrolling the page to get the element activated
		this.scroll(formScroll, By.xpath("//label[@title='Towing Kit Installed']/ancestor::div[contains(@class,'ant-row ant-form-item')]/descendant:: div[contains(@class,'ant-switch-handle')]"));// Scrolling the page to get the element activated
		
		//Towing
		WebElement towing = this.getWebElement(By.xpath("//label[@title='Towing Kit Installed']/ancestor::div[contains(@class,'ant-row ant-form-item')]/descendant:: div[contains(@class,'ant-switch-handle')]"));
		towing.click();//set true
		
		//Liftgate
		WebElement liftgate = this.getWebElement(By.xpath("//label[@title='Liftgate Installed']/ancestor::div[contains(@class,'ant-row ant-form-item')]/descendant:: div[contains(@class,'ant-switch-handle')]"));
        liftgate.click();//set true
        
        //Vehicle Photo
        WebElement photo = this.getWebElement(By.xpath("//label[@title='Vehicle Photo (from front driver side angle)']/ancestor::div[contains(@class,'ant-row ant-form-item')]/descendant::input[@type='file']"));
		String url = (String) Setup.getValueStore("avatar");
		photo.sendKeys(url);
		
		/*WebElement bot= this.getWebElement(By.xpath("//span[contains(.,'Click')]/ancestor::button[@type='button']"));
		WebElement photo = this.getWebElement(By.xpath("//label[@title='VIN Image']/ancestor::div[contains(@class,'ant-row ant-form-item')]/descendant::input[@type='file']"));
		photo.sendKeys(url);*/
	}
	public void setSaveFormElementsStep3() {
//		HashMap<String, WebElement> 
		//Current Insurrance Photo
        WebElement photo = this.getWebElement(By.xpath("//label[@title='Current Insurance Certificate Picture']/ancestor::div[contains(@class,'ant-row ant-form-item')]/descendant::input[@type='file'] "));
		String url = (String) Setup.getValueStore("avatar");
		photo.sendKeys(url);
		//Verification
		//Delivery
		WebElement vdelivery = this.getWebElement(By.id("verificationDelivery"));
		if(!vdelivery.isSelected())
			vdelivery.click();//set true
		//License
		WebElement vlicense = this.getWebElement(By.id("verificationLicenseTime"));
		if(!vlicense.isSelected())
			vlicense.click();//set true
		
		// Scrolling the page to get the element activated
		this.scroll(formScroll, By.id("insurancePolicyNo"));
		
		//insurancePolicyNo
		WebElement insupolno = this.getWebElement(By.id("insurancePolicyNo"));
		insupolno.clear();
		insupolno.sendKeys("ASW");
		
		//insuranceCertificateCompany
		WebElement inscertcomp = this.getWebElement(By.id("insuranceCertificateCompany"));
		inscertcomp.clear();
		inscertcomp.sendKeys("CompA");
		
		//Insurance Effective Date
		WebElement insefctdate = this.getWebElement(By.xpath("//div[@style='left: 296px; top: 0px;']/descendant::td[@title='2021-10-11']/descendant::div[@class='ant-picker-cell-inner']"));
		//coger el texto del input asociado al picker
		insefctdate.click();
		
		//Insurance Expiration Date
		WebElement insexpdate = this.getWebElement(By.xpath("//div[@style='left: 806px; top: 0px;']/descendant::td[@title='2021-10-16']/descendant::div[@class='ant-picker-cell-inner']"));
		//coger el texto del input asociado al picker
		insexpdate.click();
		
		//Insurance Renewal
		WebElement insrenewal = this.getWebElement(By.id("insuranceRenewal"));
		insrenewal.clear();
		insrenewal.sendKeys("WER");
		
		// Scrolling the page to get the element activated
				this.scroll(formScroll, By.id("licensePlateNo"));

		//Vehicle License Plate No
		WebElement licplateno = this.getWebElement(By.id("licensePlateNo"));
		licplateno.clear();
		licplateno.sendKeys("ATY89");
		
		//License Plate State
		List<WebElement> licenseStateId_list = this.getWebElements(By.xpath(
		"//div[@id='licensePlateStateIssuedId_list']/ancestor::div[contains(@class,'ant-select-dropdown')]"));
		Integer v = licenseStateId_list.size();
		WebElement addr = licenseStateId_list.get(new Random().nextInt(v));
		Setup.getActions().moveToElement(addr).click().perform();
		
		// License Plate Photo
		WebElement licenseplatephoto = this.getWebElement(By.xpath("//label[@title='License Plate Photo']/ancestor::div[contains(@class,'ant-row ant-form-item')]/descendant::input[@type='file']"));
		String url1 = (String) Setup.getValueStore("avatar");
		licenseplatephoto.sendKeys(url1);
		
		// Scrolling the page to get the element activated
		this.scroll(formScroll, By.xpath("//label[@title='Vehicle Registration Sticker']"));
		
		// Vehicle Registration Sticker Photo
		WebElement registrationstickphoto = this.getWebElement(By.xpath("//label[@title='Vehicle Registration Sticker']/ancestor::div[contains(@class,'ant-row ant-form-item')]/descendant::input[@type='file']"));
		String url2 = (String) Setup.getValueStore("avatar");
		registrationstickphoto.sendKeys(url2);
	}
	public WebElement getPopupMessage() {
		Setup.getWait().visibilityOfElement(By.xpath("//div[@class='ant-notification-notice-message']"),
				"Not element message");
		return this.getWebElement(By.xpath("//div[@class='ant-notification-notice-message']"));

	}
	public void checkSaveMessage(String message) {

		WebElement notifEle = getPopupMessage();
		Setup.getWait().thread(2);
		WebElement parent = notifEle
				.findElement(By.xpath("ancestor::div[contains(@class,'ant-notification-topRight')]"));

		// Checking messages match
		Assert.assertEquals("Save notification message was not found.", message.toLowerCase(),
				notifEle.getText().toLowerCase());
		
		// Checking that popup is in the right
		String style = parent.getAttribute("style");
		Assert.assertTrue("Popup is not in the right corner.", style.contains("right: 0px"));
		
		//Verify the user is in vehicle list
		boolean isvehlistview = isVehicleList();
		Assert.assertTrue(isvehlistview);

	}
}
