package loginTest;

import org.junit.Test;
import parrentTest.ParrentTest;


public class ValidLogInTest extends ParrentTest {

    public ValidLogInTest(String browser) {
        super(browser);
    }

    @Test
    public void validLogIn() throws InterruptedException {
        loginPage.openLoginPage();
        loginPage.checkTextOnPagePresent("PLEASE SIGN UP OR SIGN IN");
        loginPage.enterEmailToInput("super_testtm@ukr.net");
        loginPage.clickContinueButton();
        loginPage.checkIsUseYourFacebookAccountButtonDisable();
        loginPage.checkIsEmailInputDisable();
        loginPage.enterPasswordToInput("qwerty111");
        loginPage.clickLoginButton();
        downloadsPage.waitForDownloadsTMPageLoad();

        checkAC("Logo is not present on TMPage", downloadsPage.isLogoPresent(), true);
    }
}

