package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(SignInPage.class.getName());

    @FindBy(xpath = "//span[text()='Categories']/ancestor::div[contains(@class, 'Link_collapsed_')]")
    private WebElement LOGO_CATEGORIES_WITHOUT_TEXT;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }
}
