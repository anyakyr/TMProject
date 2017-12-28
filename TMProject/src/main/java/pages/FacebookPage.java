package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookPage extends ParentPage{

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "pass")
    WebElement passwordInput;

    @FindBy(xpath = "//label[@id='loginbutton']/input")
    WebElement signInButton;

    public FacebookPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void getWindowLoginToFacebook(){
        actionsWithElements.getWindowHandle();
    }

    public void enterEmailToInput(String email) {
        actionsWithElements.enterText(emailInput, email);
    }

    public void enterPasswordToInput(String password) {
        actionsWithElements.enterText(passwordInput, password);
    }

    public void clickSignInButton(){
        actionsWithElements.clickButton(signInButton);
    }

    public void loginUserFacebook() {
        enterEmailToInput("super_testtm@ukr.net");
        enterPasswordToInput("Qwerty111");
        clickSignInButton();
    }
}
