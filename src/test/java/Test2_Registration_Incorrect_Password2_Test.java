import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.LoginPage;

import java.util.UUID;

public class Test2_Registration_Incorrect_Password2_Test extends SeleniumBaseTest {
    @Test
    public void correctUserRegistration() {
        String newUniqueEmail = UUID.randomUUID().toString().substring(0, 5) + "@test.com";
        String validPassword = "Ponio16#";
        String invalidPassword = "Ponio17#";

        LoginPage loginPage = new LoginPage(driver);
        CreateAccountPage createAccountPage = loginPage.goToRegisterPage()
                .typeEmail(newUniqueEmail)
                .typePassword(validPassword)
                .typeConfirmPassword(invalidPassword);
        createAccountPage.register();
        createAccountPage.assertPasswordsNotSameErrorIsShown();
    }
}
