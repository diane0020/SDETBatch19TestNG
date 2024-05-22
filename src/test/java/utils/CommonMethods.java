package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class CommonMethods {
    public static WebDriver driver;

    public static WebDriver openBrowserAndLaunchApplication() throws IOException {

        switch (ConfigReader.read("browser")) {
            case "Chrome":
                driver = new ChromeDriver();
                break;

            case "Firefox":
                driver = new FirefoxDriver();
                break;

            case "Edge":
                driver = new EdgeDriver();
                break;

            default:
                throw new RuntimeException("invalid Browser name");
        }
        // implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.manage().window().maximize();
        driver.get(ConfigReader.read("url"));

        return driver;
    }

    public static WebDriver openBrowserAndLaunchApplication(String url) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(url);

        return driver;
    }


    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void selectFromDropDown(WebElement dropDown, int index) {

        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }

    public static void selectFromDropDown(WebElement dropDown, String visibleText) {

        Select select = new Select(dropDown);
        select.selectByVisibleText(visibleText);
    }

    public static void selectFromDropDown(String value, WebElement dropDown) {

        Select select = new Select(dropDown);
        select.selectByValue(value);
    }

    public static void sendText(String text, WebElement element) {
        // clear the element first
        element.clear();

        // send the text to element
        element.sendKeys(text);
    }

    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait;
    }

    public static void waitForElementToBeClicked(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));

    }

    public static void clickTheElement(WebElement element) {
        waitForElementToBeClicked(element);
        element.click();
    }

    //take screenshot
    //checkboxes
    //radiobutton
    //jsclick
}



