import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

@RunWith(Cucumber.class)
public class TestRunner {

    @BeforeClass
    public static void init() {

        WebDriver driver;
        if (System.getProperty("browser", "chrome").equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
    }


    @AfterClass
    public static void finish() {
        WebDriverRunner.closeWebDriver();
    }

}
