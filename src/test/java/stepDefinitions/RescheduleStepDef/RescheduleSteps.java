package stepDefinitions.RescheduleStepDef;

import comun.BaseClass;
import contextManager.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.DriverManager;
import pageObjects.ReschedulePageObjects.ReschedulePage;

public class RescheduleSteps {
    TestContext testContext;
    ReschedulePage reschedulePage;

    public RescheduleSteps(TestContext testContext) {
        this.testContext = testContext;
        reschedulePage = testContext.getPageManager().getReschedulePage();
    }

    public RescheduleSteps() {
        this.testContext = new TestContext();
        this.reschedulePage = testContext.getPageManager().getReschedulePage();
    }

    @Given("I am on the meeting details page")
    public void I_am_on_the_meeting_details_page() {
        if (reschedulePage == null) {
            this.reschedulePage = testContext.getPageManager().getReschedulePage();
        }
        reschedulePage.goToURL();
        reschedulePage.validateThatIsInReschedulePage();
    }

    @When("I select a new meeting date")
    public void I_select_a_new_meeting_date(){
        reschedulePage.selectNewDateMeeting();
    }

    @And("I reschedule the meeting")
    public void I_reschedule_the_meeting(){
        reschedulePage.clickOnRescheduleMeeting();
    }
    @And("I confirm the new meeting")
    public void I_confirm_the_new_meeting(){
        reschedulePage.confirmTheNewMeeting();
    }
    @Then("I validate that the meeting is Successfully Rescheduled")
    public void I_validate_that_the_meeting_is_Successfully_Rescheduled(){
        reschedulePage.validateThatTheMeetingIsSuccessfullyRescheduled();
    }
}
