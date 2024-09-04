package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public Properties p;
    public Logger logger;

    @BeforeClass
    @Parameters({"browser","os"})
    public void setup(String browserChoice, String os) throws IOException {

        FileReader file = new FileReader("./src//main//resources//config.properties");
        logger = LogManager.getLogger(this.getClass());
        p = new Properties();
        p.load(file);

        if(p.getProperty("execution_env").equalsIgnoreCase("remote")){
            DesiredCapabilities c = new DesiredCapabilities();

            //os

            switch (os.toLowerCase()){
                case "windows":
                    c.setPlatform(Platform.WIN11);
                    break;
                case "mac":
                    c.setPlatform(Platform.MAC);
                    break;
                default:
                    System.out.println("Not a valid selection");
                    return;

            }


            //browser

            switch (browserChoice.toLowerCase()){
                case "chrome":
                    c.setBrowserName("chrome");
                    break;
                case "edge":
                    c.setBrowserName("MicrosoftEdge");
                    break;
                default:
                    System.out.println("Not a valid browser");
                    return;
            }
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),c);
        }



        else if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
            switch (browserChoice.toLowerCase()) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless=new");
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--headless=new");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--headless=new");
                    driver = new EdgeDriver();
                    break;

                default:
                    System.out.println("Not a valid browser");
                    return;

            }
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("AppUrl"));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
