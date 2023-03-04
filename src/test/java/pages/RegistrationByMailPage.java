package pages;

import constants.Urls;
import io.qameta.allure.Step;
import models.RegistrationModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationByMailPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(RegistrationByMailPage.class.getName());

    @FindBy(xpath = "//input[@name='E-mail']")
    private WebElement EMAIL_FIELD;

    @FindBy(xpath = "//input[@name='Пароль']")
    private WebElement PASSWORD_FIELD;

    @FindBy(xpath = "//input[@name='Подтвердите пароль']")
    private WebElement CONFIRM_PASSWORD_FIELD;

    @FindBy(xpath = "//input[@name='Имя']")
    private WebElement NAME_FIELD;

    @FindBy(xpath = "//input[@name='Фамилия']")
    private WebElement LASTNAME_FIELD;

    @FindBy(xpath = "//button[text()='Создать аккаунт']")
    private WebElement SIGNUP_BUTTON;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[3]/div/div/div[2]/div[2]/text()")
    private WebElement ERROR_EMAIL_MESSAGE;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[3]/div/div/div[3]/div[2]/text()")
    private WebElement ERROR_PASSWORD_MESSAGE;

    @FindBy(xpath = "//div[text()='*Имя должно содержать минимум 2 символа']")
    private WebElement ERROR_NAME_MESSAGE;

    @FindBy(xpath = "//div[text()='*Фамилия должна содержать минимум 2 символа']")
    private WebElement ERROR_LASTNAME_MESSAGE;


    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[3]/div/div/div[4]/div[2]/text()")
    private WebElement ERROR_CONFIRM_PASSWORD_MESSAGE;

    public RegistrationByMailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        LOGGER.debug(String.format("Attempt to find button: %s", SIGNUP_BUTTON));
        return SIGNUP_BUTTON.isDisplayed();
    }


    @Step("Refresh registration page")
    public RegistrationByMailPage refreshRegistrationPage() {
        LOGGER.debug(String.format("Attempt to open URL: %s", String.format(Urls.URL_TWNSND_MAIN, Urls.URL_TWNSND_REGISTER)));
        driver.navigate().refresh();
        return this;
    }

    @Step("Fill registration form")
    public RegistrationByMailPage fillRegistrationsFields(RegistrationModel regModel) {
        EMAIL_FIELD.sendKeys(regModel.getEmail());
        LOGGER.debug(String.format("Input into field Email value: %s", regModel.getEmail()));
        PASSWORD_FIELD.sendKeys(regModel.getPassword());
        LOGGER.debug(String.format("Input into field Password value: %s", regModel.getPassword()));
        CONFIRM_PASSWORD_FIELD.sendKeys(regModel.getConfirmPassword());
        LOGGER.debug(String.format("Input into field Confirm Password value: %s", regModel.getConfirmPassword()));
        NAME_FIELD.sendKeys(regModel.getName());
        LOGGER.debug(String.format("Input into field Fill Name value: %s", regModel.getName()));
        LASTNAME_FIELD.sendKeys(regModel.getLastName());
        LOGGER.debug(String.format("Input into field Super Code value: %s", regModel.getLastName()));
        return this;
    }

    @Step("Click button 'Sign Up'")
    public SignInPage clickSignUpButton() {
        LOGGER.debug(String.format("Attempt to click button by locator: %s", SIGNUP_BUTTON));
        SIGNUP_BUTTON.click();
        return new SignInPage(driver);
    }
    @Step("Search error message about Email")
    public boolean isErrorEmailMessageIsDisplayed() {
        LOGGER.debug(String.format("Attempt to find message by locator: %s", ERROR_EMAIL_MESSAGE));
        return ERROR_EMAIL_MESSAGE.isDisplayed();
    }

    @Step("Search error message about Password")
    public boolean isErrorPasswordMessageIsDisplayed() {
        LOGGER.debug(String.format("Attempt to find message by locator: %s", ERROR_PASSWORD_MESSAGE));
        return ERROR_PASSWORD_MESSAGE.isDisplayed();


    }
    @Step("Search error message about Confirm Password")
    public boolean isErrorConfirmPasswordMessageIsDisplayed() {
        LOGGER.debug(String.format("Attempt to find message by locator", ERROR_CONFIRM_PASSWORD_MESSAGE));
        return ERROR_CONFIRM_PASSWORD_MESSAGE.isDisplayed();
    }
    @Step("Search error message about Full Name")
    public boolean isErrorFullNameMessageIsDisplayed() {
        LOGGER.debug(String.format("Attempt to find message by locator", ERROR_NAME_MESSAGE));
        return ERROR_NAME_MESSAGE.isDisplayed();
    }
}
