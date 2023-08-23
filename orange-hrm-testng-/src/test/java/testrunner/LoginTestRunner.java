package testrunner;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;
import setup.Setup;

public class LoginTestRunner extends Setup {
    LoginPage loginPage;
    @Test(priority = 1)
    public void doLoginWithWrongCreds(){
        loginPage=new LoginPage(driver);
        loginPage.doLogin("admin","wrongpass");
        String messageActual= driver.findElement(By.className("oxd-alert-content-text")).getText();
        String messageExpected="Invalid credentials";
        Assert.assertEquals(messageActual,messageExpected);
    }
    @Test(priority = 2)
    public void doLogin(){
        loginPage=new LoginPage(driver);
        loginPage.doLogin("admin","admin123");
        Assert.assertTrue(driver.findElement(By.className("oxd-userdropdown-img")).isDisplayed());
    }
}
