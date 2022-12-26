package testCases;

import Base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesObject.HomePage;
import pagesObject.IndexPage;
import pagesObject.LoginPage;

public class LoginPageTest extends BaseClass {
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
    public void loginTest() throws Throwable{
        indexPage = new IndexPage();
        loginPage = indexPage.clickOnSignIn();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        String actualURL = homePage.getCurrURL();
        String expectedURL = "http://automationpractice.pl/index.php?controller=my-account";
        Assert.assertEquals(actualURL, expectedURL);
    }
}
