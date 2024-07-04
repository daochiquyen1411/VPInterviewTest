package tests.loginPage;

import org.testng.annotations.Test;
import pages.web.LoginPage;
import tests.common.BaseTest;

public class LoginPageTest extends BaseTest {

    @Test
    public void interviewTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login()
                .clickOnMenuPIM()
                .addEmployee("Quyen", "Chi", "Dao")
                .searchEmployeeByJobTitle("Automaton Tester");
        Thread.sleep(5000);
    }
}
