import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


class PreferencePage extends PageBase {

    private By selectLanguage = By.xpath("//select[@id='ooui-php-25']");
    private By saveButton = By.xpath("//button[@type='submit']//span[@class='oo-ui-labelElement-label']");
    
    public PreferencePage(WebDriver driver) {
        super(driver);
    }    
    
    public PreferencePage selectLanguage(String lang){
        WebElement selectElement = this.waitAndReturnElement(selectLanguage);
        Select select = new Select(selectElement);
        select.selectByValue(lang);
        return this;
    }
    public PreferencePage SavePreferences(){
        this.waitAndReturnElement(saveButton).click();
        return this;
    }

}
