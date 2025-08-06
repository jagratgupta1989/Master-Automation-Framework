package com.jarhub.pages;

import com.jarhub.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class PaymentPage extends BasePage{

    private static final By textBoxCountry=By.xpath("//input[@placeholder='Select Country']");
    private static final By listCountry=By.xpath("//section[@class='ta-results list-group ng-star-inserted']/button");
    private static final By buttonPlaceOrder=By.xpath("//a[contains(text(),\"Place Order\")]");

    public PaymentPage enterCountry() throws Exception {
        click(WaitStrategy.CLICKABLE,textBoxCountry,"CountryTexBox");
        sendKeys(WaitStrategy.PRESENCE,textBoxCountry,"India", "CountryTextBoxValue");
        Thread.sleep(1000);
        pressDownKey();
        selectValueFromBootStrapDropdown(listCountry,"India","Dropdownvalue");
        Thread.sleep(2000);
        scrollDown();
        return new PaymentPage();
    }

    public ConfirmationPage clickPlaceOrder() throws Exception {
        click(WaitStrategy.CLICKABLE,buttonPlaceOrder,"Place Order Button");
        return new ConfirmationPage();
    }
    
}
