package com.quinbay.qa.task.step;

import com.quinbay.qa.task.pages.BasePage;
import com.quinbay.qa.task.pages.taskPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class task {
    public taskPage taskActions;
     {
        taskActions=new taskPage(BasePage.driver);

    }
    @Given("MicroService Version")
    public void micro_service_version() {

    }

    @When("Enter environment name as {string}")
    public void enter_environment_name_as(String string) {
        taskActions.getEnvironment(string);
    }

    @Then("app name displayed")
    public void app_name_displayed() throws IOException {
        taskActions.getName();
    }

    @When("user gives the environments as {string} and {string}")
    public void user_gives_the_environments_as_and(String string, String string2) {
        taskActions.setEnvironments(string,string2);
    }

    @Then("find the app name having a mismatch of versions between the given environments")
    public void find_the_app_name_having_a_mismatch_of_versions_between_the_given_environments() throws IOException {
        taskActions.check();
    }


}
