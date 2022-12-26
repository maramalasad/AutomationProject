package pagesObject;

import ActionDriver.Action;
import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends BaseClass {

    Action action = new Action();

    public AddressPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//span[text()='Proceed to checkout']")
    private WebElement proceedToCheckOut;

    public ShippingPage clickOnCheckOut() throws Throwable {
        action.click(driver, proceedToCheckOut);
        return new ShippingPage();
    }

}
