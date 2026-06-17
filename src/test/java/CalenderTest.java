import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class CalenderTest {

    WebDriver driver;

    @BeforeTest
    public void launchBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void selectDate(){

        driver.get("https://jqueryui.com/datepicker/");

        // text box is inside a iframe. so we have to switch to iframe first

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

        // Method 01

        WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
        datePicker.sendKeys("6/8/2026");
    }



    @Test
    public void selectDateMethodTwo(){

        driver.get("https://jqueryui.com/datepicker/");

        // text box is inside a iframe. so we have to switch to iframe first

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

        WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
        datePicker.click();

        while (true){
            String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

            if (actualYear.equals("2026") && actualMonth.equals("October")){
                break;
            }else {
                driver.findElement(By.xpath("//a[@title='Next']")).click();
            }

        }


        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));

        for (WebElement dateElement : allDates){
            if (dateElement.getText().equals("3")){
                dateElement.click();
                break;
            }
        }
    }


    // if we want to reuse this in another places we can create a method to use it whenever we want

    public void selectDate(String year, String month, String date){
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

        WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
        datePicker.click();

        while (true){
            String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

            if (actualYear.equals(year) && actualMonth.equals(month)){
                break;
            }else {
                driver.findElement(By.xpath("//a[@title='Next']")).click();
            }

        }


        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));

        for (WebElement dateElement : allDates){
            if (dateElement.getText().equals(date)){
                dateElement.click();
                break;
            }
        }
    }

}
