package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

// CLASS WITH THE DEFINITION OF THE ELEMENTS
public class MapsPageElements {

    // ELEMENT - Wait and find element by locator
    public static WebElement element_wait_search_by_locator(WebDriver driver, By locator, int waitTime){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    // ELEMENT - Wait and find an array of elements by locator
    public static List<WebElement> elements_wait_search_by_locator(WebDriver driver, By locator, int waitTime){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        return elements;
    }



}