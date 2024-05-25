package class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CommonMethods;

import java.io.IOException;

public class dataProviders {
    public static WebDriver driver;

    // declare the data provider
    @DataProvider(name = "credentials")
    public Object[][] data() {
        Object[][] loginData = {
                {"Admin", "12345", "Invalid credentials"},
                {"ABCD", "Hum@nhrm123", "Invalid credentials"},
                {"Admin", "", "Password cannot be empty"},
                {"", "Hum@nhrm123", "Username cannot be empty"}
        };
        return loginData;
    }

    @BeforeMethod
    public void openBrowser() throws IOException {
        driver = CommonMethods.openBrowserAndLaunchApplication();

    }

    // verify that the correct error message is displayed in case of wrong userName and password
    @Test(dataProvider = "credentials")
    public void loginTest(String userName, String password, String ExpectedErrMsg) {
        CommonMethods.syntaxLogin(userName, password);

        String actualMessage = driver.findElement(By.id("spanMessage")).getText();

        Assert.assertEquals(actualMessage, ExpectedErrMsg);
    }

    @AfterMethod
    public void close() {
        CommonMethods.closeBrowser();
    }

}