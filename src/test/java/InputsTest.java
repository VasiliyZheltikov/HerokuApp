import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Objects;

public class InputsTest extends BaseTest {

    @Test
    public void inputs() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://the-internet.herokuapp.com/inputs");
        softAssert.assertEquals(driver.findElement(By.cssSelector("#content > div > div > h3")).getText(), "Inputs");
        WebElement inputWindow = driver.findElement(By.cssSelector("#content > div > div > div > input[type=number]"));
        inputWindow.sendKeys("Abcdf");
        softAssert.assertTrue(Objects.requireNonNull(inputWindow.getDomProperty("value")).isEmpty());
        inputWindow.sendKeys("!@#$%");
        softAssert.assertTrue(Objects.requireNonNull(inputWindow.getDomProperty("value")).isEmpty());
        int numberSend = 12345;
        inputWindow.sendKeys(Integer.toString(numberSend));
        softAssert.assertEquals(inputWindow.getDomProperty("value"), Integer.toString(numberSend));
        inputWindow.sendKeys(Keys.ARROW_UP);
        numberSend++;
        softAssert.assertEquals(inputWindow.getDomProperty("value"), Integer.toString(numberSend));
        inputWindow.sendKeys(Keys.ARROW_DOWN);
        numberSend--;
        softAssert.assertEquals(inputWindow.getDomProperty("value"), Integer.toString(numberSend));
        driver.quit();
        softAssert.assertAll();
    }
}
