package pagesObject;

import ActionDriver.Action;
import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage extends BaseClass {
    public AccountCreationPage() {
        PageFactory.initElements(driver, this);
    }
    Action action= new Action();

    @FindBy(xpath = "//h1[text()='Create an account']")
    WebElement formTitle;

    @FindBy(id = "uniform-id_gender1")
    WebElement mr;

    @FindBy(id = "id_gender2")
    WebElement mrs;

    @FindBy(name = "customer_firstname")
    WebElement firstName;

    @FindBy(name = "customer_lastname")
    WebElement lastName;

    @FindBy(xpath = "//*[@id='email']")
    WebElement email;

    @FindBy(name = "passwd")
    WebElement passWord;

    @FindBy(name = "days")
    WebElement days;

    @FindBy(name = "months")
    WebElement months;

    @FindBy(name = "years")
    WebElement years;

    @FindBy(name = "submitAccount")
    WebElement registerBtn;

    public void createAccount(String gender,String fName,
                              String lName,
                              String pswd,
                              String day,
                              String month,
                              String year,
                              String mail) throws Throwable {

        if(gender.equalsIgnoreCase("Mr")) {
            action.click(driver, mr);
        } else {
            action.click(driver, mrs);
        }

        action.type(firstName, fName);
        action.type(lastName, lName);
        action.type(email, mail );
        action.type(passWord, pswd);
        action.selectByValue(days, day);
        action.selectByValue(months, month);
        action.selectByValue(years, year);
    }

    public HomePage validateRegistration() throws Throwable {
        registerBtn.click();
        return new HomePage();
    }

    public boolean validateAcountCreatePage() throws Throwable {
        return action.isDisplayed(driver, formTitle);
    }
}
