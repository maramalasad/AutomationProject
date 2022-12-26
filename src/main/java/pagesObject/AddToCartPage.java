package pagesObject;

import ActionDriver.Action;
import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends BaseClass {
    Action action = new Action();

    public AddToCartPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="quantity_wanted")
    WebElement quantity;

    @FindBy(name="group_1")
    WebElement size;

    @FindBy(xpath = "//button/span[text()= 'Add to cart']")
    WebElement addToCartBtn;

    @FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckOutBtn;

    @FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[1]/h2/i")
    WebElement addToCartMessag;

    public void enterQuantity(String quantity1) throws Throwable {
        action.type(quantity, quantity1);
    }

    public void selectSize(String size1) throws Throwable {
        action.selectByVisibleText(size1, size);
    }

    public void clickOnAddToCart() throws Throwable {
        action.click(driver, addToCartBtn);
    }

    public boolean validateAddtoCart() throws Throwable {
        action.fluentWait(driver, addToCartMessag, 10);
        return action.isDisplayed(driver, addToCartMessag);
    }

    public OrderPage clickOnCheckOut() throws Throwable {
        action.fluentWait(driver, proceedToCheckOutBtn, 10);
        action.JSClick(driver, proceedToCheckOutBtn);
        return new OrderPage();
    }
}
