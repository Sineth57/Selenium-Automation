import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.List;

public class KeyboardActions {

    WebDriver driver;

    @BeforeTest
    public void launchBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void keyboardActionTest1() throws InterruptedException {

        driver.get("https://www.google.com/");
        WebElement googleSearchAction = driver.findElement(By.name("q"));
        googleSearchAction.sendKeys("welcome");

        Actions actions = new Actions(driver);

        //selecting added text by pressing ctrl + a
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

        Thread.sleep(2000);

        actions.keyDown(Keys.SHIFT).sendKeys("writing in capital with shift").perform();

        Thread.sleep(2000);

        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys("I am Sineth").perform();

        // driver.close();

        // Second method-----------

        actions.keyDown(googleSearchAction, Keys.SHIFT).sendKeys("capital letters second method").perform();

    }

    @Test
    public void keyboardActionTest2 () throws InterruptedException {

        driver.get("https://www.leafground.com/list.xhtml");
        Thread.sleep(3000);

        List<WebElement> selectableList = driver.findElements(By.xpath("//ul[@aria-label='From']/li"));
        int size = selectableList.size();
        System.out.println("List item count is: " + size);

        Actions actions = new Actions(driver);

        actions.keyDown(Keys.CONTROL).click(selectableList.get(0))
                .click(selectableList.get(1))
                .click(selectableList.get(2))
                .click(selectableList.get(3))
                .perform();
    }
}
