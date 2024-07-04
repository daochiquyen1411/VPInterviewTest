package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.common.BasePage;

public class LoginPage extends BasePage {

    public LoginPage (WebDriver driver){
        super(driver);
    }

    private static final String TEXTBOX_USERNAME = "//*[contains(@name,'username')]";

    private static final String TEXTBOX_PASSWORD = "//*[contains(@name,'password')]";

    private static final String BTN_LOGIN = "//*[contains(@class,'login-button')]";

    public DashboardPage login(){
        keyword.sendKeys(By.xpath(TEXTBOX_USERNAME), "Admin");
        keyword.sendKeys(By.xpath(TEXTBOX_PASSWORD), "admin123");
        keyword.click(By.xpath(BTN_LOGIN));
        return new DashboardPage(driver);
    }
}
