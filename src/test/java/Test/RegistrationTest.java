package Test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static data.UserData.*;
import static org.junit.Assert.assertEquals;
import static steps.UserSteps.deleteUser;

public class RegistrationTest extends  BaseUiTest {

    String token;

    @Test
    @DisplayName("Success register user")
    @Description("Check successful user register")
    public void testSuccessRegister() {
        mainRegistrationPage.openPage();
        mainRegistrationPage.clickPersonalAccountButton();
        mainRegistrationPage.clickRegistrationButton();
        mainRegistrationPage.fillingFields(NAME, EMAIL, PASSWORD);
        mainRegistrationPage.clickRegisterButton();
        String text = mainRegistrationPage.visibilityOfMainPage();
        assertEquals ("Вход",text);
    }

    @Test
    @DisplayName("Register invalid password")
    @Description("Check register invalid password")
    public void testRegisterInvalidPassword() {
        mainRegistrationPage.openPage();
        mainRegistrationPage.clickPersonalAccountButton();
        mainRegistrationPage.clickRegistrationButton();
        mainRegistrationPage.fillingFields(NAME, EMAIL, INVALID_PASSWORD);
        mainRegistrationPage.clickRegisterButton();
        String text = mainRegistrationPage.visibilityOfErrorMessage();
        assertEquals ("Некорректный пароль",text);
        System.out.println("Получена ошибка: Некорректный пароль");
    }

    @After
    public void cleanUp() {
        if (token != null) {
            deleteUser(token);
        }
    }
}