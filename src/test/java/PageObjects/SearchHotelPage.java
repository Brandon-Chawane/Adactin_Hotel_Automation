package PageObjects;

import WebUtilities.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchHotelPage extends BasePage {


    WebActions wa = new WebActions(driver);

    public SearchHotelPage(WebDriver driver) {
        super(driver);
    }


    @FindBy( id="location")
    private WebElement txtLocation;
    @FindBy(id= "hotels")
    private WebElement txtHotels;
    @FindBy(id= "room_type")
    private WebElement SelectRoomType;
    @FindBy(id= "room_nos")
    private WebElement txtSelectNumberOfRooms;
    @FindBy(id="datepick_in")
    private WebElement datepickIn;
    @FindBy(id="datepick_out")
    private WebElement datepickOut;
    @FindBy(id="adult_room")
    private WebElement SelectAdultsPerRoom;
    @FindBy(id="child_room")
    private WebElement SelectChildrenRoom;
    @FindBy(id="Submit")
    private WebElement submit;
    @FindBy(xpath = "//td[@valign='top'][contains(.,'Welcome to Adactin Group of Hotels')]")
    private WebElement hotelValidationBanner;

    public void setLocation(String location) {
        wa.select(txtLocation, location);
    }

    public void setHotel(String hotel) {
        wa.select(txtHotels, hotel);
    }
    public void setRoomType(String roomType) {
        wa.select(SelectRoomType, roomType);
    }

    public void setNumberOfRooms(String numberOfRooms) {
        wa.select(txtSelectNumberOfRooms, numberOfRooms);
    }
    public void setCheckInDate(String checkInDate) {
        datepickIn.clear();
        wa.enterValue(datepickIn, checkInDate);
    }

    public void setCheckOutDate(String checkOutDate) {
        datepickOut.clear();
        wa.enterValue(datepickOut, checkOutDate);
    }

    public void setAdultPerRoom(String adultsPerRoom) {
        wa.select(SelectAdultsPerRoom, adultsPerRoom);
    }

    public void setChildrenPerRoom(String childrenPerRoom) {
        wa.select(SelectChildrenRoom, childrenPerRoom);
    }

    public void clickSubmitButton() {
        wa.click(submit);
    }

    public boolean validateSearchHotel() {
        try {
            return (hotelValidationBanner.isDisplayed());
        } catch (Exception e) {
            return false;
        }
    }

}
