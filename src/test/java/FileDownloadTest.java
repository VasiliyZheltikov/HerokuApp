import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.File;

public class FileDownloadTest extends BaseTest {

    private String url = "https://the-internet.herokuapp.com/download";
    private By title = By.tagName("h3");
    private By linkToDownload = By.xpath("(//a[contains(@href, 'download')])[1]");

    @Test
    public void downloadTest() throws InterruptedException {
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        String fileNameOnPage = driver
                .findElement(linkToDownload)
                .getText();
        driver.findElement(linkToDownload).click();
        Thread.sleep(5000);
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                if (fileName.matches(fileNameOnPage)) {
                    f = new File(fileName);
                    found = true;
                    break;
                }
            }
        }
        softAssert.assertTrue(found, "Загруженный документ не найден");
        f.deleteOnExit();
        softAssert.assertAll();
    }
}
