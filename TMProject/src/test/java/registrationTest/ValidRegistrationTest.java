package registrationTest;

import org.junit.Test;
import parrentTest.ParrentTest;


public class ValidRegistrationTest extends ParrentTest {

    public ValidRegistrationTest(String browser) {
        super(browser);
    }

    @Test
    public void validRegistration() throws InterruptedException {
        loginPage.openLoginPage();
        loginPage.checkTextOnPagePresent("PLEASE SIGN UP OR SIGN IN");
        loginPage.enterEmailToInput("super_testtm@ukr.net");
        loginPage.clickContinueButton();
        loginPage.checkIsUseYourFacebookAccountButtonDisable();
        loginPage.checkIsEmailInputDisable();
        loginPage.moveToLoginLink();
        loginPage.enterPasswordToInput("qwerty111");
        loginPage.selectSubscribeNewsletterCheckbox();
        loginPage.clickCreateAccountButton();
        loginPage.checkTextOnPagePresent("PLEASE CHECK YOUR EMAIL");
        loginPage.checkIsResendButtonPresent();

        checkAC("Can not create account", loginPage.checkTextOnPagePresent("super_testtm@ukr.net"),true);
    }
}

