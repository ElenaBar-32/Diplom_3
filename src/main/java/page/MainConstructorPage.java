package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainConstructorPage {
    private WebDriver driver;

    private final By bunButton = By.xpath(".//*[text()='Булки']");
    private final By sauceButton = By.xpath(".//*[text()='Соусы']");
    private final By stuffingButton = By.xpath(".//*[text()='Начинки']");
    private final By activeBun = By.xpath(".//*[text()='Булки']/parent::*[contains(@class, 'current')]");
    private final By activeSauce = By.xpath(".//*[text()='Соусы']/parent::*[contains(@class, 'current')]");
    private final By activeStuffing = By.xpath(".//*[text()='Начинки']/parent::*[contains(@class, 'current')]");

    public MainConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on bun button")
    public void clickBunButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement bunButtonElement = wait.until(ExpectedConditions.elementToBeClickable(bunButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bunButtonElement);
    }

    @Step("Transition on bun button")
    public String transitionBunButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement activeBun = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains(@class, 'tab_tab_type_current')]/span")));
        return activeBun.getText();

    }

    @Step("Click on sauce button")
    public void clickSauceButton() {
        driver.findElement(sauceButton).click();
    }

    @Step("Transition on sauce button")
    public String transitionSauceButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement activeSauce = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains(@class, 'tab_tab_type_current')]/span")));
        return activeSauce.getText();
    }

    @Step("Click on stuffing button")
    public void clickStuffingButton() {
        driver.findElement(stuffingButton).click();
    }

    @Step("Transition on stuffing button")
    public String transitionStuffingButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement activeStuffing = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains(@class, 'tab_tab_type_current')]/span")));
        return activeStuffing.getText();
    }
}