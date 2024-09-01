package PageObjects;

import WebUtilities.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SelectAHotelPage extends BasePage {
    WebDriver driver;
    WebActions wa = new WebActions(driver);

    public SelectAHotelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//td[@class='login_title'][contains(.,'Select Hotel')]")
    private WebElement bookAHotelValidation;
    @FindBy(xpath = "//input[contains(@id,'radiobutton_0')]")
    private WebElement hotelRadioBtn;
    @FindBy(xpath = "//input[contains(@id,'continue')]")
    private WebElement continueBtn;

    public void clickRadioButton(){
        wa.click(hotelRadioBtn);
    }
    public void clickContinueButton(){
        wa.click(continueBtn);
    }
    public boolean selectHotelValidation(){
        try{
            return (bookAHotelValidation.isDisplayed());
        }
        catch(Exception e){
            return false;
        }
    }

}

