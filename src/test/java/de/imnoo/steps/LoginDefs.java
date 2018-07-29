package de.imnoo.steps;

import cucumber.api.java8.En;
import de.imnoo.controls.driver.PageDriverController;
import de.imnoo.page.AdminCustomerPage;
import de.imnoo.page.DashboardPage;
import de.imnoo.page.LoginPage;
import de.imnoo.properties.EnvProperties;
import de.imnoo.properties.UserProperties;

public class LoginDefs implements En {

    private final EnvProperties envProperties = new EnvProperties();
    private final UserProperties userProperties = new UserProperties();

    public LoginDefs() {

        When("^User logs in into system$", () ->
        {
            PageDriverController.load(envProperties.getBaseUrl());
            new LoginPage().submitLogin(userProperties.getUserLogin(), userProperties.getUserPassword());
            new DashboardPage().verifyUserEmailLinkVisible();
        });

        When("^User navigates to ADMIN_CUSTOMER page$", () ->
        {
            PageDriverController.load(envProperties.getAdminCustomersPageUrl());
        });

        When("^User click 'Add new customer' on Administration/Customers Page$", () ->
        {
            new AdminCustomerPage().clickPlusButton();
        });

        Then("^Customers modal is visible on Administration Customers Page$", () ->
        {
            new AdminCustomerPage().verifyCustomerModalVisible();
        });

        Then("^Customers modal is not visible on Administration Customers Page$", () ->
        {
            new AdminCustomerPage().verifyCustomerModalIsNotVisible();
        });

        When("^User click 'Abort Create new Customer' on Administration/Customers Page$", () ->
        {
            new AdminCustomerPage().clickAbortCreateNewCustomerButton();
        });

        When("^User click '(\\d+)' page number on Administration/Customers Page$", (Integer pageNumber) ->
        {
            new AdminCustomerPage().clickPageNumber(pageNumber);
        });

        Then("^Page number '(\\d+)' is active on Administration/Customers Page$", (Integer pageNumber) ->
        {
          new AdminCustomerPage().verifyPageIsActive(pageNumber);
        });
    }
}
