package pagesObject;

import ActionDriver.Action;
import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BaseClass {

    public IndexPage() {
        PageFactory.initElements(driver, this);
    }
    Action action= new Action();

    @FindBy(name = "submit_search")
    WebElement searchButton;

    @FindBy(xpath = "//a[@class = 'login']")
    WebElement signInButton;

    @FindBy(xpath = "//img[@class='logo img-responsive']")
    WebElement myStoreLogo;

    @FindBy(id="search_query_top")
    private WebElement searchProductBox;

    public LoginPage clickOnSignIn() throws Throwable{
        action.click(driver,signInButton);
        return new LoginPage();
    }
    public boolean validateLogo() throws Throwable {
        return action.isDisplayed(driver, myStoreLogo);
    }
    public String getMyStoreTitle() {
        String myStoreTitel=driver.getTitle();
        return myStoreTitel;
    }
    public SearchResultPage searchProduct(String productName) throws Throwable {
        action.type(searchProductBox, productName);
        action.scrollByVisibilityOfElement(driver, searchButton);
        action.click(driver, searchButton);
        Thread.sleep(3000);
        return new SearchResultPage();
    }
}
