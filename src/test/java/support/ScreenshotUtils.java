package support;

import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static runner.RunBase.getDriver;

public class ScreenshotUtils {

    public static void addScreenshootOnScenario(Scenario scenario) {

        byte[] screenshoot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshoot,"image/png");


    }
}