package pages;

import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProcessesPage extends HomePage {

    private String PAGE_URL = new Config().getApplicationUrl() + "Projects";
    private String GENERIC_PROCESS_ROW_XPATH = "//td[text()='%s']/..";
    @FindBy(linkText = "Add new process")
    private WebElement addProcessBtn;

    public ProcessesPage(WebDriver driver) {
        super(driver);
    }

    public CreateProcessPage clickAddProcess() {
        addProcessBtn.click();

        return new CreateProcessPage(driver);
    }

    public ProcessesPage assertProcess(String expName, String expDescription, String expNotes) {
        String processXpath = String.format(GENERIC_PROCESS_ROW_XPATH, expName);

        WebElement processRow = driver.findElement(By.xpath(processXpath));

        String actDescription = processRow.findElement(By.xpath("./td[2]")).getText();
        String actNotes = processRow.findElement(By.xpath("./td[3]")).getText();

        Assert.assertEquals(actDescription, expDescription);
        Assert.assertEquals(actNotes, expNotes);

        return this;
    }

    public ProcessesPage assertProcessesPageLoaded() {
        String[] urlSplit = driver.getCurrentUrl().split("/");
        Assert.assertEquals(urlSplit[urlSplit.length - 1], "Projects");
        return this;
    }
}
