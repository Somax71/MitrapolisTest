import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import utils.Property;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.*;
import static com.codeborne.selenide.Selenide.*;


public class LoginFunctionalityTest {

    private Property property=new Property();

    @BeforeEach
    public void init() {
        Configuration.timeout = 10000;
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Selenide.clearBrowserCookies();
    }

    @Test
    public void successEnter() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.setLoginValue(property.getProperty("login"));
        loginPage.setPasswordValue(property.getProperty("password"));
        loginPage.enter();
        MainPage mainPage = new MainPage();
        mainPage.visibilityСheck();
    }

    @Test
    public void batLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.setLoginValue(property.getProperty("bat"));
        loginPage.setPasswordValue(property.getProperty("password"));
        loginPage.enter();
        loginPage.comparisonUrl();

    }

    @Test
    public void batPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.setLoginValue(property.getProperty("login"));
        loginPage.setPasswordValue(property.getProperty("bat"));
        loginPage.enter();
        loginPage.comparisonUrl();

    }

    @Test
    public void passwordRecovery() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.forgotPassvordClick();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
        forgotPasswordPage.comparisonUrl();
        forgotPasswordPage.setLoginOrEmail();
        forgotPasswordPage.sendClick();
        forgotPasswordPage.succesSend();
    }

}
