package pagesObject;

import ActionDriver.Action;
import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends BaseClass {
    Action action= new Action();
    public ShippingPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="cgv")
    WebElement terms;

    @FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckOutBtn;

    public void checkTheTerms() throws Throwable {
        action.click(driver, terms);
    }

    public PaymentPage clickOnProceedToCheckOut() throws Throwable {
        action.click(driver, proceedToCheckOutBtn);
        return new PaymentPage();
    }

}
