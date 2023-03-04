package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.ConfirmRegistrationPage;
import pages.RegistrationPage;
import testdata.dataprovider.DataProviderRegistrationClass;
import jdk.jfr.Description;
import models.RegistrationModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.RegistrationByMailPage;
import testdata.PrepareRegistrationData;

@Feature("Registration")
public class RegistrationTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(RegistrationTest.class.getName());

    @Test(dataProvider = "validEmailForSignInProvider", dataProviderClass = DataProviderRegistrationClass.class)
    @Description("Create users with constant email and password, valid data in all fields")
    @Step("Register user to application by {data[]}")
    public void createUsersForSignInByMailTest(String data[]) {
        LOGGER.info(String.format("Page %s initialized", RegistrationPage.class.getName()));
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        LOGGER.info(String.format("Page %s open", RegistrationPage.class.getName()));
        registrationPage.openRegistrationPage()
                .clickRegistrationByMailButton();
        LOGGER.info(String.format("Page %s initialized", RegistrationByMailPage.class.getName()));
        RegistrationByMailPage registrationByMailPage = new RegistrationByMailPage(getDriver());
        LOGGER.info(String.format("Open %s page", RegistrationByMailPage.class.getName()));
        LOGGER.info(String.format("Prepared valid data by %s", PrepareRegistrationData.class.getName()));
        RegistrationModel registrationModel = PrepareRegistrationData.fillRegistrationModel(data[0], data[1]);
        registrationByMailPage
                .fillRegistrationsFields(registrationModel)
                .clickButtonCreateAccount();
        LOGGER.info(String.format("Page %s initialized", ConfirmRegistrationPage.class.getName()));
        ConfirmRegistrationPage confirmRegistrationPage = new ConfirmRegistrationPage(getDriver());
        confirmRegistrationPage.clickActivateButton();
        LOGGER.info("Check if account is created");
        Assert.assertTrue(confirmRegistrationPage.isActivateMessageDisplayed(), "Link didn't sent");
    }
//
//    @Test(enabled = false, dataProvider = "validRandomEmailPasswordProvider", dataProviderClass = DataProviderRegistrationClass.class)
//    @Description("Create users with random valid data")
//    @Step("Register user to application by {data[]}")
//    public void createUsersWithRandomDataTest(String data[]) {
//        LOGGER.info(String.format("Page %s initialized", RegistrationByMailPage.class.getName()));
//        RegistrationByMailPage registrationByMailPage = new RegistrationByMailPage(getDriver());
//        LOGGER.info(String.format("Open %s page", RegistrationByMailPage.class.getName()));
//        LOGGER.info(String.format("Prepared valid data by %s", PrepareRegistrationData.class.getName()));
//        RegistrationModel registrationModel = PrepareRegistrationData.fillRegistrationModel(data[0], data[1]);
//        registrationByMailPage
//
//                .fillRegistrationsFields(registrationModel)
//                .clickSignUpButton();
//        SignInPage informationBoardPage = new SignInPage(getDriver());
//        LOGGER.info(String.format("Open %s page", SignInPage.class.getName()));
//        LOGGER.info("Check if account is created");
//        Assert.assertTrue(informationBoardPage.isPageOpened(), "User not created");
//    }
//
//
//    @Test(dataProvider = "notValidEmailProvider", dataProviderClass = DataProviderRegistrationClass.class)
//    @Description("The user login with not valid email and valid other fields")
//    @Step("Register user to application by Email {data[]}")
//    public void notValidEmailRegistrationTest(String data[]) {
//        LOGGER.info(String.format("Page %s initialized", RegistrationByMailPage.class.getName()));
//        RegistrationByMailPage registrationByMailPage = new RegistrationByMailPage(getDriver());
//        LOGGER.info(String.format("Open %s page", RegistrationByMailPage.class.getName()));
//        LOGGER.info(String.format("Prepared valid data by %s", PrepareRegistrationData.class.getName()));
//        RegistrationModel registrationModel = PrepareRegistrationData.fillRegistrationWithNegativeEmailModel(data[0]);
//        registrationByMailPage
//
//                .fillRegistrationsFields(registrationModel)
//                .clickSignUpButton();
//        LOGGER.info("Check if error message is displayed");
//        Assert.assertTrue(registrationByMailPage.isErrorEmailMessageIsDisplayed(), "Error message isn't displayed");
//    }
//
//
//    @Test(dataProvider = "notValidPasswordProvider", dataProviderClass = DataProviderRegistrationClass.class)
//    @Description("The user login with not valid password and valid other fields")
//    @Step("Register user to application by Password {data[]}")
//    public void notValidPasswordRegistrationTest(String data[]) {
//        LOGGER.info(String.format("Page %s initialized", RegistrationByMailPage.class.getName()));
//        RegistrationByMailPage registrationByMailPage = new RegistrationByMailPage(getDriver());
//        LOGGER.info(String.format("Open %s page", RegistrationByMailPage.class.getName()));
//        LOGGER.info(String.format("Prepared valid data by %s", PrepareRegistrationData.class.getName()));
//        RegistrationModel registrationModel = PrepareRegistrationData.fillRegistrationWithNegativePasswordModel(data[0]);
//        registrationByMailPage
//
//                .fillRegistrationsFields(registrationModel)
//                .clickSignUpButton();
//        LOGGER.info("Check if error message is displayed");
//        Assert.assertFalse(registrationByMailPage.isErrorPasswordMessageIsDisplayed(), "Error message isn't displayed");
//    }
//
//    @Test(dataProvider = "notValidConfirmPasswordProvider", dataProviderClass = DataProviderRegistrationClass.class)
//    @Description("The user login with not valid confirm password and valid other fields")
//    @Step("Register user to application by Confirm Password {data[]} ")
//    public void notValidConfirmPasswordRegistrationTest(String data[]) {
//        LOGGER.info(String.format("Page %s initialized", RegistrationByMailPage.class.getName()));
//        RegistrationByMailPage registrationByMailPage = new RegistrationByMailPage(getDriver());
//        LOGGER.info(String.format("Open %s page", RegistrationByMailPage.class.getName()));
//        LOGGER.info(String.format("Prepared valid data by %s", PrepareRegistrationData.class.getName()));
//        RegistrationModel registrationModel = PrepareRegistrationData.fillRegistrationWithNotValidConfirmPasswordModel(data[0]);
//        registrationByMailPage
//
//                .fillRegistrationsFields(registrationModel)
//                .clickSignUpButton();
//        LOGGER.info("Check if error message is displayed");
//        Assert.assertTrue(registrationByMailPage.isErrorConfirmPasswordMessageIsDisplayed(), "Error message isn't displayed");
//    }
//
//    @Test(dataProvider = "notValidFullNameProvider", dataProviderClass = DataProviderRegistrationClass.class)
//    @Description("The user login with not valid full name and valid other fields")
//    @Step("Register user to application by Full Name {data[]}")
//    public void notValidFullNameRegistrationTest(String data[]) {
//        LOGGER.info(String.format("Page %s initialized", RegistrationByMailPage.class.getName()));
//        RegistrationByMailPage registrationByMailPage = new RegistrationByMailPage(getDriver());
//        LOGGER.info(String.format("Open %s page", RegistrationByMailPage.class.getName()));
//        LOGGER.info(String.format("Prepared valid data by %s", PrepareRegistrationData.class.getName()));
//        RegistrationModel registrationModel = PrepareRegistrationData.fillRegistrationWithNegativeFullNameModel(data[0]);
//        registrationByMailPage
//
//                .fillRegistrationsFields(registrationModel)
//                .clickSignUpButton();
//        LOGGER.info("Check if error message is displayed");
//        Assert.assertTrue(registrationByMailPage.isErrorFullNameMessageIsDisplayed(), "Error message isn't displayed");
//    }

}
