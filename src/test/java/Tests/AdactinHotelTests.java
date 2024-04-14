package Tests;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static Report.ExtentReportManager.takeSnapShot;


public class AdactinHotelTests extends Base {


    @Test
    public void loginTest() {
        try {
            actions.enterValue(loginPage.usernameField, "BrandonChawane");
            actions.enterValue(loginPage.passwordField, "Brandon87");
            actions.click(loginPage.loginBtn);
            Assert.assertTrue(loginPage.usernameShow.isDisplayed());
            if (!loginPage.usernameShow.isDisplayed()) {
                takeSnapShot(driver, "Login_failed");
            }

        } catch (Exception e) {
            System.out.println("login test failed: " + e.getMessage());
        }

    }

    @Test(dependsOnMethods = "loginTest")
    public void searchHotelTest() {
        try {
            actions.select(homePage.location, "Sydney");
            actions.select(homePage.hotels,"Hotel Creek");
            actions.select(homePage.room_type,"Standard");
            actions.select(homePage.number_of_rooms,"2 - Two");
            actions.enterValue(homePage.check_in_date,"27/02/2024");
            actions.enterValue(homePage.check_out_date,"28/02/2024");
            actions.select(homePage.adult_rooms,"1 - One");
            actions.select(homePage.child_room,"1 - One");
            actions.click(homePage.submitBtn);
            Assert.assertTrue(homePage.hotelBanner.isDisplayed());
            if(!homePage.hotelBanner.isDisplayed()){
                System.out.println("search Hotel test failed");
                takeSnapShot(driver,"search_failed");
            }
        } catch (Exception e) {
            System.out.println("search Hotel test failed: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = "searchHotelTest")
    public void selectHotelTest() {
        try {
            actions.click(hotelPage.hotelRadioBtn);
            actions.click(hotelPage.continueBtn);
            Assert.assertTrue(hotelPage.bookHotel.isDisplayed());
            if(!hotelPage.bookHotel.isDisplayed()){
                takeSnapShot(driver, "select_hotel_failed");
            }
        } catch (Exception e) {
            System.out.println("Select Hotel test failed: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = "selectHotelTest")
    public void bookHotelTest() {
        try {
            actions.enterValue(bookHotelPage.first_name,"Brandon");
            actions.enterValue(bookHotelPage.last_name,"Chawane");
            actions.enterValue(bookHotelPage.billing_address,"17 Azania Ave, Maven Hill, Boon Stein, 1990");
            actions.enterValue(bookHotelPage.creditCardNum,"9829866713463529");
            actions.select(bookHotelPage.creditCardType,"VISA");
            actions.select(bookHotelPage.expiryMonth,"October");
            actions.select(bookHotelPage.expiryYear,"2025");
            actions.enterValue(bookHotelPage.ccvNumber,"321");
            actions.click(bookHotelPage.bookNowBtn);
            Assert.assertTrue(bookHotelPage.bookingConfirmation.isDisplayed());
            if(!bookHotelPage.bookingConfirmation.isDisplayed()){
                takeSnapShot(driver,"book_hotel_failed");
            }

        } catch (Exception e) {
            System.out.println("Book Hotel test failed: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = "bookHotelTest")
    public void logOut() {
        try {
            actions.click(bookHotelPage.logOut);
        } catch (Exception e) {
            System.out.println("Logout failed");
        }
    }

    @AfterClass
    public void tearDown() {
        try {
            driver.close();
            driver.quit();
        } catch (Exception e) {
            System.out.println("tear down failed: " + e.getMessage());
        }
    }
}
