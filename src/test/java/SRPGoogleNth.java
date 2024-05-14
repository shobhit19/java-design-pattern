import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SRPGoogleNth {

    /**
     *
     * @throws InterruptedException
     *
     * Steps of the test case or worflow
     * 1. Launch google
     * 2. Enter the given keyword on the main page
     * 3. Click on the Nth suggestion
     * 4. Enter the given keyword on the Google search page results
     * 5. Click on the Nth suggestion
     * 6. Go to News/Videos/Images
     * 7. Print the search result
     */

    /*
    This has four components
    1. Search area
    2. Search area with results
    3. Widget bar where News is there
    4. Text of the results
     */
    @Test
    public void printSearchResultStatForNthResult() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("BHARAT");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[text()='bharat']/parent::div)[1]")).click();
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("BHARAT");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[text()='bharat']/parent::div)[1]")).click();
        driver.findElement(By.xpath("//span[text()='News']/parent::div")).click();
        System.out.println(driver.findElement(By.id("result-stats")).getText());
        Thread.sleep(5000);
        driver.quit();
    }
}
