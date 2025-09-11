package UI.com.jarhub.tests;

import com.jarhub.constants.FrameWorkConstants;
import com.jarhub.pages.LoginPage;
import com.jarhub.utils.JsonUtils;
import io.qameta.allure.*;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

@Epic("Login Module")
@Feature("Valid Login")
public final class LoginTest extends BaseTest{

    LoginPage loginPage=new LoginPage();
    JsonUtils jsonUtils;

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Login with valid user and password. Also Check Title")
    @Story("User logs in with valid credentials and check title")
    @Step("Login Functionality and Title Check Test")
    @Test(description = "Verify user login with valid credentials and check title", priority = 1)
    public void loginTest() throws Exception {
        loginPage.enterEmail("qalearningrepository@gmail.com").enterPassword("Renu@17061989").clickLoginButton();
        Allure.step("Login Test Passed");
        Assertions.assertThat(loginPage.getTitle()).describedAs("Title Validation")
                .isEqualTo("Let's Shop");
        Allure.step("Title Check Test Passed");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Logout Functionality.")
    @Story("User logged out from Application")
    @Step("Logout Functionality Test")
    @Test(description = "Verify user logout functionality",priority = 2)
    public void logoutTest() throws Exception {
        String label = loginPage.enterEmail("qalearningrepository@gmail.com").enterPassword("Renu@17061989").clickLoginButton()
                .clickLogoutButton().getLogInLable();
        Assertions.assertThat(label).describedAs("Log In Label Validation")
                .isEqualTo("Log in");
        Allure.step("Logout Test Passed");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Login with valid user and password with Json Driven. Also Check Title")
    @Story("User logs in with valid credentials and check title")
    @Step("Login Functionality and Title Check Test with Json Driven")
    @Test(description = "Verify user login with valid credentials and check title with Json Driven",priority = 3)
    public void loginTestWithJson() throws Exception {
        jsonUtils=new JsonUtils(FrameWorkConstants.getResourcePath()+"/jsons/login.json");
        loginPage.enterEmail(jsonUtils.getNestedValue("credentials","username"))
                .enterPassword(jsonUtils.getNestedValue("credentials","password"))
                .clickLoginButton();
        Allure.step("Login Test Passed");
        Assertions.assertThat(loginPage.getTitle()).describedAs("Title Validation")
                .isEqualTo("Let's Shop");
        Allure.step("Title Check Test Passed");
    }

}
