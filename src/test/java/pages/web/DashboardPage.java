package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.common.BasePage;

public class DashboardPage extends BasePage {

    protected DashboardPage(WebDriver driver) {
        super(driver);
    }

    private static final String NAV_MENU_PIM = "(//*[contains(@class, 'main-menu-item--name')])[2]";

    public PIMPage clickOnMenuPIM(){
        keyword.click(By.xpath(NAV_MENU_PIM));
        return new PIMPage(driver);
    }
}
