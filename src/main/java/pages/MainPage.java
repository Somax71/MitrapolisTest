package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private SelenideElement role = $("div.avatar-full-current-role");

    public void visibilityСheck(){ role.shouldHave(Condition.text("Сотрудник")); }
}
