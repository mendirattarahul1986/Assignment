package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/Users/Z002KR5/Downloads/TestAssignment/src/main/java/Features/SiteOpen.feature" // Where exactly your feature file is available
        ,glue = {"stepDefinations"} // path of the step defination file
        ,plugin = {"pretty","html:test-output"}  // to generate different type of reporting-- XML, json
        ,dryRun = true  // used for help us, which all definination is missed
        ,monochrome = true  //Display the console output in a proper readable mannner






)
public class TestRunner {


}
