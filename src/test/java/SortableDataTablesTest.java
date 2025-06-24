import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.TreeMap;

public class SortableDataTablesTest {

    @Test
    public void sortableDataTables() {
        WebDriver driver = WebDriverSetup.getWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://the-internet.herokuapp.com/tables");
        softAssert.assertEquals(driver.findElement(By.cssSelector("#content > div > h3")).getText(), "Data Tables");
        TreeMap<String, String> dataTableTesting = new TreeMap<>();
        CorrectDataTable temp = new CorrectDataTable();
        TreeMap<String, String> correctDataTable = temp.getCorrectDataTable();
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 5; j++) {
                String value = driver.findElement(By.xpath("//*[@id=\"table1\"]" +
                        "/tbody/tr[" + j + "]/td[" + i + "]")).getText();
                dataTableTesting.put("data" + i + j, value);
                softAssert.assertEquals(dataTableTesting.get("data" + i + j), correctDataTable.get("data" + i + j));
            }
        }
        driver.quit();
        softAssert.assertAll();
    }
}
