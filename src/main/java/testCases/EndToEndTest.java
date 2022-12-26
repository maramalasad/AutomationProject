package testCases;

import Base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesObject.*;

public class EndToEndTest extends BaseClass {
    private IndexPage indexPage;
    private SearchResultPage searchResultPage;
    private AddToCartPage addToCartPage;
    private OrderPage orderPage;
    private LoginPage loginPage;
    private AddressPage addressPage;
    private ShippingPage shippingPage;
    private PaymentPage paymentPage;
    private OrderSummary orderSummary;
    private OrderConfirmationPage orderConfirmationPage;


    @BeforeMethod
    public void setup(){
        launchApp();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void endToEndTest() throws Throwable {
        indexPage= new IndexPage();
        searchResultPage=indexPage.searchProduct("t-shirt");
        addToCartPage=searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity("2");
        addToCartPage.selectSize("M");
        addToCartPage.clickOnAddToCart();
        orderPage=addToCartPage.clickOnCheckOut();
        loginPage=orderPage.clickOnCheckOut();
        addressPage=loginPage.Login1(prop.getProperty("username"), prop.getProperty("password"));
        shippingPage=addressPage.clickOnCheckOut();
        shippingPage.checkTheTerms();
        paymentPage=shippingPage.clickOnProceedToCheckOut();
        orderSummary=paymentPage.clickOnPaymentMethod();
        orderConfirmationPage=orderSummary.clickOnconfirmOrderBtn();
        String actualMessage=orderConfirmationPage.validateConfirmMessage();
        String expectedMsg="Your order on My Store is complete.";
        Assert.assertEquals(actualMessage, expectedMsg);

    }
}
