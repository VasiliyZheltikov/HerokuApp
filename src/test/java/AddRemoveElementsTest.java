import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class AddRemoveElementsTest {

    @Test
    public void addRemoveElements() {
        WebDriver driver = WebDriverSetup.getWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        softAssert.assertEquals(driver.findElement(By.cssSelector("#content > h3")).getText(), "Add/Remove Elements");
        WebElement addButton = driver.findElement(By.cssSelector("#content > div > button"));
        for (int i = 0; i < 2; i++) {
            addButton.click();
        }
        driver.findElement(By.cssSelector("#elements > button")).click();
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        softAssert.assertEquals(deleteButtons.size(), 1);
        driver.quit();
        softAssert.assertAll();
    }
}
