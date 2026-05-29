import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class RatioButtons_TextBoxes {

    WebDriver driver;

    @BeforeTest
    public void loadPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void radioTest(){

        // 1. Find the default selected radio button

        driver.get("https://www.leafground.com/radio.xhtml;jsessionid=node09n54n3jigysj1xdy2l64xxf2l16195556.node0");

        boolean chromeRadioOption = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean firefoxRadioOption = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safariRadioOption = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edgeRadioOption = driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if (chromeRadioOption){
            String chromeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println("Default selected radio button is: " + chromeText);
        } else if (firefoxRadioOption) {
            String firefoxText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.println("Default selected radio button is: " + firefoxText);

        } else if (safariRadioOption) {
            String safariText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println("Default selected radio button is: " + safariText);
        } else if (edgeRadioOption) {
            String edgeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
            System.out.println("Default selected radio button is: " + edgeText);
        }

        // 2. Select the age group (only if not already selected)

        WebElement myAgeGroup = driver.findElement(By.id("j_idt87:age:0"));
        boolean isChecked = myAgeGroup.isSelected();

        if (!isChecked){
            driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();
        }

    }

    @Test
    public void checkBoxTest(){

        // 1. Select wanted checkboxes and verify whether they are selected

        driver.get("https://www.leafground.com/checkbox.xhtml");
        List<WebElement> checkBoxList =  driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));

        for (WebElement element : checkBoxList) {
            if (!(element.getText().equals("Others"))){
                element.click();
            }
        }

        // verifying those checkboxes are selected

        for (int i=1; i<= checkBoxList.size(); i++){
            boolean checkBoxStatus = driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)[" +i+ "]")).isSelected();
            System.out.println("CheckBox " + i + " selected status is " + checkBoxStatus);
        }

    }
}
