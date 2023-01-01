package Base;

import ActionDriver.Action;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public abstract class BaseClass {
    public static Properties prop;
    public static WebDriver driver;

    @BeforeTest
    public void loadConfig() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "\\Configuration\\config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void launchApp() {
        Action action = new Action();
        WebDriverManager.chromedriver().setup();
        String browserName = prop.getProperty("browser");

        if ((browserName.contains("Chrome"))){
            driver = new ChromeDriver();
        } else if (browserName.contains("FireFox")) {
            driver = new FirefoxDriver();
        }else if (browserName.contains("IE")){
            driver = new InternetExplorerDriver();
        }
        action.implicitWait(driver,10);
        action.pageLoadTimeOut(driver, 30);
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }

}
