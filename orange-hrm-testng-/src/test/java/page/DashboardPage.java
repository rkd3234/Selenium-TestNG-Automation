package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {
    @FindBy(className = "oxd-main-menu-item--name")
    public List<WebElement> menu;
    @FindBy(className = "oxd-button")
    public List<WebElement> button;
    @FindBy(className = "oxd-input")
    public List<WebElement> txtFields;

    public DashboardPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
