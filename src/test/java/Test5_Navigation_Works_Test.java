import org.testng.annotations.Test;
import pages.LoginPage;

public class Test5_Navigation_Works_Test extends SeleniumBaseTest {
    @Test
    public void correctUserRegistration() {
        String predefinedUserEmail = "test@test.com";
        String predefinedUserPassword = "Test1!";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeEmail(predefinedUserEmail)
                .typePassword(predefinedUserPassword)
                .submitLogin()
                .goToProcesses()
                .assertProcessesPageLoaded();
    }
}
