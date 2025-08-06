package com.jarhub.pages;

import com.jarhub.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class ConfirmationPage extends BasePage{

    private static final By textOrderConfirmation=By.xpath("//h1[contains(text(),'Thankyou for the order.')]");

    public String getConfirmationText()
    {
        return getLabelValue(WaitStrategy.VISIBLE,textOrderConfirmation);
    }
    
}
