import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;


public class BaseTest {
        @BeforeEach
    public void init() {
        Configuration.timeout = 10000;
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Selenide.clearBrowserCookies();
    }
}
