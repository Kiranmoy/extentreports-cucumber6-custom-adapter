package cucumber.examples.java.calculator;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"com.kiran.extentreports.cucumber.adapter.CustomExtentCucumberAdapter:"})
public class RunCukesTest extends AbstractTestNGCucumberTests {

}
