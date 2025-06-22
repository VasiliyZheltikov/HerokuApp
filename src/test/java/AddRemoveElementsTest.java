import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddRemoveElementsTest {

    @Test
    public void AddRemoveElements() {
        WebDriver driver = WebDriverSetup.getWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Assert.assertEquals(driver.findElement(By.cssSelector("#content > h3")).getText(), "Add/Remove Elements");
        for (int i = 0; i < 2; i++) {
            driver.findElement(By.cssSelector("#content > div > button")).click();
        }
        driver.findElement(By.cssSelector("#elements > button:nth-child(2)")).click();
        Assert.assertTrue(driver.findElements(By.cssSelector("#elements > button:nth-child(2)")).isEmpty());
        driver.quit();
    }
}
