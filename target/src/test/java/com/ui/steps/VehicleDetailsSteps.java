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
import org.assertj.core.api.SoftAssertions;

import static com.ui.steps.SharedData.TEST_DATA_PATH;
import static org.assertj.core.api.InstanceOfAssertFactories.comparable;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isIn;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * @version $Id$
 */
public class VehicleDetailsSteps {
    @Steps
    VehicleDetailsActions vehicleDetailsActions;
    @Steps
    HomePageActions homePageActions;

    private List<String> inputVehicleRegistrationNumbers;

    private List<VehicleDetailsDTO> actualVehicleDetailsList;

    @Then("I should verify the following information on the vehicle details page")
    public void i_should_verify_the_following_information_on_the_vehicle_details_page(io.cucumber.datatable.DataTable dataTable) {
        List<String> lists = dataTable.asList();
        for (String list : lists) {
            if (list.equalsIgnoreCase("Registration")) {
                vehicleDetailsActions.verifyVehicleModel("kshfskfh");
            }
            System.out.println(list);
        }
    }

    @When("I collect the valid vehicles registration numbers from the {string} data file")
    public void collectVehicleRegNumbers(String inputDataFileName) throws IOException {
        inputVehicleRegistrationNumbers = FileReaderUtils.readAndFindCarRegValueFromTextFile(inputDataFileName);
        if (inputVehicleRegistrationNumbers.isEmpty()) {
            throw new IOException("Valid vehicle registration numbers not found in the file: " + inputDataFileName);
        }
    }

    @When("I capture the vehicles data for the valid registered numbers")
    public void captureVehiclesData() {
        actualVehicleDetailsList = new ArrayList<>();
        ;
        VehicleDetailsDTO vehicleDetailsDTO;
        for (String regNumber : inputVehicleRegistrationNumbers) {
            vehicleDetailsDTO = new VehicleDetailsDTO();
            homePageActions.enterCarRegistrationNumber(regNumber);
            homePageActions.clickFreeCheckButton();
            if (homePageActions.isVehicleNotFound()) {
                homePageActions.tryAnotherVehicleCheck();
                continue;
            }
            vehicleDetailsDTO.setRegistration(vehicleDetailsActions.getVehicleRegistration());
            vehicleDetailsDTO.setColor(vehicleDetailsActions.getVehicleColor());
            vehicleDetailsDTO.setModel(vehicleDetailsActions.getVehicleModel());
            vehicleDetailsDTO.setMake(vehicleDetailsActions.getVehicleMake());
            vehicleDetailsDTO.setYear(vehicleDetailsActions.getVehicleYear());
            actualVehicleDetailsList.add(vehicleDetailsDTO);
            vehicleDetailsActions.clickResetVehicleDetailsButton();
        }
    }

    @When("I compare the captured vehicles data with the expected data from the {string} data file")
    public void verifyVehiclesData(String expectedDataOutputFile) throws Exception {

        List<VehicleDetailsDTO> expectedVehicleDetailsList = VehicleDetailsCSVReader.readOutputTestData(TEST_DATA_PATH + expectedDataOutputFile);
        if (expectedVehicleDetailsList.isEmpty()) {
            throw new IOException("Expected data is not available in the output file: " + expectedDataOutputFile);
        }

        for (String vNumber : inputVehicleRegistrationNumbers) {
            if (actualVehicleDetailsList.isEmpty()) {
                throw new Exception("Actual data not found");
            }
            VehicleDetailsDTO aMatchingVehicleDataObject = actualVehicleDetailsList.stream().
                    filter(actualVehicleDetailsList -> actualVehicleDetailsList.getRegistration().equalsIgnoreCase(vNumber))
                    .findAny().orElse(null);

            VehicleDetailsDTO eMatchingVehicleDataObject = expectedVehicleDetailsList.stream().
                    filter(eVehicleData -> eVehicleData.getRegistration().equalsIgnoreCase(vNumber)).
                    findAny().orElse(null);

            SoftAssertions softAssertions = new SoftAssertions();
            String aRegistrationNumber = aMatchingVehicleDataObject.getRegistration();
            String eRegistrationNumber = eMatchingVehicleDataObject.getRegistration();

            softAssertions.assertThat(aRegistrationNumber)
                    .overridingErrorMessage(
                            "Expected the vehicle registration number to be: %s but it was: %s", eRegistrationNumber, aRegistrationNumber)
                    .isEqualTo(eRegistrationNumber);

            String aModel = aMatchingVehicleDataObject.getModel();
            String eModel = eMatchingVehicleDataObject.getModel();
            softAssertions.assertThat(aModel)
                    .overridingErrorMessage(
                            "Expected the vehicle model to be: %s but it was: %s", eModel, aModel)
                    .isEqualTo(eModel);

            String aYear = aMatchingVehicleDataObject.getYear();
            String eYear = eMatchingVehicleDataObject.getYear();
            softAssertions.assertThat(aYear)
                    .overridingErrorMessage(
                            "Expected the vehicle year to be: %s but it was: %s", eYear, aYear)
                    .isEqualTo(eYear);

            String aMake = aMatchingVehicleDataObject.getMake();
            String eMake = eMatchingVehicleDataObject.getMake();
            softAssertions.assertThat(aMake)
                    .overridingErrorMessage(
                            "Expected the vehicle make to be: %s but it was: %s", eMake, aMake)
                    .isEqualTo(eMake);

            String aColor = aMatchingVehicleDataObject.getColor();
            String eColor = eMatchingVehicleDataObject.getColor();
            softAssertions.assertThat(aColor)
                    .overridingErrorMessage(
                            "Expected the vehicle color to be: %s but it was: %s", eColor, aColor)
                    .isEqualTo(eColor);

            softAssertions.assertAll();
        }
    }
}
