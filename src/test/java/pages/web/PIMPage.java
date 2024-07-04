package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.common.BasePage;

import java.util.List;
import java.util.Random;

public class PIMPage extends BasePage {

    protected PIMPage(WebDriver driver) {
        super(driver);
    }

    private static final String BTN_ADD_NEW_EMPLOYEE = "//*[contains(@class, 'oxd-button--secondary')][@type='button']";

    private static final String BTN_SEARCH_EMPLOYEE = "//*[contains(@class, 'oxd-button--secondary')][@type='submit']";

    private static final String TEXTBOX_FIRST_NAME = "//*[contains(@name,'firstName')]";

    private static final String TEXTBOX_MIDDLE_NAME = "//*[contains(@name,'middleName')]";

    private static final String TEXTBOX_LAST_NAME = "//*[contains(@name,'lastName')]";

    private static final String BTN_SAVE_NEW_EMPLOYEE = "//*[contains(@class, 'oxd-button--secondary')][@type='submit']";

    private static final String TEXTBOX_EMPLOYEE_ID = "//*[contains(text(), 'Employee Id')]//following::div[1]//input";

    private static final String NAV_MENU_PIM = "(//*[contains(@class, 'main-menu-item--name')])[2]";

    private static final String DDL_JOB_TITLE = "//*[contains(text(), 'Job Title')]//following::div[1]";

    private static final String JOB_TITLE_OPTIONS = "//div[@role=\"listbox\"]//span";

    public PIMPage addEmployee(String firstName, String middleName, String lastName){
        clickAddNewEmployeeButton();
        inputNewEmployeeName(firstName, middleName, lastName);
        inputNewEmployeeID();
        saveNewEmployeeDetails();
        return this;
    }

    public void searchEmployeeByJobTitle(String jobTitle){
        clickOnMenuPIM();
        selectJobTitle(jobTitle);
        clickSearchEmployeeBtn();
    }

    private void clickSearchEmployeeBtn(){
        keyword.click(By.xpath(BTN_SEARCH_EMPLOYEE));
    }

    private void selectJobTitle(String jobTitle){
        keyword.click(By.xpath(DDL_JOB_TITLE));
        List<WebElement> jobs_list = keyword.findElements(By.xpath(JOB_TITLE_OPTIONS));
        for (WebElement e : jobs_list){
            if (e.getText().equals(jobTitle)){
                e.click();
                break;
            }
        }
    }

    private void clickOnMenuPIM(){
        keyword.click(By.xpath(NAV_MENU_PIM));
    }

    private void clickAddNewEmployeeButton(){
        keyword.click(By.xpath(BTN_ADD_NEW_EMPLOYEE));
    }

    private void inputNewEmployeeName(String firstName, String middleName, String lastName){
        keyword.sendKeys(By.xpath(TEXTBOX_FIRST_NAME),firstName);
        keyword.sendKeys(By.xpath(TEXTBOX_MIDDLE_NAME),middleName);
        keyword.sendKeys(By.xpath(TEXTBOX_LAST_NAME),lastName);
    }

    private void inputNewEmployeeID(){
        keyword.waitUntilElementClickable(By.xpath(TEXTBOX_EMPLOYEE_ID));
        keyword.click(By.xpath(TEXTBOX_EMPLOYEE_ID));
        keyword.clear(By.xpath(TEXTBOX_EMPLOYEE_ID));
        keyword.sendKeys(By.xpath(TEXTBOX_EMPLOYEE_ID),randomNumber());
    }

    private void saveNewEmployeeDetails(){
        keyword.click(By.xpath(BTN_SAVE_NEW_EMPLOYEE));
    }

    private String randomNumber(){
        int Random = (int)(Math.random()*100);
        return Integer.toString(Random);
    }
}
