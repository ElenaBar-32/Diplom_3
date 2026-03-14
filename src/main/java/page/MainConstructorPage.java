package page;

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
public void clickBunButton() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement bunButtonElement = wait.until(ExpectedConditions.elementToBeClickable(bunButton));

    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bunButtonElement);
    //bunButtonElement.click();

    //driver.findElement(bunButton).click();

}

    public void clickSauceButton() {
        driver.findElement(sauceButton).click();

}
    public void clickStuffingButton() {
        driver.findElement(stuffingButton).click();
    }
}