import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class BrokenImages {

    WebDriver driver;

    @BeforeTest
    public void launchingBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void findBrokenImages(){
        driver.get("https://the-internet.herokuapp.com/broken_images");

        List<WebElement> images = driver.findElements(By.xpath("//div[@class='example']//img"));

        // if the natural width if any image is 0, then it is a broken image

        int i = 1;
        for (WebElement image : images){
            if (image.getAttribute("naturalWidth").equals("0")){
                System.out.println("Image " + i + " is broken");
            }else {
                System.out.println("Image " + i + " is not broken");
            }
            i++;
        }

    }
}
