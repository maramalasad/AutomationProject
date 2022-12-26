package testCases;

import Base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesObject.AccountCreationPage;
import pagesObject.HomePage;
import pagesObject.IndexPage;
import pagesObject.LoginPage;

public class AccountCreationPageTest extends BaseClass {
    IndexPage indexPage;
    LoginPage loginPage;
    AccountCreationPage accountCreationPage;

    @BeforeMethod
    public void setup(){
        launchApp();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void verifyCreateAccountPageTest() throws Throwable{
        indexPage = new IndexPage();
        loginPage = indexPage.clickOnSignIn();
        accountCreationPage = loginPage.createNewAccount("dema@gmail.com");
        boolean result = accountCreationPage.validateAcountCreatePage();
        Assert.assertTrue(result);
    }
}
