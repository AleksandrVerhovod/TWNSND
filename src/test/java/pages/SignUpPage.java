package pages;

import constants.Urls;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(SignUpPage.class.getName());

    @FindBy(xpath = "//font[text()='Создать аккаунт']")
    private WebElement LOGO_CREATE_ACCOUNT_TEXT;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[3]/div/a[4]/button")
    private WebElement REG_BY_EMAIL_BUTTON;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        LOGGER.debug(String.format("Attempt to find button: %s", LOGO_CREATE_ACCOUNT_TEXT));
        return LOGO_CREATE_ACCOUNT_TEXT.isDisplayed();
    }

    @Step("Open SignUpPage page")
    public SignUpPage openSignUpPage() {
        LOGGER.debug(String.format("Attempt to open URL: %s", String.format(Urls.URL_TWNSND_MAIN, Urls.URL_TWNSND_LOGIN)));
        driver.get(String.format(Urls.URL_TWNSND_MAIN, Urls.URL_TWNSND_LOGIN));
        return this;
    }

    @Step("Open RegistrationByMail page")
    public RegistrationByMailPage openRegistrationByMailPage() {
        LOGGER.debug(String.format("Attempt to click button by locator: %s", REG_BY_EMAIL_BUTTON));
        REG_BY_EMAIL_BUTTON.click();
        return new RegistrationByMailPage(driver);
    }

}
