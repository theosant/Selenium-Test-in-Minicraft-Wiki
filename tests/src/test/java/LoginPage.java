import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


class LoginPage extends PageBase {

    private By loginInputBy = By.name("wpName");
    private By passwordBy = By.name("wpPassword");
    private By submitBy = By.id("wpLoginAttempt");
    
    public LoginPage(WebDriver driver) {
        super(driver);
    }    
    
    public LoginPage fillLogin(String loginCredentials){
        this.waitAndReturnElement(loginInputBy).sendKeys(loginCredentials);
        return this;
    }
    public LoginPage fillPass(String passCredentials){
        this.waitAndReturnElement(passwordBy).sendKeys(passCredentials);
        return this;
    }
    public MainPage Submit(){
        this.waitAndReturnElement(submitBy).click();
        return new MainPage(this.driver);
    }
}
