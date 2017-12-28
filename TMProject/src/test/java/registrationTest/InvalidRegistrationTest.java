package registrationTest;

import org.junit.Test;
import parrentTest.ParrentTest;

public class InvalidRegistrationTest extends ParrentTest{
    public InvalidRegistrationTest(String browser) {
        super(browser);
    }

    @Test
    public void invalidRegistration() throws InterruptedException {
        loginPage.openLoginPage();
        loginPage.checkTextOnPagePresent("PLEASE SIGN UP OR SIGN IN");
        loginPage.enterEmailToInput("qqq");
        loginPage.clickContinueButton();
        loginPage.checkIsIconAlertPresent();
        loginPage.checkTextOnPagePresent("Please specify a valid email");
        loginPage.enterEmailToInput("qqq@gmail.com");
        loginPage.clickContinueButton();
        loginPage.checkIsUseYourFacebookAccountButtonDisable();
        loginPage.checkIsEmailInputDisable();
        loginPage.moveToLoginLink();
        loginPage.clickCreateAccountButton();

        checkAC("Account was create", loginPage.checkTextOnPagePresent("Please enter your password"),true);
    }
}
