import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextBox {

    WebDriver driver;

    @BeforeTest
    public void loadPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");

    }

    @Test
    public void textBox(){

        // Type your name
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Sineth Shashintha");

        // Append Country to this City.
        WebElement city = driver.findElement(By.id("j_idt88:j_idt91"));
        city.sendKeys("Colombo");

        // Verify whether textbox is disabled
        WebElement disabledBox = driver.findElement(By.id("j_idt88:j_idt93"));

        if (disabledBox.isEnabled()){
            System.out.println("Text box is enabled");
        }else {
            System.out.println("Test box is disabled.");
        }

//        Boolean enabled = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
//        System.out.println("Text box is enabled? " + enabled);


        // Clear the typed text
        WebElement clearText = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt95\"]"));
        clearText.clear();

        //Retrieve the typed text.
        WebElement textRet = driver.findElement(By.id("j_idt88:j_idt97"));
        String retrivedText = textRet.getAttribute("value");
        System.out.println(retrivedText);

        //Type email and Tab. Confirm control moved to next element.
        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("sineth@gmail.com" + Keys.TAB + "Confirmed it moved to the next textbox.");

    }
}
