import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class IFrames {

    WebDriver driver;

    @BeforeTest
    public void windowTabsTesting(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/frame.xhtml");
    }

    @Test
    public void frameTest(){

        // 1) click me (inside frame)

        driver.switchTo().frame(0);
        WebElement button1 = driver.findElement(By.xpath("//*[@id=\"Click\"]"));
        button1.click();

        String afterClickButtonTEXT = button1.getText();
        System.out.println("Text inside the button after clicking it: " + afterClickButtonTEXT);



        // 2) click me (inside nested frame)

        driver.switchTo().defaultContent(); // into third frame
        driver.switchTo().frame(2); // from third frame to child frame
        driver.switchTo().frame("frame2");

        WebElement button3 = driver.findElement(By.id("Click"));
        button3.click();

        String afterClickNestedButtonTEXT = button3.getText();
        System.out.println("Text inside the button after clicking it: " + afterClickNestedButtonTEXT);

        // 3)  how many frames in this page

        driver.switchTo().defaultContent();

        List<WebElement> getiframetagCount = driver.findElements(By.tagName("iframe"));
        int size = getiframetagCount.size();
        System.out.println("Page's iframe count is: " + size);

        for (WebElement iframeElement : getiframetagCount){
            String frameAttributeValue = iframeElement.getAttribute("src");
            System.out.println("frame src attribute value: " + frameAttributeValue);
        }

    }
}
