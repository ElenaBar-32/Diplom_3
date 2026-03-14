package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class MainRegistrationPage {

    private WebDriver driver;


    private final String URL = "https://stellarburgers.education-services.ru/";
    private final By personalAccountButton = By.xpath(".//*[text()='Личный Кабинет']");
    private final By registrationButton = By.xpath(".//*[text()='Зарегистрироваться']");  // ждем появления и наживаем
    private final By registerPage = By.xpath(".//*[text()='Регистрация']");  //дождаться появления
    private final By nameField = By.xpath(".//label[text()='Имя']/following-sibling::input");//By.cssSelector("input[placeholder*='Имя']");
    private final By emailField = By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By passwordField = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    private final By registerButton = By.cssSelector("button.button_button__33qZ0"); // зарегистрироваться
    private final By mainPage = By.xpath(".//h2[text()='Вход']"); //дождаться появления после регистрации
    private final By errorMessage = By.className("input__error");


    public MainRegistrationPage(WebDriver driver) {
        this.driver = driver;

    }

    public void openPage() {
        driver.get(URL);
    }

    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();

    }

    public void clickRegistrationButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement registrationButtonElement = wait.until(ExpectedConditions.elementToBeClickable(registrationButton));
        registrationButtonElement.click();

    }

    public void fillingFields(String name, String email, String password) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
}




