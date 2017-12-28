package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DownloadsPage extends ParentPage {

    @FindBy(xpath = ".//img[@class='app-logo']")
    WebElement tmLogo;


    public DownloadsPage(WebDriver webDriver){
        super(webDriver);
    }

    public boolean isLogoPresent(){
        return actionsWithElements.isElementPresent(tmLogo);
    }

    public boolean checkTextOnPagePresent(String text){
        return actionsWithElements.isTextPresent(text);
    }

    public void waitForDownloadsTMPageLoad(){
        actionsWithElements.waitForPageLoad();
    }

    public void waitFotTMLogoPresent(){
        actionsWithElements.waitForElementLoad(tmLogo);
    }
}
