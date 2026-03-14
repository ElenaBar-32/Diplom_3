package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import page.MainConstructorPage;
import page.MainLoginPage;
import page.MainRegistrationPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class BaseUiTest {
    WebDriver driver;
    protected MainRegistrationPage mainRegistrationPage;
    protected MainLoginPage mainLoginPage;
    protected MainConstructorPage mainConstructorPage;


    @Before

    public void start() {

        String browser = System.getProperty("browser", "chrome");

        if ("yandex".equals(browser)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            options.setBinary("C:\\Program Files\\Yandex\\YandexBrowser\\Application\\browser.exe");

            driver = new ChromeDriver(options);
        } else {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        mainRegistrationPage = new MainRegistrationPage(driver);
        mainLoginPage = new MainLoginPage(driver);
        mainConstructorPage = new MainConstructorPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
