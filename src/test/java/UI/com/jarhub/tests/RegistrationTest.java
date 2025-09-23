package UI.com.jarhub.tests;

import com.jarhub.constants.FrameWorkConstants;
import com.jarhub.pages.DashBoardPage;
import com.jarhub.pages.LoginPage;
import com.jarhub.pages.RegistrationPage;
import com.jarhub.utils.JsonUtils;
import io.qameta.allure.*;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

@Epic("Login Module")
@Feature("Valid Login")
public final class RegistrationTest extends BaseTest{

    LoginPage loginPage=new LoginPage();
    DashBoardPage dashBoardPage=new DashBoardPage();
    RegistrationPage registrationPage=new RegistrationPage();
    JsonUtils jsonUtils;

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Registration with New User")
    @Story("Registration with New User")
    @Step("Registration with New User")
    @Test(description = "Verify user Registration with New User", priority = 1)
    public void registrationTest() throws Exception {
        jsonUtils = new JsonUtils("src/test/resources/jsons/registration.json");
        loginPage.clickRegisterHere();
        String uniqueEmail = "john.doe" + System.currentTimeMillis() + "@example.com";
        registrationPage
                .enterFirstName(jsonUtils.getNestedValue("registration", "firstName"))
                .enterLastName(jsonUtils.getNestedValue("registration", "lastName"))
                .enterEmail(uniqueEmail)
                .enterPhone(jsonUtils.getNestedValue("registration", "phone"))
                .selectOccupation(jsonUtils.getNestedValue("registration", "occupation"))
                .selectGender(jsonUtils.getNestedValue("registration", "gender"))
                .enterPassword(jsonUtils.getNestedValue("registration", "password"))
                .enterConfirmPassword(jsonUtils.getNestedValue("registration", "confirmPassword"))
                .checkAgeConfirmation()
                .clickRegisterButton();

        Assertions.assertThat(dashBoardPage.getSuccessfulMessageDisplayed())
                .describedAs("Successful Message Validation")
                .isEqualTo("Account Created Successfully");
    }
}
