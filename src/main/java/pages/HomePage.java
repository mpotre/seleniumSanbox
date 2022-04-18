package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends SeleniumPage {

    @FindBy(css = ".profile_info>h2")
    public WebElement welcomeElm;
    @FindBy(css = ".menu-workspace")
    private WebElement workspaceNav;
    @FindBy(css = "a[href$=Projects]")
    private WebElement processesMenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private boolean isParentExpanded(WebElement menuLink) {
        WebElement parent = menuLink.findElement(By.xpath("./.."));

        return parent.getAttribute("class").contains("active");
    }

    public ProcessesPage goToProcesses() {
        if (!isParentExpanded(workspaceNav))
            workspaceNav.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(processesMenu));

        processesMenu.click();

        return new ProcessesPage(driver);
    }

    public HomePage assertWelcomeElementIsShown() {
        Assert.assertTrue(welcomeElm.isDisplayed(), "Welcome element is not shown.");
        Assert.assertTrue(welcomeElm.getText().contains("Welcome"), "Welcome element text: '" + welcomeElm.getText() + "' does not contain word 'Welcome'");

        return this;
    }

}

