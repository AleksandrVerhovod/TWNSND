package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmRegistrationPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(ConfirmRegistrationPage.class.getName());

    @FindBy(xpath = "//button[text()='Активировать']")
    private WebElement ACTIVATE_MAIL_BUTTON;

    @FindBy(xpath = "//div[contains(text(),'Пожалуйста, активируйте свою учетную запись')]")
    private WebElement ACTIVATE_MAIL_TEXT;

    public ConfirmRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        LOGGER.debug(String.format("Attempt to find button: %s", ACTIVATE_MAIL_BUTTON));
        return ACTIVATE_MAIL_BUTTON.isDisplayed();
    }
    @Step("Sent confirmation registration link")
    public ConfirmRegistrationPage clickActivateButton() {
        LOGGER.debug(String.format("Attempt to click button: %s", ACTIVATE_MAIL_BUTTON));
        ACTIVATE_MAIL_BUTTON.click();
        return this;
    }

    @Step("Check if Error message is displayed")
    public boolean isActivateMessageDisplayed() {
        LOGGER.debug(String.format("Attempt to find button: %s", ACTIVATE_MAIL_TEXT));
        return ACTIVATE_MAIL_TEXT.isDisplayed();
    }

}
