package page;

import io.qameta.allure.Step;
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
    @Step("Open page")
    public void openPage() {
        driver.get(URL);
    }
    @Step("Click button personal account")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();

    }
    @Step("Click button registration")
    public void clickRegistrationButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement registrationButtonElement = wait.until(ExpectedConditions.elementToBeClickable(registrationButton));
        registrationButtonElement.click();

    }
    @Step("Filling fields")
    public void fillingFields(String name, String email, String password) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }
    @Step("Click button register")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
    @Step("Visibility of the main page")
    public String visibilityOfMainPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mainPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h2[text()='Вход']")));
        return mainPage.getText();
    }
    @Step("Visibility of the error message")
    public String visibilityOfErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("input__error")));
        return errorMessage.getText();
    }

}




