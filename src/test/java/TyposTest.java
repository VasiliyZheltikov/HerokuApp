import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TyposTest {

    @Test
    public void Typos() {
        WebDriver driver = WebDriverSetup.getWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://the-internet.herokuapp.com/typos");
        softAssert.assertEquals(driver.findElement(By.cssSelector("#content > div > h3")).getText(), "Typos");
        String text = driver.findElement(By.cssSelector("#content > div > p:nth-child(3)")).getText();
        softAssert.assertEquals(text, "Sometimes you'll see a typo, other times you won't.");
        driver.quit();
        softAssert.assertAll();
    }
}
