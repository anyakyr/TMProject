package parrentTest;

import libs.Utils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;

@RunWith(value = Parameterized.class)
public class ParrentTest {
    public WebDriver webDriver;

    private Logger logger = Logger.getLogger(getClass());
    private Utils utils = new Utils();
    private String pathToScreenShot;

    private String browser;
    private boolean isTestPass = false;

    public LoginPage loginPage;
    public ForgotPasswordPage forgotPasswordPage;
    public DownloadsPage downloadsPage;
    public GmailPage gmailPage;
    public AccountTMPage accountTMPage;
    public FacebookPage facebookPage;

    public ParrentTest(String browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        return Arrays.asList(new Object[][]{
                {"chrome"}
        });
    }

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() {
        File file = new File("");

        pathToScreenShot = file.getAbsolutePath() + "\\target\\screenshots\\"
                + this.getClass().getPackage().getName() + "\\"
                + this.getClass().getSimpleName() + "\\"
                + this.testName.getMethodName() + "-" + browser + ".jpg";

        File fileFF = new File("drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage(webDriver);
        forgotPasswordPage = new ForgotPasswordPage(webDriver);
        downloadsPage = new DownloadsPage(webDriver);
        gmailPage = new GmailPage(webDriver);
        accountTMPage = new AccountTMPage(webDriver);
        facebookPage = new FacebookPage(webDriver);
    }

    @After
    public void tearDown() {
        if (!(webDriver == null)) {
            if (!isTestPass) {
                utils.screenShot(pathToScreenShot, webDriver);
            }
            webDriver.quit();
            logger.info("-------------- TEST FINISHED ---------------");
        }
    }

    public void checkAC(String message, boolean actualResult, boolean expectedResult) {
        Assert.assertThat(message, actualResult, is(expectedResult));
        setTestPass();
    }

    protected void checkAC(String message, String actual, String expected) {
        if (!actual.equals(expected)) {
            utils.screenShot(pathToScreenShot, webDriver);
            logger.error("AC failed: " + message);
        }
        setTestPass();
    }

    private void setTestPass() {
        isTestPass = true;
    }
}
