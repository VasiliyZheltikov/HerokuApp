import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class DropdownTest {

    @Test
    public void dropdown() {
        WebDriver driver = WebDriverSetup.getWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        softAssert.assertEquals(driver.findElement(By.cssSelector("#content > div > h3")).getText(), "Dropdown List");
        WebElement dropdown = driver.findElement(By.cssSelector("#dropdown"));
        dropdown.click();
        WebElement option1 = driver.findElement(By.cssSelector("#dropdown > option:nth-child(2)"));
        WebElement option2 = driver.findElement(By.cssSelector("#dropdown > option:nth-child(3)"));
        softAssert.assertEquals(option1.getText(), "Option 1");
        softAssert.assertEquals(option2.getText(), "Option 2");
        option1.click();
        softAssert.assertTrue(option1.isSelected());
        softAssert.assertFalse(option2.isSelected());
        dropdown.click();
        option2.click();
        softAssert.assertTrue(option2.isSelected());
        softAssert.assertFalse(option1.isSelected());
        driver.quit();
        softAssert.assertAll();
    }
}
