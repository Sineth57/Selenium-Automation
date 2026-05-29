import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ElementsTest {

    @Test
    public void elementLeafGround(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");

        driver.findElement(By.id("name")).sendKeys("Sineth Shashintha");
        driver.findElement(By.id("email")).sendKeys("sineth@gmail.com");
        driver.findElement(By.id("phone")).sendKeys("0712345678");
        driver.findElement(By.id("textarea")).sendKeys("34/a, Pansala para, Nugegoda");

        //this is self learning automation site

    }
}
