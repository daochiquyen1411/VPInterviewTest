package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class DriverFactory {

    private static WebDriver setLocalDriver(String browser) {
        return switch (browser) {
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                yield new FirefoxDriver();
            }
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                yield new ChromeDriver();
            }
            default -> throw new IllegalArgumentException("Unexpected browser: " + browser);
        };
    }

    public static WebDriver getDriver(String browser, String runMode){
        switch (runMode) {
            case "local" -> {
                return setLocalDriver(browser);
            }
            default -> throw new IllegalArgumentException("Unexpected run mode: " + runMode);
        }
    }
}
