package testsuite;

import browserfactory.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
@Test
public void userSholdLoginSuccessfullyWithValid(){
        //Enter “standard_user” username
    sendTextToElement(By.xpath("//input[@id='user-name']"),"standard_user");
    //Enter “secret_sauce” password
    sendTextToElement(By.xpath("//input[@id='password']"),"secret_sauce");
    // Click on ‘LOGIN’ button
    clickOnElement(By.xpath("//input[@id='login-button']"));
   //Verify the text “PRODUCTS”
    String expectedText = "Products";
    String actualText = getTextFromElement(By.xpath("//span[@class='title']"));
    Assert.assertEquals("Not navigate to Desktop Page",expectedText,actualText);
}
@Test
public void verifyThatSixProductsAreDisplayedOnPage(){
    //Enter “standard_user” username
    sendTextToElement(By.xpath("//input[@id='user-name']"),"standard_user");
    //Enter “secret_sauce” password
    sendTextToElement(By.xpath("//input[@id='password']"),"secret_sauce");
    // Click on ‘LOGIN’ button
    clickOnElement(By.xpath("//input[@id='login-button']"));
    //Verify that six products are displayed on page
    List<WebElement> productsList = driver.findElements(By.xpath("//div[@class='inventory_list']"));
    List<String> productsListBefore = new ArrayList<>();
    for (WebElement value : productsList) {
        productsListBefore.add(value.getText());
    }

}


    @After
    public void tearDown(){
        closeBrowser();
    }
}
