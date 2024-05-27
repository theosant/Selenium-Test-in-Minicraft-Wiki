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


class UploadPage extends PageBase {

    private By choseFileButton = By.xpath("//input[@id='wpUploadFile']");
    private By uploadButton = By.xpath("//input[@id='wpUpload']");
    private By textArea = By.xpath("//textarea[@id='wpUploadDescription']");
    
    public UploadPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://minecraft.wiki/w/Special:Upload");
    }    
    
    public UploadPage FilePath(String path){
        this.waitAndReturnElement(choseFileButton).sendKeys(path);
        return this;
    }
    public UploadPage SaveUpload(){
        this.waitAndReturnElement(uploadButton).click();
        return this;
    }
    public UploadPage DescriptionUpload(String text){
        this.waitAndReturnElement(textArea).sendKeys(text);
        return this;
    }

}
