package suites;

import loginTest.LoginUseFacebookAccountTest;
import loginTest.ValidLogInTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pages.ForgotPasswordPage;
import registrationTest.InvalidRegistrationTest;
import registrationTest.ValidRegistrationGmailTest;
import registrationTest.ValidRegistrationTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                ValidRegistrationTest.class,
                ValidLogInTest.class,
                LoginUseFacebookAccountTest.class,
                ValidRegistrationGmailTest.class,
                InvalidRegistrationTest.class,
                ForgotPasswordPage.class
        }
)
public class SuiteLoginPage {

}
