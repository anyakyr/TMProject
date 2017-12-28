package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends ParentPage{

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//span[@id='id-send-confirmation-link']/button")
    private WebElement sendConfirmationButtton;

    @FindBy(xpath = "//span[@id='id-login-or-signup-link']/a")
    private WebElement logInLink;

    @FindBy(xpath = "//span[@id='id-resend-link-button']/button")
    private WebElement resendLink;

    public ForgotPasswordPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterEmailToInput(String email) {
        actionsWithElements.enterText(emailInput, email);
    }

    public void clickSendConfirmationButtton() {
        actionsWithElements.clickLink(sendConfirmationButtton);
    }

    public boolean checkTextOnPagePresent(String text){
        return actionsWithElements.isTextPresent(text);
    }

    public void checkResendButtonPresent(){
        actionsWithElements.isElementPresent(resendLink);
    }
}
