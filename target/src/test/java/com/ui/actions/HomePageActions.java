/**
 *
 */
package com.ui.actions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import com.ui.pages.HomePage;

import com.ui.utils.CommonUtils;
import net.thucydides.core.annotations.Step;

public class HomePageActions {

    HomePage homePage;



    @Step
    public void openCarTaxCheckAppUrl() {
        homePage.open();
    }

    public void verifyCarTaxCheckHomePageTitle(String title) {
        assertThat("Verify create asset page:", homePage.getHomePageTitle(), equalTo(title));
    }

    public void verifyCarTaxCheckHomePageHeader(String header) {
        assertThat("Verify create asset page:", homePage.getHomePageHeader(), equalTo(header));
    }

    public void enterCarRegistrationNumber(String carRegNumber) {
        homePage.enterCarRegNumber(carRegNumber);
    }

    public void clickFreeCheckButton(){
        homePage.clickFreeCarCheckButton();
    }

    public boolean isVehicleNotFound(){
        return homePage.isVehicleNotFoundMessageVisible();
    }
    public void tryAnotherVehicleCheck() {
            homePage.clickTryAgainButton();
    }
}
