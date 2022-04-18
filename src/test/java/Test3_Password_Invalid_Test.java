import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.LoginPage;

import java.util.UUID;

public class Test3_Password_Invalid_Test extends SeleniumBaseTest {

    @DataProvider
    public static Object[][] wrongPasswords() {
        return new Object[][]{
                {"test", "The Password must be at least 6 and at max 100 characters long."},
                {"Tests!", "Passwords must have at least one digit ('0'-'9')."},
                {"test1!", "Passwords must have at least one uppercase ('A'-'Z')."}
        };
    }

    @Test(dataProvider = "wrongPasswords")
    public void test(String password, String expErrorMessage) {
        String newUniqueEmail = UUID.randomUUID().toString().substring(0, 5) + "@test.com";

        LoginPage loginPage = new LoginPage(driver);
        CreateAccountPage createAccountPage = loginPage.goToRegisterPage()
                .typeEmail(newUniqueEmail)
                .typePassword(password)
                .typeConfirmPassword(password);
        createAccountPage.register();
        createAccountPage.assertInvalidPassword(expErrorMessage);
    }
}
