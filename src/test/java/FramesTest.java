import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {

    private String url = "https://the-internet.herokuapp.com/frames";
    private By title = By.tagName("h3");
    private By iFrameLink = By.cssSelector("[href$=\"iframe\"]");
    private By closeNotification = By.cssSelector(".tox-notification__dismiss." +
            "tox-button.tox-button--naked.tox-button--icon");

    @Test
    public void framesTest() {
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        driver.findElement(iFrameLink).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        driver.findElement(closeNotification).click();
        driver.switchTo().frame("mce_0_ifr");
        Assert.assertEquals(driver.findElement(By.id("tinymce")).getText(),
                "Your content goes here.",
                "Текст не соответствует ожидаемому");
    }
}
