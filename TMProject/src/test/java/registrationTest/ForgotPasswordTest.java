package registrationTest;

import org.junit.Test;
import parrentTest.ParrentTest;

public class ForgotPasswordTest extends ParrentTest{
    public ForgotPasswordTest(String browser) {
        super(browser);
    }

    @Test
    public void forgotPassword() throws InterruptedException {
        loginPage.openLoginPage();
        loginPage.checkTextOnPagePresent("PLEASE SIGN UP OR SIGN IN");
        loginPage.moveToAndClickForgotPasswordLink();
        forgotPasswordPage.checkTextOnPagePresent("PASSWORD RECOVERY");
        forgotPasswordPage.clickSendConfirmationButtton();
        forgotPasswordPage.checkTextOnPagePresent("Please enter Your email");
        forgotPasswordPage.enterEmailToInput("super_testtm@ukr.net");
        forgotPasswordPage.clickSendConfirmationButtton();
        forgotPasswordPage.checkResendButtonPresent();

        checkAC("Can not send email", forgotPasswordPage.checkTextOnPagePresent("PLEASE CHECK YOUR EMAIL"),true);
    }
}
