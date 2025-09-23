// src/main/java/com/jarhub/pages/RegistrationPage.java

package com.jarhub.pages;

import com.jarhub.driver.DriverManager;
import com.jarhub.enums.WaitStrategy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class RegistrationPage extends BasePage {

    private static final By firstName = By.id("firstName");
    private static final By lastName = By.id("lastName");
    private static final By email = By.id("userEmail");
    private static final By phone = By.id("userMobile");
    private static final By occupation = By.cssSelector("select[formcontrolname='occupation']");
    private static final By genderMale = By.cssSelector("input[type='radio'][value='Male']");
    private static final By genderFemale = By.cssSelector("input[type='radio'][value='Female']");
    private static final By password = By.id("userPassword");
    private static final By confirmPassword = By.id("confirmPassword");
    private static final By ageCheckbox = By.cssSelector("input[type='checkbox'][formcontrolname='required']");
    private static final By registerButton = By.id("login");
    private static final By labelSuccessfulMessage = By.id("//h1[text()='Account Created Successfully']");

    public RegistrationPage enterFirstName(String value) throws Exception {
        sendKeys(WaitStrategy.PRESENCE, firstName, value, "First Name");
        return this;
    }

    public RegistrationPage enterLastName(String value) throws Exception {
        sendKeys(WaitStrategy.PRESENCE, lastName, value, "Last Name");
        return this;
    }

    public RegistrationPage enterEmail(String value) throws Exception {
        sendKeys(WaitStrategy.PRESENCE, email, value, "Email");
        return this;
    }

    public RegistrationPage enterPhone(String value) throws Exception {
        sendKeys(WaitStrategy.PRESENCE, phone, value, "Phone");
        return this;
    }

    public RegistrationPage selectOccupation(String occupationText) {
        Select select = new Select(DriverManager.getDriver().findElement(occupation));
        select.selectByVisibleText(occupationText);
        return this;
    }

    public RegistrationPage selectGender(String gender) {
        if ("Male".equalsIgnoreCase(gender)) {
            DriverManager.getDriver().findElement(genderMale).click();
        } else if ("Female".equalsIgnoreCase(gender)) {
            DriverManager.getDriver().findElement(genderFemale).click();
        }
        return this;
    }

    public RegistrationPage enterPassword(String value) throws Exception {
        sendKeys(WaitStrategy.PRESENCE, password, value, "Password");
        return this;
    }

    public RegistrationPage enterConfirmPassword(String value) throws Exception {
        sendKeys(WaitStrategy.PRESENCE, confirmPassword, value, "Confirm Password");
        return this;
    }

    public RegistrationPage checkAgeConfirmation() {
        WebElement checkbox = DriverManager.getDriver().findElement(ageCheckbox);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        return this;
    }

    public void clickRegisterButton() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

        // Wait for button to be present and visible
        WebElement registerButtonLocator = wait.until(ExpectedConditions.presenceOfElementLocated(registerButton));
        wait.until(ExpectedConditions.visibilityOf(registerButtonLocator));

        // Remove overlays if present
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(
                "document.querySelectorAll('[style*=\"z-index\"]').forEach(e => e.style.display='none');"
        );

        // Scroll into view and click using JS
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", registerButtonLocator);
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", registerButtonLocator);
    }
}
