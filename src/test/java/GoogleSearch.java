import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import utils.driver.Driver;
import static org.junit.Assert.assertTrue;

public class GoogleSearch {

    /**
     * Google page url
     */
    private static final String PAGE_URL = "https://www.google.com";

    /**
     * Message for the search button is not present on a google page
     */
    private static final String MESSAGE_SEARCH_BUTTON_PRESENT_FAILED =
            "Verification failed: the search button is not present on a google page";

    /**
     * Locator for search button on a google page
     */
    private final By searchButton = By.name("btnK");

    @Step("Open a google page")
    public void openGooglePage() {
        WebDriver driver = Driver.webDriver;
        driver.get(PAGE_URL);
    }

    @Step("Verify that search button is present on a google page")
    public void isSearchButtonPresent() {
        assertTrue(MESSAGE_SEARCH_BUTTON_PRESENT_FAILED, isElementPresent(searchButton));
    }

    /**
     * Check is element present on a page by locator
     *
     * @param locator By
     * @return boolean
     */
    private boolean isElementPresent(By locator)
    {
        WebDriver driver = Driver.webDriver;
        try
        {
            driver.findElement(locator);
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }
}
