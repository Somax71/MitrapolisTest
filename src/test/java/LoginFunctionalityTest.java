import com.codeborne.selenide.*;
import com.codeborne.selenide.conditions.Visible;
import com.codeborne.selenide.conditions.webdriver.Url;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.LoginPage;
import utils.Property;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.time.Duration;
import static com.codeborne.selenide.Configuration.baseUrl;
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
    }

    @Test
    public void positiveTest() {
        Selenide.clearBrowserCookies();
        open(property.getProperty("baseUrl"));
        LoginPage loginval = new LoginPage();
        loginval.setLoginValue("fominaelena");
        loginval.setPasswordValue("z0K6CTQR");
        $(By.id("button_submit_login_form")).click();
        $("div.avatar-full-current-role").shouldHave(Condition.text("Сотрудник"));
    }

    @Test
    public void negativeTest() {
        Selenide.clearBrowserCookies();
        open(property.getProperty("baseUrl"));
        LoginPage loginval = new LoginPage();
        loginval.setLoginValue("incorrect");
        loginval.setPasswordValue("z0K6CTQR");
        $(By.id("button_submit_login_form")).click();
         webdriver().shouldHave(currentFrameUrlContaining("https://lmslite47vr.demo.mirapolis.ru/mira/Do"));
    }

    @Test
    public void passvordRecovery() {
        Selenide.clearBrowserCookies();
        open(property.getProperty("baseUrl"));
        $("table.links-container").click();
        webdriver().shouldHave(currentFrameUrlContaining( "https://lmslite47vr.demo.mirapolis.ru/mira//Do"));
        $(By.name("loginOrEmail")).setValue("fominaelena").pressEnter();
        $("div.success").shouldBe(Condition.visible);
    }

}
