package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailPage extends ParentPage{

    @FindBy(xpath = "//*[@id='identifierId']")
    private WebElement emailInput;

    @FindBy(xpath = "//span[@class='RveJvd snByac']")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[@class='yW']/span")
    private WebElement receivedLetter;

    @FindBy(xpath = "//img[@alt='Confirm']")
    private WebElement confirmEmailButton;

    @FindBy(xpath = "//a[@class='gb_b']")
    private WebElement appGoogleButton;

    @FindBy(xpath = "//a[@href='https://mail.google.com/mail/']")
    private WebElement googleMailButton;


    public GmailPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterEmailToInput(String email) {
        actionsWithElements.enterText(emailInput, email);
    }

    public void clickNextButton() {
        actionsWithElements.clickButton(nextButton);
    }

    public void enterPasswordToInput(String password) {
        actionsWithElements.enterText(passwordInput, password);
    }

    public void clickReceivedLetter() {
        actionsWithElements.clickElement(receivedLetter);
    }

    public void moveToAndClickConfirmEmailButton (){
        actionsWithElements.movetoElementAndClick(confirmEmailButton);
    }

    public void waitForPasswordInputPresent(){
        actionsWithElements.waitForElementLoad(passwordInput);
    }

    public void loginUserGmail() throws InterruptedException {
        enterEmailToInput("credcred15@gmail.com");
        clickNextButton();
        waitForPasswordInputPresent();
        enterPasswordToInput("test");
        clickNextButton();
    }

    public void clickAppGoogleButton() {
        actionsWithElements.clickButton(appGoogleButton);
    }

    public void clickGoogleMailButton() {
        actionsWithElements.clickButton(googleMailButton);
    }

    public boolean checkTextOnPagePresent(String text){
        return actionsWithElements.isTextPresent(text);
    }

    public void waitForTMPageAndSwitchToIt() throws InterruptedException {
        actionsWithElements.waitForNewWindowAndSwitchToIt(webDriver);
    }
}
