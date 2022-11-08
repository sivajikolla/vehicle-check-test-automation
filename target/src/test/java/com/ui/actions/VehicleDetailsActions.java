/**
 * 
 */
package com.ui.actions;

import com.ui.pages.VehicleDetailsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class VehicleDetailsActions
{
    VehicleDetailsPage vehicleDetailsPage;

    public void verifyVehicleModel(String vehicleModel) {
        assertThat("Verify create asset page:", vehicleDetailsPage.getVehicleModel(), equalTo(vehicleModel));
    }

    public void clickResetVehicleDetailsButton(){
        vehicleDetailsPage.clickResetVehicleCheckPage();;
    }

    public String getVehicleRegistration(){
        return vehicleDetailsPage.getVehicleRegistrationNumber();
    }

    public String getVehicleModel(){
        return vehicleDetailsPage.getVehicleModel();
    }

    public String getVehicleColor(){
        return vehicleDetailsPage.getVehicleColour();
    }

    public String getVehicleYear(){
        return vehicleDetailsPage.getVehicleYear();
    }

    public String getVehicleMake(){
        return vehicleDetailsPage.getVehicleMake();
    }

}
