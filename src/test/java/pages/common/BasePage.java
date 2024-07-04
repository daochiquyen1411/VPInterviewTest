package pages.common;

import keywords.Keyword;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;

    protected Keyword keyword;

    protected BasePage(WebDriver driver){
        this.driver = driver;
        keyword = new Keyword(this.driver);
    }
}
