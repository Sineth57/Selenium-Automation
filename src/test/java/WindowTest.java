import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowTest {

    WebDriver driver;

    @BeforeTest
    public void windowTabsTesting(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/window.xhtml;jsessionid=node01u2axrya9fi3u1pjphk3av4qz316529006.node0");
    }
    @Test
    public void windowTests() throws InterruptedException {

        // 1) click and confirm new window open


        String oldWindow = driver.getWindowHandle();
        System.out.println("Parent window: " + oldWindow);


        WebElement openButton = driver.findElement(By.xpath("//*[@id=\"j_idt88:new\"]/span"));
        openButton.click();
        Thread.sleep(3000);

        Set<String> handles = driver.getWindowHandles();
        System.out.println("Handles cound: " + handles.size());

        // method 1 - using for each loop

//        for (String newWindow:handles){
//
//            System.out.println(newWindow);
//            driver.switchTo().window(newWindow);
//            System.out.println("Page title is: " + driver.getTitle());
//
//        }
//
//        driver.close();
//
//        driver.switchTo().window(oldWindow);
//
//        WebElement openButton1 = driver.findElement(By.xpath("//*[@id=\"j_idt88:new\"]/span"));
//        boolean openButtonVisibility = openButton1.isDisplayed();
//        System.out.println("Open button visibility: " + openButtonVisibility);


                // method 2 - using list

        List<String> list = new ArrayList<String>(handles); // converting set to list
        if (list.size() > 1){
            driver.switchTo().window(list.get(1));
            System.out.println("Child tab title is: " + driver.getTitle());
            driver.close();
            driver.switchTo().window(oldWindow);
        }

        WebElement openButton1 = driver.findElement(By.xpath("//*[@id=\"j_idt88:new\"]/span"));
        boolean openButtonVisibility = openButton1.isDisplayed();
        System.out.println("Open button visibility: " + openButtonVisibility);



        // 2) find number of open tabs

        WebElement multiWindowButton = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt91\"]"));
        multiWindowButton.click();
        Thread.sleep(3000);

        Set<String> multiWindowSize =   driver.getWindowHandles();
        int windowCount = multiWindowSize.size();
        System.out.println("No of windows opened: " + windowCount);


        // 3) close all windows except primary

        WebElement closeButton = driver.findElement(By.id("j_idt88:j_idt93"));
        closeButton.click();
        Thread.sleep(3000);

        Set<String> newWindowsHandles =   driver.getWindowHandles();
        for (String allWindows: newWindowsHandles) {
            if (!allWindows.equals(oldWindow)) {
                driver.switchTo().window(allWindows);
                driver.close();
            }
        }

    }


}
