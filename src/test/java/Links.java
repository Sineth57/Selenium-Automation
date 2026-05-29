import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Links {

    WebDriver driver;

    @BeforeTest
    public void loadPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");

    }

    @Test
    public void hyperLinksTest(){

        // Take me to dashboard
        WebElement homelink = driver.findElement(By.linkText("Go to Dashboard"));
        homelink.click();
        String dashboardURL = driver.getCurrentUrl();

        driver.navigate().back();

        // Find my destination
        WebElement wheretoGo = driver.findElement(By.partialLinkText("Find the URL without clicking me."));
        String nextpageLink = wheretoGo.getAttribute("href");
        System.out.println("This link is going to: " + nextpageLink);

        // Al I broken?
        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();

        String title = driver.getTitle();
        if (title.contains("404")){
            System.out.println("Link is broken");
        }else {
            System.out.println("Link is not broken");
        }
        driver.navigate().back();

        // Duplicate link
        WebElement duplicateLink = driver.findElement(By.linkText("Go to Dashboard"));
        duplicateLink.click();

        String newDashboardURL = driver.getCurrentUrl();

        if (dashboardURL.contains(newDashboardURL)){
            System.out.println("Page is duplicated");
        }else{
            System.out.println("Page is not duplicated");
        }

        driver.navigate().back();

        // How many links in the pagw?
        List<WebElement> allLinks =  driver.findElements(By.tagName("a"));
        int linkCount = allLinks.size();
        System.out.println("Page link count is: " + linkCount);

        // How many links in the links layout seciton?
        WebElement layoutElement = driver.findElement(By.className("layout-main-content"));
        List<WebElement> layoutlinks =  driver.findElements(By.tagName("a"));
        System.out.println("Layout link count is: " + layoutlinks.size());




    }
}
