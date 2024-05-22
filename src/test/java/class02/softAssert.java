package class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.CommonMethods;
import utils.ConfigReader;

import java.io.IOException;

public class softAssert {
    public static WebDriver driver;

    @BeforeMethod
    public void openBrowser() throws IOException {
        driver = CommonMethods.openBrowserAndLaunchApplication();
    }

    @Test
    public void loginVerification() {
        CommonMethods.sendText("Admin1",
                driver.findElement(By.xpath("//input[@name='txtUsername']")));
        CommonMethods.sendText(ConfigReader.read("password"),
                driver.findElement(By.xpath("//input[@id = 'txtPassword']")));
        CommonMethods.clickTheElement(driver.findElement(By.xpath("//input[@name='Submit']")));

        // verify that the Invalid credential error message is present
        String actualMessage = driver.findElement(By.id("spanMessage")).getText();

        Assert.assertEquals(actualMessage, "Invalid credentials");
    }

    @Test
    public void loginBtnStatus() {
        WebElement loginBtn = driver.findElement(By.xpath("//input[@name='Submit']"));
        boolean loginBtnStatus = loginBtn.isDisplayed();
        Assert.assertTrue(loginBtnStatus);

        loginBtnStatus = loginBtn.isEnabled();
        Assert.assertTrue(loginBtnStatus);
    }


    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
