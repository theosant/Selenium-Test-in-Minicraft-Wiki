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


class MainPage extends PageBase {

    private By footerBy = By.className("mw-footer");
    private By navBy = By.id("mw-navigation");
    private By login = By.xpath("//li[@id='pt-login']/a");
    private By logout = By.xpath("//li[@id='pt-logout']/a");
    private By searchBarBy = By.name("search");
    private By preferencesBy = By.id("pt-preferences");
    private By returnBy = By.xpath("//a[@href='/']");
    
    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://minecraft.wiki/");
    }    
    
    public String getFooterText() {
        return this.waitAndReturnElement(footerBy).getText();
    }
    public String getNavText() {
        return this.waitAndReturnElement(navBy).getText();
    }
    
    public LoginPage clickLoginButton() {
        WebElement loginElement = this.waitAndReturnElement(login);
        loginElement.click();
        return new LoginPage(this.driver);
    }
    public MainPage clickLogoutButton() {
        WebElement logoutElement = this.waitAndReturnElement(logout);
        logoutElement.click();
        this.waitAndReturnElement(returnBy).click();
        return this;
    }
    public PreferencePage gotoPreferences() {
        WebElement preferencesElement = this.waitAndReturnElement(preferencesBy);
        preferencesElement.click();
        return new PreferencePage(this.driver);
    }

    
   
}
