package Tests;


import PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Report.ExtentReportManager.takeSnapShot;


public class AdactinHotelTests extends BaseClass {


    @Test
    public void loginTest() {
        logger.info("***Tests started***");
        LoginPage lp = new LoginPage(driver);
        try {
            lp.setUsername(p.getProperty("username"));
            lp.setPassword(p.getProperty("password"));
            lp.clickLoginButton();
            boolean loggedInSuccess = lp.validateLogin();
            Assert.assertTrue(loggedInSuccess);
        } catch (Exception e) {
            Assert.fail();
            logger.error("*loginTest failed*");
            takeSnapShot(driver, "loginTest failed");
        }

    }

    @Test(dependsOnMethods = "loginTest")
    public void searchHotelTest() {
        SearchHotelPage hp = new SearchHotelPage(driver);
        try {
            hp.setLocation(p.getProperty("location"));
            hp.setHotel(p.getProperty("hotels"));
            hp.setRoomType(p.getProperty("room_type"));
            hp.setNumberOfRooms(p.getProperty("number_of_rooms"));
            hp.setCheckInDate(p.getProperty("check_in_date"));
            hp.setCheckOutDate(p.getProperty("check_out_date"));
            hp.setAdultPerRoom(p.getProperty("adult_rooms"));
            hp.setChildrenPerRoom(p.getProperty("child_room"));
            hp.clickSubmitButton();
            boolean validateSearchPage = hp.validateSearchHotel();
            Assert.assertTrue(validateSearchPage);
        } catch (Exception e) {
            Assert.fail();
            logger.error("*searchHotelTest failed*");
            takeSnapShot(driver, "searchHotelTest failed");
        }
    }

    @Test(dependsOnMethods = "searchHotelTest")
    public void selectAHotelTest() {
        SelectAHotelPage shp = new SelectAHotelPage(driver);
        try {
            boolean hotelSelectedValidation = shp.selectHotelValidation();
            Assert.assertTrue(hotelSelectedValidation);
            shp.clickRadioButton();
            shp.clickContinueButton();
        } catch (Exception e) {
            Assert.fail();
            logger.error("Select Hotel Test Failed");
            takeSnapShot(driver, ("*selectHotelTest failed*"));
        }
    }

    @Test(dependsOnMethods = "selectAHotelTest")
    public void bookAHotelTest() {
        BookAHotelPage bh = new BookAHotelPage(driver);
        try {
            bh.setFirstName(p.getProperty("first_name"));
            bh.setLastName(p.getProperty("last_name"));
            bh.setAddress(p.getProperty("billing_address"));
            bh.setCcNum(p.getProperty("creditCardNum"));
            bh.setCreditCardType(p.getProperty("creditCardType"));
            bh.setExpiryMonth(p.getProperty("expiryMonth"));
            bh.setExpiryYear(p.getProperty("expiryYear"));
            bh.setCcVv(p.getProperty("ccvNumber"));
            boolean validation = bh.validateBookHotel();
            Assert.assertTrue(validation);
            bh.clickBookNowButton();
        } catch (Exception e) {
            Assert.fail();
            logger.error("*book hotel test failed*");
            takeSnapShot(driver, "bookHotelTest failed");
        }

    }

    @Test(dependsOnMethods = "bookAHotelTest")
    public void bookingConfirmationTest() {
        BookingConfirmationPage bcp = new BookingConfirmationPage(driver);
        try {
                boolean confirmation = bcp.bookingConfirmed();
                Assert.assertTrue(confirmation);
                bcp.clickLogOutButton();

        } catch (Exception e) {
            Assert.fail();
            logger.error("*booking confirmation test failed*");
            takeSnapShot(driver, "bookingConfirmationTest failed");
        }
        logger.info("***Tests ended***");
    }



}



