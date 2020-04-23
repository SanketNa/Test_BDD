package runners;


import com.cucumber.listener.Reporter;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        glue={"StepDefination"})

public class Test {

    @AfterClass
    public static void writeExtentReport()
    {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("User Name", "Sanket");
        Reporter.setSystemInfo("Application Name", "Test Flipkart flow ");
        Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
    }

}


