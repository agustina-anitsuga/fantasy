package scraper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlayerPage extends Page {

    @FindBy( xpath="//*/div[contains(@class,\"player-profile-top clearfix\")]//*/span[contains(@class,\"name\")]")
    private WebElement firstName;

    @FindBy( xpath="//*/div[contains(@class,\"player-profile-top clearfix\")]//*/span[contains(@class,\"name\")]/strong")
    private WebElement lastName;
    
    @FindBy( xpath="//*/div[contains(@class,\"salary-cell-value text-right\")]")
    private WebElement price;
    
    
    public PlayerPage(WebDriver driver) {
        super(driver);
    }

    public PlayerPage go(String url) {
        driver.get(url);
        return new PlayerPage(driver);
    }

    public String getPlayerFirstName() {
        return firstName.getText().trim();
    }

    public String getPlayerPrice() {
        String tmp = price.getText();
        int index = tmp.indexOf("m");
        return tmp.substring(1,index).trim();
    }

    public String getPlayerLastName() {
        return lastName.getText().trim();
    }

}
