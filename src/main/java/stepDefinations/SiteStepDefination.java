package stepDefinations;

import com.qa.utils.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SiteStepDefination extends TestBase {


    @Given("open the brower with URL")
    public void open_the_brower_with_url() {
        TestBase.initialzation();

    }

    @When("Maximize the browser Window")
    public void maximize_the_browser_window() {
        driver.manage().window().maximize();

    }

    @Then("Verify the page is loaded completely.")
    public void verify_the_page_is_loaded_completely() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#EggTimer-start-time-input-text")));
    }

    @Then("verify the title of the page.")
    public void verify_the_title_of_the_page() {
        Assert.assertEquals("e.ggtimer - a simple countdown timer", driver.getTitle());

    }

    @Given("Page is already loaded")
    public void page_is_already_loaded() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#EggTimer-start-time-input-text")));
    }

        @When("check the box is editable")
    public void check_the_box_is_editable() {
            WebElement element = driver.findElement(By.cssSelector("#EggTimer-start-time-input-text"));
           Boolean isEditable = element.isEnabled();

    }

    @Then("Verify the box is editable")
    public void verify_the_box_is_editable() {
        WebElement element = driver.findElement(By.cssSelector("#EggTimer-start-time-input-text"));
        Boolean isEditable = element.isEnabled();
        Assert.assertTrue(isEditable);
    }




}

