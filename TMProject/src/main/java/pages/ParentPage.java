package pages;

import libs.ActionsWithElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;

public class ParentPage {
    WebDriver webDriver;
    Logger logger;
    ActionsWithElements actionsWithElements;


    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        actionsWithElements = new ActionsWithElements(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method open url
     *
     * @param url
     */
    public void open(String url) {
        try {
            webDriver.get(url);
            logger.info("Page was open " + url);
        } catch (Exception e) {
            logger.error("Page can not open" + url);
            Assert.fail("Page can not open" + url);
        }
    }

    /**
     * Method check Title
     *
     * @param expectedTitle
     */
    public void checkTitle(String expectedTitle) {
        try {
            Assert.assertThat("Title not match", webDriver.getTitle(), is(expectedTitle));
        } catch (Exception e) {
            logger.error("Can not work with page ");
            Assert.fail("Can not work with page ");
        }
    }
}
