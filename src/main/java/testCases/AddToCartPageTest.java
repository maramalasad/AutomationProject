package testCases;

import Base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesObject.AddToCartPage;
import pagesObject.IndexPage;
import pagesObject.SearchResultPage;

public class AddToCartPageTest extends BaseClass {
    private IndexPage indexPage;
    private SearchResultPage searchResultPage;
    private AddToCartPage addToCartPage;

    @BeforeMethod
    public void setup(){
        launchApp();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void addToCartTest() throws Throwable {
        indexPage= new IndexPage();
        searchResultPage=indexPage.searchProduct("t-shirt");
        addToCartPage=searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity("2");
        addToCartPage.selectSize("M");
        addToCartPage.clickOnAddToCart();
        boolean result=addToCartPage.validateAddtoCart();
        Assert.assertTrue(result);
    }
}
