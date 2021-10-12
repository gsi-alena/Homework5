package goheavy.vehicle;
import io.cucumber.java.en.*;
import selenium_cucumber.selenium_cucumber.goheavy.account.AccountStep;

public class VehicleStepDefinition {

	private VehicleStep vehicleStep;
	public boolean result;

	public VehicleStepDefinition() {
		vehicleStep = new VehicleStep();
	}


	@Given("The user is in Vehicles and Insurance List view")
	public void the_user_is_in_vehicles_and_insurance_list_view() {
	   vehicleStep.openVehicles_and_Insurance_listview();
	   vehicleStep.checkPage();
	}
	@When("Clicks on the AddVehicle button")
	public void clicks_on_the_add_vehicle_button() {
	    vehicleStep.clicksAddVehicle();
	}
	@When("User insert valid data in step one Vehicle Info")
	public void user_insert_valid_data_in_step_one_vehicle_info() {
	    vehicleStep.user_insert_valid_data_in_step_one_vehicle_info();
	}

	@When("Clicks on the step one Next button")
	public void clicks_on_the_step_one_next_button() {
		vehicleStep.clicks_on_the_step_one_next_button();
	}

	@When("User insert valid data in step two Vehicle Features")
	public void user_insert_valid_data_in_step_two_vehicle_features() {
		vehicleStep.checkIsStep2();
	    vehicleStep.user_insert_valid_data_in_step_two_vehicle_features();
	}

	@When("Clicks on the step two Next button")
	public void clicks_on_the_step_two_next_button() {
	    vehicleStep.clicks_on_the_step_two_next_button();
	}

	@When("User insert valid data in step three Driving Requirements")
	public void user_insert_valid_data_in_step_three_driving_requirements() {
		vehicleStep.checkIsStep3();
	    vehicleStep.user_insert_valid_data_in_step_three_driving_requirements();
	}

	@When("Clicks on the Done button")
	public void clicks_on_the_done_button() {
	    vehicleStep.clicks_on_the_done_button();
	}

	@Then("The system saves the new vehicle information")
	public void the_system_saves_the_new_vehicle_information() {
	    vehicleStep.the_system_saves_the_new_vehicle_information();;
	}

	@Then("The system displays popup with success message {string}")
	public void the_system_displays_popup_with_success_message(String successmessage) {
	    vehicleStep.the_system_displays_popup_with_success_message(successmessage);
	}
}
