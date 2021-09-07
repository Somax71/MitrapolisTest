package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.*;
import static com.codeborne.selenide.Selenide.*;

public class ForgotPasswordPage {
    private String url;

    private SelenideElement loginOrEmail = $(By.name("loginOrEmail"));
    private SelenideElement send = $("Button");
    private SelenideElement success = $("div.success");

    public ForgotPasswordPage() {
        url = "https://lmslite47vr.demo.mirapolis.ru/mira//Do";
    }

    public void comparisonUrl() {
        webdriver().shouldHave(currentFrameUrlContaining(url));
    }

    public void setLoginOrEmail() {
        loginOrEmail.setValue("fominaelena");
    }

    public void sendClick() {
        send.click();
    }

    public boolean isSuccessSend() {
        return success.shouldBe(Condition.visible).isDisplayed();
    }
}
