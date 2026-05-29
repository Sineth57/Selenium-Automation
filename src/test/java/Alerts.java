import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Alerts {

    WebDriver driver;

    @BeforeTest
    public void alertTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");
    }

    @Test
    public void alterTest() throws InterruptedException {

        // 01) Alert (Simple Dialog)
        WebElement alertBox = driver.findElement(By.id("j_idt88:j_idt91"));
        alertBox.click();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        alert.accept();

        // 02) Confire dialog
        WebElement confirmBox = driver.findElement(By.id("j_idt88:j_idt93"));
        confirmBox.click();

        Alert alert1 = driver.switchTo().alert();
        Thread.sleep(3000);
        alert1.dismiss();

        // 03) Alert promt dialog
        WebElement promtBox = driver.findElement(By.id("j_idt88:j_idt104"));
        promtBox.click();
        Alert alert2 = driver.switchTo().alert();
        Thread.sleep(3000);

        String alertText = alert2.getText();
        System.out.println("Alert text is: " + alertText);
        alert2.sendKeys("Sineth Shashintha");
        alert2.accept();

    }


}
