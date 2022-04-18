import config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class SeleniumBaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void BaseBeforeMethod() {
        Config config = new Config();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mpotr\\dev\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        String test = config.getApplicationUrl();
        driver.get(config.getApplicationUrl());
    }

    @AfterMethod
    public void baseAfterMethod() {
        driver.quit();
    }


}
