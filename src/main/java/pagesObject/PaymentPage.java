package pagesObject;

import ActionDriver.Action;
import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BaseClass {
    Action action = new Action();

    public PaymentPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
    WebElement bankWireMethod;

    @FindBy(xpath = "//a[contains(text(),'Pay by check')]")
    WebElement payByCheckMethod;

    public OrderSummary clickOnPaymentMethod() throws Throwable {
        action.click(driver, bankWireMethod);
        return new OrderSummary();
    }
}
