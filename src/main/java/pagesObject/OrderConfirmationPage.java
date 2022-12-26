package pagesObject;

import ActionDriver.Action;
import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends BaseClass {
    Action action = new Action();

    public OrderConfirmationPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"center_column\"]/p[text() = 'Your order on My Store is complete.']")
    WebElement confirmMessag;

    public String validateConfirmMessage() {
        String confirmMsg=confirmMessag.getText();
        return confirmMsg;
    }
}
