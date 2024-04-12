package PageObjects;

import WebUtilities.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotelPage {

    WebDriver driver;

    public BookHotelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    @FindBy(xpath = "//input[contains(@id,'first_name')]")
    public WebElement first_name;

    @FindBy(xpath = "//input[contains(@id,'last_name')]")
    public WebElement last_name;

    @FindBy(xpath = "//textarea[contains(@id,'address')]")
    public WebElement billing_address;

    @FindBy(xpath = "//input[contains(@id,'cc_num')]")
    public WebElement creditCardNum;

    @FindBy(xpath = "//select[contains(@id,'cc_type')]")
    public WebElement creditCardType;

    @FindBy(xpath = "//select[contains(@id,'cc_exp_month')]")
    public WebElement expiryMonth;

    @FindBy(xpath = "//select[contains(@id,'cc_exp_year')]")
    public WebElement expiryYear;

    @FindBy(xpath = "//input[contains(@id,'cc_cvv')]")
    public WebElement ccvNumber;

    @FindBy(xpath = "//input[contains(@id,'book_now')]")
    public WebElement bookNowBtn;

    @FindBy(xpath = "//td[contains(@class,'login_title')]")
    public WebElement bookingConfirmation;

    @FindBy(xpath = "//input[contains(@id,'logout')]")
    public WebElement logOut;


}
