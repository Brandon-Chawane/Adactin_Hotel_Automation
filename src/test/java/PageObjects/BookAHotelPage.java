package PageObjects;

import WebUtilities.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookAHotelPage extends BasePage {
    WebActions wa = new WebActions(driver);

    public BookAHotelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement txtFirstName;
    @FindBy(xpath = "//input[@id='last_name']")
    private WebElement txtLastName;
    @FindBy(xpath = "//textarea[@id='address']")
    private WebElement txtAddress;
    @FindBy(xpath = "//input[@id='cc_num']")
    private WebElement txtCcNum;
    @FindBy(xpath = "//select[@id='cc_type']")
    private WebElement SelectCreditCardType;
    @FindBy(xpath = "//select[@id='cc_exp_month']")
    private WebElement SelectMonth;
    @FindBy(xpath = "//select[@id='cc_exp_year']")
    private WebElement SelectYear;
    @FindBy(xpath = "//input[@id='cc_cvv']")
    private WebElement txtCcCvv;
    @FindBy(xpath = "//input[@id='book_now']")
    private WebElement bookNowButton;
    @FindBy(xpath = "(//td[@colspan='2'][contains(.,'Book A Hotel')])[2]")
    private WebElement bookHotelValidation;

    public void setFirstName(String firstName){
        txtFirstName.clear();
        wa.enterValue(txtFirstName,firstName);
    }
    public void setLastName(String lastName){
        txtLastName.clear();
        wa.enterValue(txtLastName,lastName);
    }
    public void setAddress(String address){
        txtAddress.clear();
        wa.enterValue(txtAddress,address);
    }
    public void setCcNum(String creditCardNumber){
        txtCcNum.clear();
        wa.enterValue(txtCcNum,creditCardNumber);
    }
    public void setCreditCardType(String creditCardType){
        wa.select(SelectCreditCardType, creditCardType);
    }
    public void setExpiryMonth(String month){
        wa.select(SelectMonth, month);
    }
    public void setExpiryYear(String year){
        wa.select(SelectYear, year);
    }
    public void setCcVv(String ccVv){
        txtCcCvv.clear();
        wa.enterValue(txtCcCvv,ccVv);
    }
    public void clickBookNowButton(){
        wa.click(bookNowButton);
    }

    public boolean validateBookHotel(){
        try{
            return (bookHotelValidation.isDisplayed());
        }
        catch(Exception e){
            return  false;
        }
    }

}
