package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Keyword {

    WebDriver driver;

    WebDriverWait wait;

    WebElement element;

    public Keyword(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }

    public WebElement waitUntilElementVisible(By by){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitUntilElementClickable(By by){
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public List<WebElement> findElements(By by){
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void sendKeys(By by, String mess){
        element = waitUntilElementVisible(by);
        element.sendKeys(mess);
    }

    public void sendKeys(By by, Keys key){
        element = waitUntilElementVisible(by);
        element.sendKeys(key);
    }

    public void clear(By by){
        element = waitUntilElementVisible(by);
        element.clear();
    }

    public void click(By by){
        waitUntilElementVisible(by).click();
    }
}
