import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.UUID;

public class Test1_Correct_User_Registration_Test extends SeleniumBaseTest {
    @Test
    public void correctUserRegistration() {
        String newUniqueEmail = UUID.randomUUID().toString().substring(0, 5) + "@test.com";
        String validPassword = "Ponio16#";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToRegisterPage()
                .typeEmail(newUniqueEmail)
                .typePassword(validPassword)
                .typeConfirmPassword(validPassword)
                .register()
                .assertDemoProjectIsShown();
    }
}