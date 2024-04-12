package Tests;

import PageObjects.BookHotelPage;
import PageObjects.HomePage;
import PageObjects.HotelPage;
import PageObjects.LoginPage;
import WebUtilities.BrowserFactory;
import WebUtilities.WebActions;
import org.openqa.selenium.WebDriver;


public class Base {

    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver = browserFactory.startBrowser("edge","https://adactinhotelapp.com/");
    LoginPage loginPage = new LoginPage(driver);

    HomePage homePage = new HomePage(driver);

    HotelPage hotelPage = new HotelPage(driver);

    BookHotelPage bookHotelPage = new BookHotelPage(driver);

    WebActions actions = new WebActions(driver);

}
