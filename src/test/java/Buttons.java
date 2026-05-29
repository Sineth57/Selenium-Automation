import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;

public class Buttons {

    WebDriver driver;

    @BeforeTest
    public void loadPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml");

    }
    @Test
    public void ButtonTest(){

        // 1. Click and confirm title

        WebElement buttonOne = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']"));
        buttonOne.click();

        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Actual title is same as expected");
        }else{
            System.out.println("Actual title is not same as expected.");
        }

        // Assert.assertEquals(actualTitle, expectedTitle, "Title missmatched");

        driver.navigate().back();

        // 2. Find the position of submit button

        WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xyPoint = getPosition.getLocation();
        int x = xyPoint.getX();
        int y = xyPoint.getY();
        System.out.println("X position is: " + x + " and Y position is: " + y);

        // 3. Find the save button color

        WebElement buttonColor = driver.findElement(By.id("j_idt88:j_idt96"));
        String color = buttonColor.getCssValue("background-color");

        System.out.println("Button color is " + color);

        // 4. Find height and width of the button

        WebElement buttonSize = driver.findElement(By.id("j_idt88:j_idt98"));
        int height = buttonSize.getSize().getHeight();
        int width = buttonSize.getSize().getHeight();
        System.out.println("Button height is: " + height + " and button width is: " + width);

    }
}