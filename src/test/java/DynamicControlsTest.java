import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest {

    private String url = "https://the-internet.herokuapp.com/dynamic_controls";
    private By pageObject = By.className("example");
    private By removeButton = By.xpath("//form[@id='checkbox-example']/descendant::button");
    private By message= By.id("message");
    private By checkbox = By.id("checkbox");
    private By inputField = By.tagName("Input");
    private By enableButton = By.xpath("//form[@id='input-example']/descendant::button");

    @Test
    public void dynamicControlTest() {
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject));
        driver.findElement(removeButton).click();
        wait.until(ExpectedConditions.textToBe(message, "It's gone!"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkbox));
        softAssert.assertFalse(driver.findElement(inputField).isEnabled());
        driver.findElement(enableButton).click();
        wait.until(ExpectedConditions.textToBe(message, "It's enabled!"));
        softAssert.assertTrue(driver.findElement(inputField).isEnabled());
        softAssert.assertAll();
    }
}
