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
    private String baseurl = "https://lmslite47vr.demo.mirapolis.ru/mira";
    private String url = "https://lmslite47vr.demo.mirapolis.ru/mira/Do";
    private SelenideElement forgotPassvord = $("table.links-container");

    public void setLoginValue(String loginValue){
        login.setValue(loginValue);
    }
    public void setPasswordValue(String passwordValue){
        password.setValue(passwordValue);
    }
    public void enter(){ enterbutton.click(); }
    public void comparisonUrl(){  webdriver().shouldHave(currentFrameUrlContaining(url)); }
    public void open(){ Selenide.open(baseurl); }
    public void forgotPassvordClick(){ forgotPassvord.click(); }
}