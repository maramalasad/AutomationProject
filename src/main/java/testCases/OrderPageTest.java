package testCases;

import Base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesObject.AddToCartPage;
import pagesObject.IndexPage;
import pagesObject.OrderPage;
import pagesObject.SearchResultPage;

public class OrderPageTest extends BaseClass {
    private IndexPage indexPage;
    private SearchResultPage searchResultPage;
    private AddToCartPage addToCartPage;
    private OrderPage orderPage;
    @BeforeMethod
    public void setup(){
        launchApp();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void verifyTotalPrice() throws Throwable {
        indexPage= new IndexPage();
        searchResultPage=indexPage.searchProduct("t-shirt");
        addToCartPage=searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity("2");
        addToCartPage.selectSize("M");
        addToCartPage.clickOnAddToCart();
        orderPage=addToCartPage.clickOnCheckOut();
        Double unitPrice=orderPage.getUnitPrice();
        Double totalPrice=orderPage.getTotalPrice();
        Double totalExpectedPrice=(unitPrice*2)+7;
        Assert.assertEquals(totalPrice, totalExpectedPrice);
    }
}
