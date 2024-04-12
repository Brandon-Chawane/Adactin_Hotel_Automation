package PageObjects;

import WebUtilities.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    WebActions actions = new WebActions(driver);
    @FindBy(id="location")
    public WebElement location;

    @FindBy(id="hotels")
    public WebElement hotels;

    @FindBy(id="room_type")
    public WebElement room_type;

    @FindBy(id="room_nos")
    public WebElement number_of_rooms;

    @FindBy(id="datepick_in")
    public WebElement check_in_date;

    @FindBy(id="datepick_out")
    public WebElement check_out_date;

    @FindBy(id="adult_room")
    public WebElement adult_rooms;

    @FindBy(id="child_room")
    public WebElement child_room;

    @FindBy(id="Submit")
    public WebElement submitBtn;

    @FindBy(xpath = "//td[@valign='top'][contains(.,'Welcome to Adactin Group of Hotels')]")
    public WebElement hotelBanner;


    public void searchHotel(){

    }
    public void click(){

    }
}
