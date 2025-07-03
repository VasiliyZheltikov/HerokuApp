import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HoversTest {

    @Test
    public void hovers() {
        WebDriver driver = WebDriverSetup.getWebDriver();
        Actions action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://the-internet.herokuapp.com/hovers");
        softAssert.assertEquals(driver.findElement(By.cssSelector("#content > div > h3")).getText(), "Hovers");
        String errorMessage = "Not Found";
        for (int i = 3; i < 6; i++) {
            WebElement user = driver.findElement(By.cssSelector("#content > div > div:nth-child(" + i + ")"));
            String pathToUser = "#content > div > div:nth-child(" + i + ")";
            action.moveToElement(user).build().perform();
            softAssert.assertTrue(driver.findElement(By.cssSelector(pathToUser +
                    " > div")).isDisplayed());
            softAssert.assertEquals(driver.findElement(By.cssSelector(pathToUser +
                    " > div > h5")).getText(), "name: user" + (i - 2));
            driver.findElement(By.cssSelector(pathToUser +
                    " > div > a")).click();
            softAssert.assertEquals(driver.findElement(By.cssSelector("body > h1")).getText(), errorMessage);
            driver.navigate().back();
        }
        driver.quit();
        softAssert.assertAll();
    }
}
