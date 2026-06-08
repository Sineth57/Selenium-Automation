import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class DownloadUploadFiles {

    WebDriver driver;

    @BeforeTest
    public void launchBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void fileDownload() throws InterruptedException {

        driver.get("https://leafground.com/file.xhtml");
        Thread.sleep(2000);

        WebElement basicDownloadBtn = driver.findElement(By.id("j_idt93:j_idt95"));
        basicDownloadBtn.click();
        Thread.sleep(2000);

        // validate whether file is downloaded or not

        File file = new File("C:\\Users\\User St\\Downloads");
        File[] totalFiles = file.listFiles();

        for (File findFile : totalFiles){
            if (findFile.getName().equals("TestLeaf Logo.png")){
                System.out.println("File is downloaded.");
                break;
            }
        }
    }

    // file upload ----------------

    @Test
    public void fileUpload() throws AWTException, InterruptedException {

        driver.get("https://leafground.com/file.xhtml");

        // method 1 - using robot class

        WebElement fileUpload = driver.findElement(By.id("j_idt88:j_idt89"));
        fileUpload.click();

        // windows control begins here------------

        String data = "C:\\Users\\User St\\Downloads\\TestLeaf Logo.png";
        StringSelection selection = new StringSelection(data);

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        Thread.sleep(2000);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(2000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


    }

    @Test
    public void fileUploadMethod2(){

        // method 2 using send keys (applicable only for input type = file in the tag)

        String data2 = "C:\\Users\\User St\\Downloads\\TestLeaf Logo.png";
        WebElement uploadUsingSendKeys = driver.findElement(By.id("j_idt97:j_idt98_input"));
        uploadUsingSendKeys.sendKeys(data2);

    }
}
