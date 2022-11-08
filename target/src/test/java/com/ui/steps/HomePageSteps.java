/**
 *
 */
package com.ui.steps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ui.actions.HomePageActions;
import com.ui.actions.VehicleDetailsActions;
import com.ui.dto.VehicleDetailsDTO;
import com.ui.utils.FileReaderUtils;
import com.ui.utils.VehicleDetailsCSVReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.isIn;

public class HomePageSteps extends SharedData {
    @Steps
    HomePageActions homePageActions;

    @Given("I navigate to the vehicle tax check application")
    public void i_open_the_car_tax_check_url() {
        homePageActions.openCarTaxCheckAppUrl();
    }

    @Then("I should see the home page title as {string}")
    public void i_should_see_jungle_socks_home_page(String title) {
        homePageActions.verifyCarTaxCheckHomePageTitle(title);
    }

    @Then("I should see the home page header as {string}")
    public void i_should_see_jungle_socks_home_page_header_as(String header) {
        homePageActions.verifyCarTaxCheckHomePageHeader(header);
    }

    @When("I enter the {string} number into the registration number input text box")
    public void i_enter_the_number_into_the_registration_number_input_text_box(String vehicleRegNumber) {
        homePageActions.enterCarRegistrationNumber(vehicleRegNumber);
    }

    @When("I clicks on free check button")
    public void i_clciks_on_checkout_button_of_jungle_socks() throws IOException {
        homePageActions.clickFreeCheckButton();
    }
}
