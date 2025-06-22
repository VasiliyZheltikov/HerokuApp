import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckboxesTest {

    @Test
    public void Checkboxes() {
        WebDriver driver = WebDriverSetup.getWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        Assert.assertFalse(Boolean.parseBoolean(driver.findElement(
                By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(1)")).getDomProperty("checked")));
        driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(1)")).click();
        Assert.assertTrue(Boolean.parseBoolean(driver.findElement(
                By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(1)")).getDomProperty("checked")));
        Assert.assertTrue(Boolean.parseBoolean(driver.findElement(
                By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(3)")).getDomProperty("checked")));
        driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(3)")).click();
        Assert.assertFalse(Boolean.parseBoolean(driver.findElement(
                By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(3)")).getDomProperty("checked")));
        driver.quit();
    }
}
