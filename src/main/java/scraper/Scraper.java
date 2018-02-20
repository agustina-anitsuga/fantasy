package scraper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.openqa.selenium.WebDriver;


public class Scraper {

    private static final String DELIMITER = ";";
    private static final String baseUrl = "https://play.fantasytennisleague.com/player/";
    
    public static void main(String[] args) {
        
        WebDriver driver = null ;
        PrintWriter out = null;
        
        try {
            driver = SeleniumUtils.buildDriver(Browser.CHROME);
            out = new PrintWriter(new BufferedWriter(new FileWriter("players.csv")));
            out.println("id;name;lastName;price");
    
            LoginPage login = new LoginPage(driver);
            login.go("https://fantasytennisleague.com/");
            login.setUsername("adagnino@fibertel.com.ar");
            login.setPassword("hkwe56db");
            login = login.validate();
            
            for (int i = 600; i < 801; i++) {
                
                try {
                    String url = baseUrl + i ;
                    PlayerPage pp = new PlayerPage(driver);
                    pp = pp.go(url) ;
                    String firstName = pp.getPlayerFirstName();
                    String lastName = pp.getPlayerLastName();
                    String price = pp.getPlayerPrice();
                    String data = i + DELIMITER + firstName + DELIMITER + lastName + DELIMITER + price;
                    System.out.println(data);
                    out.println(data);
                    sleep();
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        if(out!=null){
            out.close();
        }
        
        if(driver!=null){
            driver.close();
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            // nothing
        }
    }
}
