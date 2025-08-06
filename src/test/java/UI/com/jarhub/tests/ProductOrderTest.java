package UI.com.jarhub.tests;

import com.jarhub.pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public final class ProductOrderTest extends BaseTest{
    CartPage cartPage=new CartPage();
    LoginTest loginTest=new LoginTest();
    DashBoardPage dashBoardPage=new DashBoardPage();
    ConfirmationPage confirmationPage=new ConfirmationPage();
    private ProductOrderTest(){

    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Product Order Functionality.")
    @Step("Product Order Functionality Test")
    @Test(description = "Verify Product Order Functionality")
    public void productOrderTest() throws Exception {
        loginTest.loginTest();
        dashBoardPage.clickOnAddCartButton("IPHONE 13 PRO");
        Thread.sleep(4000);
        dashBoardPage.clickCartButton();
        Assertions.assertThat(cartPage.getAddedItemText()).describedAs("Added Cart Item Validation")
                .isEqualTo("IPHONE 13 PRO");
        cartPage.clickCheckOutButton().enterCountry().clickPlaceOrder();
        Assertions.assertThat(confirmationPage.getConfirmationText().trim()).describedAs("Order Confirmation Text Validation")
                .isEqualTo("THANKYOU FOR THE ORDER.");
    }

}
