package testCases;

import Base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesObject.IndexPage;

public class IndexPageTest extends BaseClass {
    IndexPage indexPage;
    @BeforeMethod
    public void setup(){
        launchApp();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void verifyLogo()throws Throwable{
        indexPage = new IndexPage();
        boolean result = indexPage.validateLogo();
        Assert.assertTrue(result);
    }
    @Test
    public void verifyTitle(){
        indexPage = new IndexPage();
        String actTitle = indexPage.getMyStoreTitle();
        Assert.assertEquals(actTitle, "My Store");
    }
}
