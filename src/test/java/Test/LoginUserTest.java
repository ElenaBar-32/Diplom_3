package Test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import model.UserModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static data.UserData.*;
import static steps.UserSteps.createUser;
import static steps.UserSteps.deleteUser;

public class LoginUserTest extends  BaseUiTest {


    String token;
    private UserModel user;

    @Before
    @Override
    public void start() {
        super.start();
        RestAssured.baseURI = BASE_URI;
        UserModel user = new UserModel(EMAIL, PASSWORD);
        createUser(user);

    }

    @Test
    @DisplayName("Button login account")
    @Description("Checking the login account button")
    public void testButtonLoginAccount() {
        mainRegistrationPage.openPage();
        mainLoginPage.clickLoginAccountButton();
        mainLoginPage.fillingFieldsAccount(user);
        mainLoginPage.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement burgerIngredients = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Конструктор']")));
    }

    @Test
    @DisplayName("Personal account button")
    @Description("Checking the login button for your personal account")
    public void testPersonalAccountButton() {
        mainRegistrationPage.openPage();
        mainRegistrationPage.clickPersonalAccountButton();
        mainLoginPage.fillingFieldsAccount(user);
        mainLoginPage.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement burgerIngredients = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Конструктор']")));
    }

    @Test
    @DisplayName("Login button registration form")
    @Description("Checking the login button in the registration form")
    public void testLoginButtonRegistrationForm() {
        mainRegistrationPage.openPage();
        mainRegistrationPage.clickPersonalAccountButton();
        mainRegistrationPage.clickRegistrationButton();
        mainLoginPage.clickLoginButtonRegistrationForm();
        mainLoginPage.fillingFieldsAccount(user);
        mainLoginPage.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement burgerIngredients = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Конструктор']")));
    }

    @Test
    @DisplayName("Login recover password button")
    @Description("Checking the login button via the button in the password recovery form")
    public void testLoginRecoverPasswordButton() {
        mainRegistrationPage.openPage();
        mainRegistrationPage.clickPersonalAccountButton();
        mainLoginPage.clickLoginRecoverPasswordButton();
        mainLoginPage.clickLoginButton();
        mainLoginPage.fillingFieldsAccount(user);
        mainLoginPage.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement burgerIngredients = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Конструктор']")));
    }
    @After
    public void cleanUp() {
        if (token != null) {
            deleteUser(token);
        }
    }
}


