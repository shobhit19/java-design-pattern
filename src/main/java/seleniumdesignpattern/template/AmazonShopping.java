package seleniumdesignpattern.template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonShopping extends ShoppingTemplate{

    private WebDriver driver;
    private WebDriverWait wait;
    private String product;


    @FindBy(id="twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id="nav-search-submit-button")
    private WebElement searchButton;

    @FindBy(className="a-size-medium")
    private WebElement item;

    @FindBy(className = "a-price-whole")
    private WebElement price;

    public AmazonShopping(WebDriver driver,String product){
        this.driver=driver;
        this.product=product;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }
    @Override
    public void launchSite() {
        this.driver.get("https://www.amazon.com/");
    }

    @Override
    public void searchForProduct() {
        this.searchBox.sendKeys(this.product);
        this.searchButton.click();
    }

    @Override
    public void selectProduct() {
        this.wait.until((d) -> this.item.isDisplayed());
        this.item.click();
    }

    @Override
    public void buy() {
        this.wait.until((d)->this.price.isDisplayed());
        System.out.println(this.price.getText());
    }
}
