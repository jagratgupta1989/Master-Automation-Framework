package com.jarhub.pages;

import com.jarhub.driver.DriverManager;
import com.jarhub.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class CartPage extends BasePage{

    private static final By labelCartItemAdded=By.xpath("//div[@class='cartSection']/h3");
    private static final By buttonCheckout=By.xpath("//button[text()='Checkout']");



    public String getAddedItemText() {
        return getLabelValue(WaitStrategy.VISIBLE,labelCartItemAdded);
    }
    public PaymentPage clickCheckOutButton() throws Exception {
        click(WaitStrategy.CLICKABLE,buttonCheckout,"CheckOut Button");
        return new PaymentPage();
    }
    
}
