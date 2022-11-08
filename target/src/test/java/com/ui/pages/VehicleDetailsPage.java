/**
 * 
 */
package com.ui.pages;

import com.ui.utils.CommonUtils;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class VehicleDetailsPage extends PageObject
{

    @FindBy(xpath = "//dt[contains(text(),'Registration')]/following-sibling::dd")
    private WebElement vehicleRegistrationNumber;

    @FindBy(xpath = "//dt[contains(text(),'Make')]/following-sibling::dd")
    private WebElement vehicleMake;

    @FindBy(xpath = "//dt[contains(text(),'Model')]/following-sibling::dd")
    private WebElement vehicleModel;

    @FindBy(xpath = "//dt[contains(text(),'Year')]/following-sibling::dd")
    private WebElement vehicleYear;

    @FindBy(xpath = "//dt[contains(text(),'Colour')]/following-sibling::dd")
    private WebElement vehicleColour;

    @FindBy(css = "img[alt='Car Tax Check']")
    private WebElement resetVehicleDetailsButton;



    public String getVehicleRegistrationNumber(){
        CommonUtils.waitForElementToBeVisible(getDriver(), vehicleRegistrationNumber);
        return vehicleRegistrationNumber.getText();
    }

    public String getVehicleMake(){
        CommonUtils.waitForElementToBeVisible(getDriver(), vehicleMake);
        return vehicleMake.getText();
    }

    public String getVehicleModel(){
        CommonUtils.waitForElementToBeVisible(getDriver(), vehicleModel);
        return vehicleModel.getText();
    }

    public String getVehicleYear(){
        CommonUtils.waitForElementToBeVisible(getDriver(), vehicleYear);
        return vehicleYear.getText();
    }

    public String getVehicleColour(){
        CommonUtils.waitForElementToBeVisible(getDriver(), vehicleColour);
        return vehicleColour.getText();
    }

    public void clickResetVehicleCheckPage(){
        CommonUtils.waitForElementToBeVisible(getDriver(), resetVehicleDetailsButton);
        resetVehicleDetailsButton.click();
    }


}
