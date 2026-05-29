import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseActions {

    WebDriver driver;

    @BeforeTest
    public void windowTabsTesting(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
            }

    @Test
    public void mouseActionsOne() throws InterruptedException {

        driver.get("https://www.leafground.com/drag.xhtml;jsessionid=node0f7zma04nvc4b12lnk14vnrbfn17088577.node0");

        // 1. Move mouse point to an element operation

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt37"))).perform();
        Thread.sleep(2000);

        actions.moveToElement(driver.findElement(By.id("menuform:j_idt38"))).perform();
        Thread.sleep(2000);

        actions.moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();
        Thread.sleep(2000);

        // 2. drag and drop elements

        WebElement from = driver.findElement(By.id("form:drag"));
        WebElement to = driver.findElement(By.id("form:drop"));

        //actions.clickAndHold(from).moveToElement(to).release(to).perform();    // 1st way

        actions.dragAndDrop(from, to).perform(); // 2nd way

        // 3. slider operation

        WebElement sliderPoint1 = driver.findElement(By.xpath("//div[@id='form:j_idt125']//span[1]"));
        System.out.println("Location of slider point 1 before moving is: " + sliderPoint1.getLocation());
        actions.dragAndDropBy(sliderPoint1, 50, 0).perform();
        System.out.println("Locaion of slider point 1 after moving is: " + sliderPoint1.getLocation());

    }

    @Test
    public void mouseActionsPart2() throws InterruptedException {

        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        WebElement rightClickButtonElement = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

        Actions action1 = new Actions(driver);
        action1.contextClick(rightClickButtonElement).perform();
        driver.findElement(By.xpath("/html/body/ul/li[1]")).click();

        Alert alertPop = driver.switchTo().alert();
        Thread.sleep(2000);
        System.out.println("Alert shows the text as: " + alertPop.getText());
        alertPop.accept();
    }
}
