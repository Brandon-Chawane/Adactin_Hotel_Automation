package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ExtentReportManager {

    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;


    public static ExtentReports InitReports() throws IOException {


        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/report.html");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setReportName("Adactin Report");

        extent = new ExtentReports();
        extent.getStats();
        extent.attachReporter(sparkReporter);

        return extent;

    }

    private static String ScreenshotDir = System.getProperty("user.dir") + "/Screenshots";

    public static void takeSnapShot(WebDriver driver, String screenshotName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File(ScreenshotDir, screenshotName + ".png");

        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
