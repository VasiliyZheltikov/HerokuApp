import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest extends BaseTest {

    private By title = By.tagName("h3");
    private File file = new File("src/test/resources/котик.jpg");
    private String urlUpload = "https://the-internet.herokuapp.com/upload";
    private By chooseFileButton = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedFileName = By.id("uploaded-files");
    private String uploadingFileName = "котик.jpg";

    @Test
    public void fileUploadTest() {
        driver.get(urlUpload);
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        driver.findElement(chooseFileButton).sendKeys(file.getAbsolutePath());
        driver.findElement(uploadButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        Assert.assertEquals(driver.findElement(uploadedFileName).getText(),
                uploadingFileName,
                "Название загруженного файла не указано или неверно");
    }
}
