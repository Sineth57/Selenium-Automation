import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class WebTable {

    WebDriver driver;

    @BeforeTest
    public void launchBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @Test
    public void webTableTest() throws InterruptedException {

        //1. How many rows in a table

        int rowCount = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
        System.out.println("Row count is: " + rowCount);

        //2. How many columns in the table

        int columnCount = driver.findElements(By.xpath("//table[@id='productTable']/thead/tr/th")).size();
        System.out.println("Row count is: " + columnCount);

        //3. Retreive specific row/column

        String value = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[3]/td[3]")).getText();
        System.out.println("Specified column / row data: " + value);

        //4. Retreive all data from table

         //rows
        for (int i = 1; i <= rowCount; i++){
            //columns
            for (int j = 1; j < columnCount; j++){
                String tableData = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
                System.out.print(tableData + "  ");

            }
            System.out.println();
        }

        //5. Pring ID and name only

//        for (int i=1; i<=rowCount; i++){
//            String tableID = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[1]")).getText();
//            String tableProductName = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[2]")).getText();
//            System.out.println("Table ID: " + tableID + " Product name: " + tableProductName);
//
//        }

        // 5.1 Find product price, which namae related to prodcut 3

        for (int i=1; i<=rowCount; i++){
            String tableID = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[1]")).getText();
            String tableProductName = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[2]")).getText();
            System.out.println("Table ID: " + tableID + " Product name: " + tableProductName);

            if (tableProductName.equals("Product 3")){
                String productPric = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[3]")).getText();
                System.out.println(tableProductName + " price is: " + productPric);
                break;

            }
        }

        //6. Select all checkboxes

        int pageCount = driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();
        List<WebElement> pages = driver.findElements(By.xpath("//ul[@id='pagination']/li"));

        for (int k=0; k<pageCount; k++){
            pages.get(k).click();
            Thread.sleep(2000);
            for (int i=1; i<=rowCount; i++){

                boolean atb = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[4]/input")).isSelected();
                if (!atb){
                    driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[4]/input")).click();
                    Thread.sleep(2000);
                }


            }
        }

        //7. Select one checkbox

        int tableRW = 1;
        driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+tableRW+"]/td[4]/input")).click();


    }
}
