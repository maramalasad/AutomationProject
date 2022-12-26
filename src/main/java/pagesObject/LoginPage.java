package pagesObject;

import ActionDriver.Action;
import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    Action action = new Action();
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    WebElement userName;

    @FindBy(id = "passwd")
    WebElement passWord;

    @FindBy(id="SubmitLogin")
    WebElement signInBtn;

    @FindBy(id = "email_create")
    WebElement emailForNewAccount;

    @FindBy(name = "SubmitCreate")
    WebElement createNewAccountButton;


    public HomePage login(String uname, String pswd) throws Throwable {
        action.type(userName, uname);
        action.type(passWord, pswd);
        action.click(driver, signInBtn);
        return new HomePage();
    }
    public AddressDetails login(String uname, String pswd,AddressDetails details) throws Throwable {
        action.scrollByVisibilityOfElement(driver, userName);
        action.type(userName, uname);
        action.type(passWord, pswd);
        action.click(driver, signInBtn);
        Thread.sleep(2000);
       details=new AddressDetails();
        return details;
    }

    public AddressPage Login1(String uname, String pswd)throws Throwable{
        action.type(userName, uname);
        action.type(passWord, pswd);
        action.click(driver,signInBtn);
        return new AddressPage();
    }

    public AccountCreationPage createNewAccount(String newEmail) throws Throwable {
        action.type(emailForNewAccount, newEmail);
        action.click(driver, createNewAccountButton);
        return new AccountCreationPage();
    }
}
