import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.Cookie;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import java.util.*;  

import java.net.URL;
import java.net.MalformedURLException;

@RunWith(Parameterized.class)
public class FirstSeleniumTest {
    public WebDriver driver;
    
    @Parameterized.Parameter(0)
    public String login;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {"Theomsantos"},
            {"Elte"}
        });
    }


    @Before
    public void setup()  throws MalformedURLException  {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito","--start-maximized","--test_output all");
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
    }
    
    @Test
    public void testLogin() {
        MainPage mainPage = new MainPage(this.driver);

        Cookie themecookie = new Cookie.Builder("theme", "dark")
        .domain("minecraft.wiki")
        .path("/")
        .build();
        driver.manage().addCookie(themecookie);
        driver.navigate().refresh();

        Assert.assertTrue(mainPage.getBodyText().contains("Welcome"));
        LoginPage loginPage = mainPage.clickLoginButton();
        mainPage = loginPage.fillLogin(login).fillPass("elte2024").Submit();
        Assert.assertTrue(mainPage.getTitle().contains("The Minecraft Wiki"));
        mainPage.clickLogoutButton();
    }
    @Test
    public void testLoginAndSendAForm() {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.clickLoginButton();
        mainPage = loginPage.fillLogin(login).fillPass("elte2024").Submit();
        PreferencePage preferencePage = mainPage.gotoPreferences();
        Assert.assertTrue(mainPage.getTitle().contains("Preferences"));
        preferencePage.selectLanguage("pt-br").SavePreferences();
        Assert.assertTrue(mainPage.getTitle().contains("Preferências"));
    }

    @Test
    public void testChickenDragAndDrop() {
        ChickenPage chickenPage = new ChickenPage(this.driver);
        chickenPage.DragAndDrop().Search();
        Assert.assertTrue(chickenPage.getTitle().contains("Search"));
    }
    
    @Test
    public void testUploadPage() {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.clickLoginButton();
        mainPage = loginPage.fillLogin("Theomsantos").fillPass("elte2024").Submit();
        UploadPage uploadPage = new UploadPage(this.driver);
        uploadPage.FilePath("tests/venomskinminecraft.jpg").DescriptionUpload("VenomExtremeSkin").SaveUpload();
        Assert.assertTrue(uploadPage.getTitle().contains("File:Venomskinminecraft.jpg"));
    }
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
