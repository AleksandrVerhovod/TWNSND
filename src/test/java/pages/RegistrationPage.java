package pages;

import constants.Urls;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(RegistrationPage.class.getName());

    @FindBy(xpath = "//div")
    private WebElement LOGO_REG_PAGE;

//    @FindBy(xpath = "")
//    private WebElement REG_BY_GOOGLE;
//
//    @FindBy(xpath = "")
//    private WebElement REG_BY_FACEBOOK;
//
//    @FindBy(xpath = "")
//    private WebElement REG_BY_VK;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[3]/div/a[4]/button")
    private WebElement REG_BY_MAIL;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        LOGGER.debug(String.format("Attempt to find button: %s", LOGO_REG_PAGE));
        return LOGO_REG_PAGE.isDisplayed();
    }
    @Step("Open registration page")
    public RegistrationPage openRegistrationPage() {
        LOGGER.debug(String.format("Attempt to open URL: %s%s", Urls.URL_TWNSND_MAIN, Urls.URL_TWNSND_REGISTER));
        driver.get(String.format("%s%s", Urls.URL_TWNSND_MAIN, Urls.URL_TWNSND_REGISTER));
        return this;
    }

    @Step("Open registration page")
    public RegistrationByMailPage clickRegistrationByMailButton () {
        LOGGER.debug(String.format("Attempt to click button: %s", REG_BY_MAIL));
        REG_BY_MAIL.click();
        return new RegistrationByMailPage(driver);
    }
}
