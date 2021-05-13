package stepDefinations;

import com.qa.pages.HomePage;
import com.qa.pages.ValidateTimer;
import com.qa.utils.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePageStepDefination extends TestBase {
HomePage homePage = new HomePage();
ValidateTimer validateTimer = new ValidateTimer();
int TimeInSeconds ;



    @Given("open the brower with URL")
    public void open_the_brower_with_url() {
        TestBase.initialzation();

    }

    @When("Maximize the browser Window")
    public void maximize_the_browser_window() {
        homePage.MaximizeBrowser();
    }

    @Then("Verify the page is loaded completely.")
    public void verify_the_page_is_loaded_completely() {
       homePage.ValidatePageCompletelyLoaded();
    }

    @Then("verify the title of the page.")
    public void verify_the_title_of_the_page() {
        String title = homePage.ValidatePageTitle();
        Assert.assertEquals("e.ggtimer - a simple countdown timer", title);

    }

    @Given("Page is already loaded")
    public void page_is_already_loaded() {
        homePage.ValidatePageCompletelyLoaded();
           }

        @When("check the box is editable")
    public void check_the_box_is_editable() {
           homePage.EditableBox();

    }

    @Then("Verify the box is editable")
    public void verify_the_box_is_editable() {
       Boolean isEditable = homePage.EditableBox();
        Assert.assertTrue(isEditable);
    }


    @When("Enter {int} in text box and click on Start")
    public void enter_in_text_box_and_click_on_start(Integer TimeInSeconds) {
        this.TimeInSeconds = TimeInSeconds;
        driver.findElement(By.id("EggTimer-start-time-input-text")).sendKeys(String.valueOf(TimeInSeconds));
        homePage.StartButton();

    }

    @Then("Verify the counter which is reducing by {int}")
    public void verify_the_counter_which_is_reducing_by(Integer TimeInSeconds) {
    int time = TimeInSeconds;
    validateTimer.CheckTimer(time);


    }

    @Given("Timer is already Over")
    public void timer_is_already_over() {

    }


    @Then("Verify the PopUp is coming and click on OK Button")
    public void verify_the_pop_up_is_coming_and_click_on_ok_button() throws InterruptedException {
        homePage.AcceptAlert();
    }



    @Then("Validate Time expired message")
    public void validate_time_expired_message() {
        Assert.assertEquals("Time Expired!",driver.findElement(By.cssSelector("span")).getText());
    }

    @Then("Close the browser")
    public void close_the_browser() {
        homePage.closeBrower();
    }









}

