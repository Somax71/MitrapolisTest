package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrlContaining;

public class LoginPage {
    private SelenideElement login = $(By.name("user"));
    private SelenideElement password = $(By.name("password"));
    private SelenideElement enterbutton = $(By.id("button_submit_login_form"));
    private SelenideElement forgotPassword = $("table.links-container");

    private String url;

    public LoginPage() {
        url = "https://lmslite47vr.demo.mirapolis.ru/mira/Do";
    }

    public void setLoginValue(String loginValue) {
        login.setValue(loginValue);
    }

    public void setPasswordValue(String passwordValue) {
        password.setValue(passwordValue);
    }

    public void enter() {
        enterbutton.click();
    }

    public boolean isCurrentUrl() {
        try {
            webdriver().shouldHave(currentFrameUrlContaining(url));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public void open() {
        Selenide.open(url);
    }

    public void forgotPasswordClick() {
        forgotPassword.click();
    }
}