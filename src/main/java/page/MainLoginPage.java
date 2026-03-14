package page;

import model.UserModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static data.UserData.EMAIL;
import static data.UserData.PASSWORD;

public class MainLoginPage {
    private WebDriver driver;

    // private final String URL = "https://stellarburgers.education-services.ru/";
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

    public void clickLoginAccountButton() {
        driver.findElement(loginAccountButton).click();
    }

    public void fillingFieldsAccount(UserModel user) {
        driver.findElement(emailField).sendKeys(EMAIL);
        driver.findElement(passwordField).sendKeys(PASSWORD);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickLoginButtonRegistrationForm() {
        driver.findElement(loginButtonRegistrationForm).click();
    }

    public void clickLoginRecoverPasswordButton() {
        driver.findElement(recoverPasswordButton).click();
    }
}


