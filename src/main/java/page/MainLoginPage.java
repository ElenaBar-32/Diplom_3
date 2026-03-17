package page;

import io.qameta.allure.Step;
import model.UserModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static data.UserData.EMAIL;
import static data.UserData.PASSWORD;

public class MainLoginPage {
    private WebDriver driver;


    private final By loginAccountButton = By.xpath(".//*[text()='Войти в аккаунт']");
    // берем метод из другого класса  private final By personalAccountButton = By.xpath(".//*[text()='Личный Кабинет']");
    private final By emailField = By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By passwordField = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    private final By loginButton = By.xpath(".//*[text()='Войти']"); // войти в аккаунт
    private final By burgerIngredients = By.xpath(".//*[text()='Конструктор']"); // ждем появления
    // берем метод из другого класса  private final By registrationButton = By.xpath(".//*[text()='Зарегистрироваться']");
    private final By loginButtonRegistrationForm = By.className("Auth_link__1fOlj"); //войти в форме регистрации
    private final By recoverPasswordButton = By.xpath(".//*[text()='Восстановить пароль']");

    public MainLoginPage(WebDriver driver) {
        this.driver = driver;

    }
    @Step("Click on account button")
    public void clickLoginAccountButton() {
        driver.findElement(loginAccountButton).click();
    }
    @Step("Filling fields account")
    public void fillingFieldsAccount(UserModel user) {
        driver.findElement(emailField).sendKeys(EMAIL);
        driver.findElement(passwordField).sendKeys(PASSWORD);
    }
    @Step("Click on login button")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    @Step("Click on login button registration form")
    public void clickLoginButtonRegistrationForm() {
        driver.findElement(loginButtonRegistrationForm).click();
    }
    @Step("Click on login button recover password")
    public void clickLoginRecoverPasswordButton() {
        driver.findElement(recoverPasswordButton).click();
    }
    @Step("Visibility of the burger Ingredients ")
    public String visibilityOfBurgerIngredients () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement burgerIngredients = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Конструктор']")));
        return burgerIngredients.getText();
    }
}


