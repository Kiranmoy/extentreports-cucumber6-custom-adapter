package cucumber.examples.java.calculator;

import com.kiran.extentreports.utils.ReportUtils;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.testng.annotations.BeforeClass;
import ch.qos.logback.classic.util.ContextInitializer;
@CucumberOptions(plugin = {"com.kiran.extentreports.cucumber.adapter.CustomExtentCucumberAdapter:"})
public class RunCukesTest extends AbstractTestNGCucumberTests {
    private static final Logger log
            = LoggerFactory.getLogger(RunCukesTest.class);
    @BeforeClass
    public void setup(){
        String logFolderPath = "test-output/logging/";
        MDC.put("scenarioName","automation-execution-start-up");
        System.setProperty(ContextInitializer.CONFIG_FILE_PROPERTY, "src/test/resources/com/kiran/adapter/logback.xml");
        System.setProperty("output.report.log.base.folder",logFolderPath);
        System.setProperty("extent.properties.base.path","com/kiran/adapter/extent.properties");
        ReportUtils.deleteExistingLogBeforeExecution();
        log.info("Deleting existing logs - ", logFolderPath);

    }

}
