package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DashboardPage extends HomePage {

    @FindBy(xpath = "//h2[text()='DEMO PROJECT']")
    private WebElement demoProjectHeader;
    @FindBy(linkText = "Create your first process")
    private WebElement createFirstProjectBtn;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public DashboardPage assertDemoProjectIsShown() {
        Assert.assertTrue(isElementPresent(demoProjectHeader) || isElementPresent(createFirstProjectBtn));

        return this;
    }
}
