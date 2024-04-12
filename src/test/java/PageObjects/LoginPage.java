package PageObjects;

import Report.ExtentReportManager;
import WebUtilities.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    WebActions actions = new WebActions(driver);
    @FindBy(xpath = "//input[contains(@id,'username')]")
     public  WebElement usernameField;

    @FindBy(xpath = "//input[contains(@id,'password')]")
   public  WebElement passwordField;

    @FindBy(xpath = "//input[contains(@id,'login')]")
    public WebElement loginBtn;

    @FindBy(xpath = "//img[@src='img/AdactIn_logo.png']")
    public WebElement usernameShow;


    public  void clickButton(){
       
    }





    @FindBy(xpath = "//input[contains(@id,'signInName')]")
    public WebElement emailAddress;

    @FindBy(xpath = "//input[contains(@id,'password')]")
    public WebElement password;

    @FindBy(xpath = "//button[contains(@id,'next')]")
    public WebElement nextBtn;

    @FindBy(xpath = "//h1[contains(.,'Welcome to Weeva 360')]")
    public WebElement loginPageValidation;

    @FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(.,'Explore the parameters')]")
    public WebElement exploreParametersBtn;

    @FindBy(xpath = "//h2[@class='ms-2 mt-50 text-white mb-0'][contains(.,'Welcome back New prop Dnesia')]")
    public  WebElement welcomeBanner;

    @FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(.,'Remind me later')]")
    public  WebElement remindMeLater;

}
