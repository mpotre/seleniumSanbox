import org.testng.annotations.Test;
import pages.LoginPage;

public class Test4_Correct_Login_Test extends SeleniumBaseTest {
    @Test
    public void correctUserRegistration() {

        new LoginPage(driver)
                .typeEmail("test@test.com")
                .typePassword("Test1!")
                .submitLogin()
                .assertWelcomeElementIsShown();
    }
}
