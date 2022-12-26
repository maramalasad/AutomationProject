package testCases;

import Base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesObject.HomePage;
import pagesObject.IndexPage;
import pagesObject.LoginPage;

public class HomePageTest  extends BaseClass {
    IndexPage indexPage;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setup(){
        launchApp();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void personalInfoListTest() throws Throwable {
        indexPage = new IndexPage();
        loginPage = indexPage.clickOnSignIn();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        boolean result = homePage.validateMyInformation();
        Assert.assertTrue(result);

    }
    @Test
    public void orderHistoryDetailsTest() throws Throwable {
        indexPage = new IndexPage();
        loginPage = indexPage.clickOnSignIn();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        boolean result = homePage.validateOrderHistory();
        Assert.assertTrue(result);
    }
}
