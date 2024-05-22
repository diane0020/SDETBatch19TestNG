package class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.CommonMethods;
import utils.ConfigReader;

import java.io.IOException;
import java.time.Duration;

public class task01 {
    // test case 01
    // goto hrms
    // login and verify that user has logged in

    // test case 02
    //goto hrms
    // verify that the login button is present

    public static WebDriver driver;

    @BeforeMethod
    public void openBrowser() throws IOException {
        driver = CommonMethods.openBrowserAndLaunchApplication();
    }


    @Test
    public  void loginVerification(){
        CommonMethods.sendText(ConfigReader.read("userName"),
                driver.findElement(By.xpath("//input[@name='txtUsername']")));
        CommonMethods.sendText(ConfigReader.read("password"),
                driver.findElement(By.xpath("//input[@id = 'txtPassword']")));
        CommonMethods.clickTheElement(driver.findElement(By.xpath("//input[@name='Submit']")));

        System.out.println("I am logged in");
    }

    @Test
    public void loginBtnEnabled(){
        WebElement loginBtn = driver.findElement(By.xpath("//input[@name='Submit']"));

        System.out.println(loginBtn.isEnabled());
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
