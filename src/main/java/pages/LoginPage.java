package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement login = $(By.name("user"));
    private SelenideElement password = $(By.name("password"));
    private SelenideElement button = $(By.id("button_submit_login_form"));
    public void setLoginValue(String loginValue){
        login.setValue(loginValue);
    }
    public void setPasswordValue(String passwordValue){
        password.setValue(passwordValue);
    }
    public void buttonclick(){
        button.click();
    }
}