package WebUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static Tests.BaseClass.driver;


public class WebActions {

    WebDriver driver;

    public WebActions(WebDriver driver) {
        this.driver = driver;
    }

    private void wait(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void click(WebElement element) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void select( WebElement element, String vValue) {
        Select select = new Select(element);
        try {
            wait(element);
            select.selectByVisibleText(vValue);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void enterValue(WebElement element, String vValue) {
        try {
            wait(element);
            element.clear();
            element.sendKeys(vValue);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
