package PageObjects;

import Report.ExtentReportManager;
import WebUtilities.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{



    public LoginPage(WebDriver driver) {
        super(driver);
    }
    WebActions wa = new WebActions(driver);
    @FindBy(xpath = "//input[contains(@id,'username')]")
    private WebElement txtUsername;

    @FindBy(xpath = "//input[contains(@id,'password')]")
    private WebElement txtPassword;

    @FindBy(xpath = "//input[contains(@id,'login')]")
    private WebElement loginBtn;


    @FindBy(xpath="//td[@class='login_title']")
    private WebElement usernameShow;


    public void setUsername(String username){
        txtUsername.clear();
        wa.enterValue(txtUsername,username);
    }
    public void setPassword(String password){
        txtPassword.clear();
        wa.enterValue(txtPassword,password);
    }
    public void clickLoginButton(){
        wa.click(loginBtn);
    }

    public boolean validateLogin(){
        try{
            return (usernameShow.isDisplayed());
        }
        catch (Exception e){
            return false;
        }
    }

}
