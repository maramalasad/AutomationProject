package pagesObject;

import ActionDriver.Action;
import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BaseClass {
    public SearchResultPage(){
        PageFactory.initElements(driver, this);
    }
    Action action =new Action();

    @FindBy(xpath="//*[@id= 'center_column']//img")
    WebElement productResult;

    public boolean isProductAvailable() throws Throwable {
        return action.isDisplayed(driver, productResult);
    }

    public AddToCartPage clickOnProduct() throws Throwable {
        action.click(driver, productResult);
        return new AddToCartPage();
    }
}
