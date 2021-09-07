import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import utils.Property;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class BaseTest {
    protected LoginPage loginPage = new LoginPage();
    protected ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    protected MainPage mainPage = new MainPage();
    protected Property property=new Property();

    @BeforeEach
    public void init() {
        Configuration.timeout = 10000;
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    public void end(){
        closeWebDriver();
    }
}
