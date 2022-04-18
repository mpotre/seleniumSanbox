package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CreateAccountPage extends SeleniumPage {

    @FindBy(css = "#Email")
    private WebElement emailTxt;
    @FindBy(css = "#Password")
    private WebElement passwordTxt;
    @FindBy(css = "#ConfirmPassword")
    private WebElement passwordTxt2;
    @FindBy(css = "#ConfirmPassword-error")
    private WebElement confirmPasswordError;
    @FindBy(css = ".validation-summary-errors > ul > li")
    private WebElement passwordError2;
    @FindBy(css = "button[type=submit]")
    private WebElement registerBtn;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public CreateAccountPage typeEmail(String email) {
        emailTxt.clear();
        emailTxt.sendKeys(email);
        return this;
    }

    public CreateAccountPage typePassword(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
        return this;
    }

    public DashboardPage register() {
        registerBtn.click();
        return new DashboardPage(driver);
    }

    public CreateAccountPage typeConfirmPassword(String validPassword) {
        passwordTxt2.clear();
        passwordTxt2.sendKeys(validPassword);
        return this;
    }

    public CreateAccountPage assertPasswordsNotSameErrorIsShown() {
        Assert.assertTrue(confirmPasswordError.isDisplayed());
        Assert.assertEquals(confirmPasswordError.getText(), "The password and confirmation password do not match.");
        return this;
    }

    public CreateAccountPage assertInvalidPassword(String expErrorMessage) {
        Assert.assertTrue(passwordError2.isDisplayed());
        Assert.assertEquals(passwordError2.getText(), expErrorMessage);
        return this;
    }
}