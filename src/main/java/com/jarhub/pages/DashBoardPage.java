package com.jarhub.pages;

import com.jarhub.driver.DriverManager;
import com.jarhub.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class DashBoardPage extends BasePage{

    private static final By buttonLogout=By.xpath("//button[text()=\" Sign Out \"]");
    private static final By buttonCart=By.xpath("//button[@routerlink='/dashboard/cart']");


    public void clickOnAddCartButton(String itemName)
    {
        DriverManager.getDriver().findElement(By.xpath("//b[text()='"+itemName+"']/../../button[2]")).click();
    }
    public LoginPage clickLogoutButton() throws Exception {
        validateElementVisibility(buttonLogout);
        click(WaitStrategy.CLICKABLE,buttonLogout,"LogOut Button");
        return new LoginPage();
    }
    public CartPage clickCartButton() throws Exception {
        validateElementEnability(buttonCart);
        click(WaitStrategy.CLICKABLE,buttonCart,"Cart Button");
        return new CartPage();
    }
    
}
