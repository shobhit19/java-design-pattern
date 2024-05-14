package seleniumdesignpattern.template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EBayShopping extends ShoppingTemplate{
    private WebDriver driver;
    private WebDriverWait wait;
    private String product;

    @FindBy(id="gh-ac")
    private WebElement searchBox;

    @FindBy(id="gh-btn")
    private WebElement searchButton;

    @FindBy(xpath="//div/span[text()='Apple iPhone 8 (Excellent Condition) Factory Unlocked, ATT, TMobile, Verizon GSM']")
    private WebElement item;

    @FindBy(xpath="//span[text()='US $194.99/ea']")
    private WebElement price;

    public EBayShopping(WebDriver driver,String product){
        this.driver=driver;
        this.product=product;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }



    @Override
    public void launchSite() {
        this.driver.get("https://www.ebay.com/");
    }

    @Override
    public void searchForProduct() {
        this.searchBox.sendKeys(this.product);
        this.searchButton.click();
    }

    @Override
    public void selectProduct() {
        this.wait.until((d)->this.item.isDisplayed());
        this.item.click();
    }

    @Override
    public void buy() {
        this.wait.until((d)->this.price.isDisplayed());
        System.out.println(this.price.getText());
    }
}
