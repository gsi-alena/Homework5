package goheavy.vehicle;
import static org.junit.Assert.fail;

import java.util.HashMap;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import goheavy.vehicle.page.VehiclePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import selenium_cucumber.selenium_cucumber.general.Setup;
import selenium_cucumber.selenium_cucumber.general.Steps;
import selenium_cucumber.selenium_cucumber.goheavy.account.page.AccountPage;
import selenium_cucumber.selenium_cucumber.goheavy.login.page.LoginPage;

public class VehicleStep extends Steps{
	public VehiclePage vehiclePage;
	
	public VehicleStep() {
		vehiclePage = new VehiclePage();

	}
	
	public void checkPage() {
		String path = vehiclePage.getPagePath().toLowerCase();
		Assert.assertTrue(" The path privide is not correct in the url. path: " + path,
				vehiclePage.getCurrentUrl().toLowerCase().contains(path));

		/*try {
			vehiclePage.waitForSpinningElementDissapear();
			vehiclePage.getFrom();
		} catch (Exception e) {
			fail("The view do not match with Vehicle and Insurance page.");
		}*/
	}	
	public void openVehicles_and_Insurance_listview() {
		
			HashMap<String, WebElement> li = vehiclePage
					.getMenu(By.xpath("//span[@aria-label='car']/ancestor::span[@class='ant-menu-title-content']"));
			WebElement veh = li.get("Vehicles");
			Setup.getActions().moveToElement(veh).click().perform();
			Setup.getWait().thread(4000);
			vehiclePage.waitForSpinningElementDissapear();
			//WebElement el2 = veh.findElement(By.xpath("//span[@aria-label='profile']/ancestor::li[@role='menuitem']"));
			//Setup.getActions().moveToElement(el2).click().perform();
			//vehiclePage.waitForSpinningElementDissapear();
			//Setup.getWait().thread(4000);
	}

	public void checkSpinningAppears() {
		vehiclePage.waitForSpinningElementDissapear();

	}

	public void checkIsStep1() {
		checkSpinningAppears();
		vehiclePage.stepOne();
	}
	public void checkIsStep2() {
		checkSpinningAppears();
		vehiclePage.stepTwo();
	}
	public void checkIsStep3() {
		checkSpinningAppears();
		vehiclePage.stepThree();
	}
	public void clicksAddVehicle() {
		Setup.getActions().moveToElement(vehiclePage.getAddVehicleButton()).click().perform();
		checkSpinningAppears();

	}
	public void user_insert_valid_data_in_step_one_vehicle_info() {
	   vehiclePage.setSaveFormElementsStep1();
	}
	
	public void clicks_on_the_step_one_next_button() {
		Setup.getActions().moveToElement(vehiclePage.getNextButtonStep1()).click().perform();  
	}
	
	public void user_insert_valid_data_in_step_two_vehicle_features() {
	  vehiclePage.setSaveFormElementsStep2();  
	}

	
	public void clicks_on_the_step_two_next_button() {
		Setup.getActions().moveToElement(vehiclePage.getNextButtonStep2()).click().perform();   
	}

	
	public void user_insert_valid_data_in_step_three_driving_requirements() {
	    vehiclePage.setSaveFormElementsStep3();
	}

	
	public void clicks_on_the_done_button() {
		Setup.getActions().moveToElement(vehiclePage.getDoneButtonStep3()).click().perform();  
	}

	
	public void the_system_saves_the_new_vehicle_information() {
	   checkSpinningAppears();
	}
    
	
	public void the_system_displays_popup_with_success_message(String message) {
	    vehiclePage.checkSaveMessage(message);
	}
}
