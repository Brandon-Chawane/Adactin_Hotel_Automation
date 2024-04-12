package PageObjects;

import WebUtilities.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HotelPage {


    WebDriver driver;

    public HotelPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[contains(@id,'radiobutton_0')]")
    public WebElement hotelRadioBtn;

    @FindBy(xpath = "//input[contains(@id,'continue')]")
    public WebElement continueBtn;

    @FindBy(xpath = "(//td[@colspan='2'][contains(.,'Book A Hotel')])[2]")
    public WebElement bookHotel;


}

