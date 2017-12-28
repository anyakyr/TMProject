package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//span[@id='id-general-facebook-button']/button")
    private WebElement useYourFacebookAccountButton;

    @FindBy(xpath = "//span[@id='id-index-continue-button']/button")
    private WebElement continueButton;

    @FindBy(xpath = "//a[@href='#/forgot-password']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//span[@id='id-create-new-account']/button")
    private WebElement createAccountButton;

    @FindBy(xpath = "//span[@id='id-login-or-signup-link']/a")
    private WebElement logInLink;

    @FindBy(xpath = "//input[@type='checkbox']/following-sibling::label")
    private WebElement subscribeNewsletterCheckbox;

    @FindBy(xpath = "//span[@class='text-field__notification-icon icon password-toggle icon-eye']")
    private WebElement iconEye;

    @FindBy(xpath = "//span[@id='id-resend-link-button']/button")
    private WebElement resendLink;

    @FindBy(xpath = "//span[@class='text-field__notification-icon icon icon-alert']")
    private WebElement iconAlert;

    @FindBy(xpath = "//span[@id='id-well-known-domain-button']/button")
    private WebElement goToGmailButton;

    @FindBy(xpath = "//span[@id='id-password-login-button']/button")
    private WebElement loginButton;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage() {
        open("https://account.templatemonster.com/auth/");
    }

    public void enterEmailToInput(String email) {
        actionsWithElements.enterText(emailInput, email);
    }

    public void enterPasswordToInput(String password) {
        actionsWithElements.enterText(passwordInput, password);
    }

    public void clickUseYourFacebookAccountButton() {
        actionsWithElements.clickButton(useYourFacebookAccountButton);
    }

    public void clickContinueButton() {
        actionsWithElements.clickButton(continueButton);
    }

    public void clickCreateAccountButton() {
        actionsWithElements.clickButton(createAccountButton);
    }

    public void checkIsUseYourFacebookAccountButtonDisable(){
        actionsWithElements.isElementDisable(useYourFacebookAccountButton);
    }

    public void checkIsEmailInputDisable(){
        actionsWithElements.isElementDisable(emailInput);
    }

    public boolean checkTextOnPagePresent(String text){
        return actionsWithElements.isTextPresent(text);
    }

    public void selectSubscribeNewsletterCheckbox (){
        actionsWithElements.setCheckboxState(subscribeNewsletterCheckbox,"unchecked");
    }

    public void checkIsIconAlertPresent (){
        actionsWithElements.isElementPresent(iconAlert);
    }

    public void moveToLoginLink (){
        actionsWithElements.movetoElement(logInLink);
    }

    public void moveToAndClickGoToGmailButton (){
        actionsWithElements.movetoElementAndClick(goToGmailButton);
    }

    public void moveToAndClickForgotPasswordLink() {
        actionsWithElements.movetoElementAndClick(forgotPasswordLink);
    }

    public void checkIsResendButtonPresent (){
        actionsWithElements.isElementPresent(resendLink);
    }

    public void clickLoginButton() {
        actionsWithElements.clickButton(loginButton);
    }
}
