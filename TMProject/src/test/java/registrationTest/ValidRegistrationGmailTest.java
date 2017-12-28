package registrationTest;

import org.junit.Test;
import parrentTest.ParrentTest;

public class ValidRegistrationGmailTest extends ParrentTest{
    public ValidRegistrationGmailTest(String browser) {
        super(browser);
    }

    @Test
    public void validRegistrationGmail() throws InterruptedException {
        loginPage.openLoginPage();
        loginPage.checkTextOnPagePresent("PLEASE SIGN UP OR SIGN IN");
        loginPage.enterEmailToInput("anyaki.ryak@gmail.com");
        loginPage.clickContinueButton();
        loginPage.checkIsUseYourFacebookAccountButtonDisable();
        loginPage.checkIsEmailInputDisable();
        loginPage.moveToLoginLink();
        loginPage.enterPasswordToInput("Qwerty123");
        loginPage.selectSubscribeNewsletterCheckbox();
        loginPage.clickCreateAccountButton();
        loginPage.checkTextOnPagePresent("PLEASE CHECK YOUR EMAIL");
        loginPage.moveToAndClickGoToGmailButton();
        gmailPage.loginUserGmail();
        gmailPage.clickAppGoogleButton();
        gmailPage.clickGoogleMailButton();
        gmailPage.clickReceivedLetter();
        gmailPage.checkTextOnPagePresent("Registration at TemplateMonster");
        gmailPage.moveToAndClickConfirmEmailButton();
        gmailPage.waitForTMPageAndSwitchToIt();
        accountTMPage.checkTitle("TemplateMonster Registration");

        checkAC("Can not create gmail account", accountTMPage.checkTextOnPagePresent("AN ERROR OCCURRED"),true);
    }
}
