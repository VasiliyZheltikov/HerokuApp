import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class CheckboxesTest {

    @Test
    public void Checkboxes() {
        WebDriver driver = WebDriverSetup.getWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        Assert.assertEquals(driver.findElement(By.cssSelector("#content > div > h3")).getText(), "Checkboxes");
        WebElement checkbox1 = driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(1)"));
        WebElement checkbox2 = driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(3)"));
        softAssert.assertFalse(Boolean.parseBoolean(checkbox1.getDomProperty("checked")));
        checkbox1.click();
        softAssert.assertTrue(Boolean.parseBoolean(checkbox1.getDomProperty("checked")));
        softAssert.assertTrue(Boolean.parseBoolean(checkbox2.getDomProperty("checked")));
        checkbox2.click();
        softAssert.assertFalse(Boolean.parseBoolean(checkbox2.getDomProperty("checked")));
        driver.quit();
    }
}
