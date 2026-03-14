package Test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorTest extends BaseUiTest {


    @Test
    @DisplayName("Transition bun button")
    @Description("Checking the transition to the bun button")
    public void testTransitionBunButton() {
        mainRegistrationPage.openPage();
        mainConstructorPage.clickBunButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement activeBun = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains(@class, 'tab_tab_type_current')]/span")));
        String text = activeBun.getText();
        System.out.println(text);
    }

    @Test
    @DisplayName("Transition sauce button")
    @Description("Checking the transition to the bun sauce")
    public void testTransitionSauceButton() {
        mainRegistrationPage.openPage();
        mainConstructorPage.clickSauceButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement activeSauce = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains(@class, 'tab_tab_type_current')]/span")));
        String text = activeSauce.getText();
        System.out.println(text);
    }

    @Test
    @DisplayName("Transition stuffing button")
    @Description("Checking the transition to the bun stuffing")
    public void testTransitionStuffingButton() {
        mainRegistrationPage.openPage();
        mainConstructorPage.clickStuffingButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement activeStuffing = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains(@class, 'tab_tab_type_current')]/span")));
        String text = activeStuffing.getText();
        System.out.println(text);
    }
}
