import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class NotificationMessagesTest extends BaseTest {

    @Test
    public void notificationMessages() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
        softAssert.assertEquals(driver.findElement(By.cssSelector("#content > div > h3")).getText(),
                "Notification Message");
        driver.findElement(By.cssSelector("#content > div > p > a")).click();
        softAssert.assertTrue(driver.findElement(By.cssSelector("#flash")).isDisplayed());
        driver.quit();
        softAssert.assertAll();
    }
}
