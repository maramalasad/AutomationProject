package pagesObject;

import ActionDriver.Action;
import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    Action action= new Action();

    @FindBy(xpath = "//span[text()='Order history and details']")
    WebElement orderHistory;
    @FindBy(xpath = "//span[text() = 'My personal information']")
    WebElement myPersonalInfo;

    public boolean validateOrderHistory() throws Throwable {
        return action.isDisplayed(driver, orderHistory);
    }
    public boolean validateMyInformation() throws Throwable {
        return action.isDisplayed(driver, myPersonalInfo);
    }
    public String getCurrURL(){
        String homePageURL = driver.getCurrentUrl();
        return homePageURL;
    }


}
