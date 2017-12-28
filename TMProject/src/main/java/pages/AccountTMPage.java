package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountTMPage extends ParentPage{

    @FindBy(xpath = "//span[@id='id-facebook-confirm-login']/button")
    private WebElement connectFacebookButton;


    public AccountTMPage(WebDriver webDriver) {
        super(webDriver);
    }


    public boolean checkTextOnPagePresent(String text){
        return actionsWithElements.isTextPresent(text);
    }
}
