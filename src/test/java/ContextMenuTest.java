import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {

    private String url = "https://the-internet.herokuapp.com/context_menu";
    private By pageObject = By.className("example");
    private By hotSpot = By.id("hot-spot");
    private String alertText = "You selected a context menu";

    @Test
    public void contextMenuTest() {
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject));
        action.contextClick(driver.findElement(hotSpot)).perform();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        softAssert.assertEquals(alert.getText(),
                alertText,
                "Текст уведомления отличается");
        alert.accept();
        softAssert.assertAll();
    }
}
