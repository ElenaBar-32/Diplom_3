package Test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static data.UserData.*;

public class RegistrationTest extends  BaseUiTest {

    @Test
    @DisplayName ("Success register user")
    @Description ("Check successful user register")
    public void testSuccessRegister() {
        mainRegistrationPage.openPage();
        mainRegistrationPage.clickPersonalAccountButton();

        mainRegistrationPage.clickRegistrationButton();
        mainRegistrationPage.fillingFields(NAME, EMAIL, PASSWORD);
        mainRegistrationPage.clickRegisterButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mainPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h2[text()='Вход']")));
    }
    @Test
    @DisplayName ("Register invalid password")
    @Description ("Check register invalid password")
    public void testRegisterInvalidPassword() {
        mainRegistrationPage.openPage();
        mainRegistrationPage.clickPersonalAccountButton();
        mainRegistrationPage.clickRegistrationButton();
        mainRegistrationPage.fillingFields(NAME, EMAIL, INVALID_PASSWORD);
        mainRegistrationPage.clickRegisterButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("input__error")));
        System.out.println("Получена ошибка: Некорректный пароль ");


    }
}