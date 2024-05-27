import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


class ChickenPage extends PageBase {
    private By chickenBy = By.xpath("//img[@class='mw-file-element']");
    private By targetBy = By.xpath("//input[@id='searchInpuaaaat']");
    private By searchBy = By.xpath("//input[@id='searchButton']");
    
    public ChickenPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://minecraft.wiki/w/Chicken");
    }    
    public ChickenPage DragAndDrop(){
        WebElement sourceElement = this.waitAndReturnElement(chickenBy);
        WebElement targetElement = this.waitAndReturnElement(targetBy);
        Actions actions = new Actions(this.driver);
        // Perform drag and drop
        actions.dragAndDrop(sourceElement, targetElement).build().perform();
        System.out.println("One or both elements are not found.");
        return this;
    }
    public ChickenPage Search(){
        this.waitAndReturnElement(searchBy).click();
        return this;
    }
}
