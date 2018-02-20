package scraper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    @FindBy( xpath = ".//*[@id=\"loginForm\"]/form/div/div[1]/input" )
    private WebElement userTextField ;

    @FindBy( xpath = ".//*[@id=\"loginForm\"]/form/div/div[2]/input" )
    private WebElement passwordTextField;   
    
    @FindBy( xpath = ".//*[@id=\"loginForm\"]/form/div/div[3]/button" )
    private WebElement loginBtn;
    
    
    
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage go(String url) {
        driver.get(url);
        return new LoginPage(driver);
    }
    
    public void setUsername(String string) {
        //userTextField.clear();
        userTextField.sendKeys(string);
    }

    public void setPassword(String string) {
        //passwordTextField.clear();
        passwordTextField.sendKeys(string);
    }

    public LoginPage validate() {
        loginBtn.click();
        return new LoginPage(driver);
    }
    

}
