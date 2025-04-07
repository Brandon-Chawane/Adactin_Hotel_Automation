package PageObjects;

import WebUtilities.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingConfirmationPage extends BasePage{
    WebActions wa = new WebActions(driver);
    public BookingConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//td[@class='login_title']")  private WebElement bookingConfirmation;

    @FindBy(id="logout")  private WebElement logout;



    public boolean bookingConfirmed(){
        try{
            return (bookingConfirmation.isDisplayed());
        }
        catch (Exception e){
            return false;
        }
    }
    public void clickLogOutButton(){
        wa.click(logout);
    }

}
