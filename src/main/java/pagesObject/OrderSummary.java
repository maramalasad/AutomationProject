package pagesObject;

import ActionDriver.Action;
import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummary extends BaseClass {

    Action action = new Action();

    public OrderSummary(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//span[contains(text(),'I confirm my order')]")
    WebElement confirmOrderBtn;

    public OrderConfirmationPage clickOnconfirmOrderBtn() throws Throwable {
        action.click(driver, confirmOrderBtn);
        return new OrderConfirmationPage();
    }
}
