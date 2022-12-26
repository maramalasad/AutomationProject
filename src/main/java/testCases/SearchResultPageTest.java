package testCases;

import Base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesObject.IndexPage;
import pagesObject.SearchResultPage;

public class SearchResultPageTest extends BaseClass {
    IndexPage indexPage;
    SearchResultPage searchResultPage;
    @BeforeMethod
    public void setup(){
        launchApp();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void productAvailabilityTest()throws Throwable{
        indexPage= new IndexPage();
        searchResultPage=indexPage.searchProduct("t-shirt");
        boolean result=searchResultPage.isProductAvailable();
        Assert.assertTrue(result);
    }
}
