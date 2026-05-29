import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.List;

public class DropDowns {

    private static final Logger log = LoggerFactory.getLogger(DropDowns.class);
    WebDriver driver;

    @BeforeTest
    public void loadPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void leafgroundDropdownTest() throws InterruptedException {

        driver.get("https://www.leafground.com/select.xhtml");

        // 1.1 ways of selecting values in basic dropdown

        WebElement dropDown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        Thread.sleep(1000);
        select.selectByVisibleText("Playwright");
        Thread.sleep(1000);

        // 1.2 Get the number of dropdown options

        List<WebElement> options = select.getOptions();
        int optionSize = options.size();
        System.out.println("Dropdown list option count is " + optionSize);

          // to print all list options

        for (WebElement element : options){
            System.out.println(element.getText());
        }


        // 1.3 select a option useing sendkeys

        dropDown.sendKeys("Puppeteer");

        // 1.4 selecting option is boostrap dropdown (dropdowns which are developed using div instead of select)

        WebElement secondDropdown = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        secondDropdown.click();

        List<WebElement> listItemsValues = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
        for (WebElement element : listItemsValues){
            String dropdownValue = element.getText();
            if (dropdownValue.equals("USA")){
                element.click();
                System.out.println("Value is clicked");
                break;
            }
        }
    }


    // 2 Google Search - pick a value from suggestions


    @Test
    public void googleSearchDropdown() throws InterruptedException {
        driver.get("https://www.google.com/");
        WebElement searchWord = driver.findElement(By.name("q"));
        searchWord.sendKeys("palitha");
        Thread.sleep(1000);
        List<WebElement> googleSearchList = driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d']"));

        System.out.println(googleSearchList.size());

        for (WebElement element : googleSearchList){
            System.out.println(element.getText());
        }

        for (WebElement element : googleSearchList){
            if (element.getText().equals("Palitha Thewarapperuma")){
                element.click();
                System.out.println("Element is clicked");
                break;

            }
        }
    }
}

