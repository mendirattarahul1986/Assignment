package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/Features" // Where exactly your feature file is available
        ,glue = {"stepDefinations"} ,// path of the step defination file
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/"}

        ,dryRun = false
        ,monochrome = true






)
public class TestRunner {


}
