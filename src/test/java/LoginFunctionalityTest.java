import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginFunctionalityTest extends BaseTest {
    @Test
    public void successEnter() {
        loginPage.open();
        loginPage.setLoginValue(property.getProperty("login"));
        loginPage.setPasswordValue(property.getProperty("password"));
        loginPage.enter();
        assertTrue(mainPage.isRoleVisibility());
    }

    @Test
    public void IncorrectLogin() {
        loginPage.open();
        loginPage.setLoginValue(property.getProperty("Incorrect"));
        loginPage.setPasswordValue(property.getProperty("password"));
        loginPage.enter();
        assertTrue(loginPage.isCurrentUrl());
    }

    @Test
    public void IncorrectPassword() {
        loginPage.open();
        loginPage.setLoginValue(property.getProperty("login"));
        loginPage.setPasswordValue(property.getProperty("Incorrect"));
        loginPage.enter();
        assertTrue(loginPage.isCurrentUrl());
    }

    @Test
    public void passwordRecovery() {
        loginPage.open();
        loginPage.forgotPasswordClick();
        forgotPasswordPage.comparisonUrl();
        forgotPasswordPage.setLoginOrEmail();
        forgotPasswordPage.sendClick();
        assertTrue(forgotPasswordPage.isSuccessSend());
    }
}
