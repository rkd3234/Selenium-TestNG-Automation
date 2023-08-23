package testrunner;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.DashboardPage;
import page.LoginPage;
import setup.Setup;
import utils.Utils;

public class DashboardTestRunner extends Setup {
    LoginPage loginPage;
    @BeforeTest
    public void doLogin(){
        loginPage=new LoginPage(driver);
        loginPage.doLogin("admin","admin123");
    }
    @Test(description = "Admin can create an employee")
    public void createEmployee() throws InterruptedException {
        DashboardPage dashboardPage=new DashboardPage(driver);
        dashboardPage.menu.get(1).click(); //click on PIM menu
        dashboardPage.button.get(2).click();
        driver.findElement(By.name("firstName")).sendKeys("Test");
        driver.findElement(By.name("lastName")).sendKeys("User");
        driver.findElement(By.className("oxd-switch-input")).click();
        String username="testuser"+ Utils.generateRandomNumber(100,999);
        String password="P@ssword123";
        dashboardPage.txtFields.get(5).sendKeys(username);
        dashboardPage.txtFields.get(6).sendKeys(password);
        dashboardPage.txtFields.get(7).sendKeys(password); //confirm password
        dashboardPage.button.get(1).click();
        Thread.sleep(7000);
        String titleActual= driver.findElements(By.className("orangehrm-main-title")).get(0).getText();
        String titleExpected="Personal Details";

        Assert.assertTrue(titleActual.contains(titleExpected));
    }
}
