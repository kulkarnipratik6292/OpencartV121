package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver); // Passes driver to parent BasePage class
    }

    // WebElements
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement lnkMyaccount;

    @FindBy(linkText = "Register")
    WebElement lnkRegister;

 // 1. Newly added element for Login Link
    @FindBy(linkText = "Login") // Assuming standard locator based on typical Opencart frameworks
    WebElement lnkLogin;
    
    // Action Methods
    public void clickMyAccount() {
        lnkMyaccount.click();
    }

    public void clickRegister() {
        lnkRegister.click();
    }
    
 // 2. Newly added action method
    public void clickLogin() {
        lnkLogin.click();
    }
}