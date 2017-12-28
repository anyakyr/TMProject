package loginTest;

import org.junit.Test;
import parrentTest.ParrentTest;

public class LoginUseFacebookAccountTest extends ParrentTest{
    public LoginUseFacebookAccountTest(String browser) {
        super(browser);
    }

    @Test
    public void loginUseFacebookAccount() throws InterruptedException {
        loginPage.openLoginPage();
        loginPage.checkTextOnPagePresent("PLEASE SIGN UP OR SIGN IN");
        loginPage.clickUseYourFacebookAccountButton();
        facebookPage.getWindowLoginToFacebook();
        facebookPage.loginUserFacebook();
        downloadsPage.isLogoPresent();

        checkAC("Text 'TMonster TMonster' is not present on TMPage", downloadsPage.checkTextOnPagePresent("TMonster TMonster"), true);
    }
}
