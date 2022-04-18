import org.testng.annotations.Test;
import pages.LoginPage;

public class Test6_Add_New_Process_Test extends SeleniumBaseTest {
    @Test
    public void correctUserRegistration() {
        String predefinedUserEmail = "test@test.com";
        String predefinedUserPassword = "Test1!";
        String processName = "processName";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeEmail(predefinedUserEmail)
                .typePassword(predefinedUserPassword)
                .submitLogin()
                .goToProcesses()
                .clickAddProcess()
                .typeName(processName)
                .submitCreate()
                .assertProcess(processName, "", "");
    }
}