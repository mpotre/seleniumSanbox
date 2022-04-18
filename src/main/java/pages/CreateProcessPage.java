package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateProcessPage extends HomePage {

    @FindBy(id = "Name")
    private WebElement nameTxt;
    @FindBy(css = "input[type=submit]")
    private WebElement createBtn;

    public CreateProcessPage(WebDriver driver) {
        super(driver);
    }

    public CreateProcessPage typeName(String processName) {
        nameTxt.clear();
        nameTxt.sendKeys(processName);

        return this;
    }

    public ProcessesPage submitCreate() {
        createBtn.click();

        return new ProcessesPage(driver);
    }
}
