package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends SeleniumPage {
    @FindBy(css = "a[href*=Register]")
    private WebElement registerLnk;
    @FindBy(id = "Email")
    private WebElement emailTxt;
    @FindBy(css = "#Password")
    private WebElement passwordTxt;
    @FindBy(css = "button[type=submit]")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage typeEmail(String email) {
        emailTxt.clear();
        emailTxt.sendKeys(email);

        return this;
    }

    public LoginPage typePassword(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);

        return this;
    }

    public HomePage submitLogin() {
        loginBtn.click();

        return new HomePage(driver);
    }

    public CreateAccountPage goToRegisterPage() {
        registerLnk.click();

        return new CreateAccountPage(driver);
    }
}