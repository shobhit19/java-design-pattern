package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public final class Driver {
    static WebDriver driver;
    private Driver(){

    }

    public static WebDriver getDriver(){
        if(Objects.isNull(driver)) {
            driver = new ChromeDriver();
        }
        return driver;
    }
}
