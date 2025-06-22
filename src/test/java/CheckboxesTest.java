import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        softAssert.assertEquals(driver.findElement(By.cssSelector("#content > div > h3")).getText(), "Checkboxes");
        WebElement checkbox1 = driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(1)"));
        WebElement checkbox2 = driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(3)"));
        softAssert.assertFalse(checkbox1.isSelected());
        checkbox1.click();
        softAssert.assertTrue(checkbox1.isSelected());
        softAssert.assertTrue(checkbox2.isSelected());
        checkbox2.click();
        softAssert.assertFalse(checkbox2.isSelected());
        driver.quit();
        softAssert.assertAll();
    }
}
