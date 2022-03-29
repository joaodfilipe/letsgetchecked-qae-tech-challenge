package specs;

import definitions.BrowserSetupSteps;
import locators.MapsPageElements;
import locators.MapsPageLocators;
import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.*;
import java.util.List;

public class MapsPageTests {

    private final BrowserSetupSteps browserSetupSteps = new BrowserSetupSteps();

    public static final String BROWSER = "Chrome"; // (Browsers accepted: "Chrome", "Safari" and "Firefox")
    public static final String URL = "https://www.google.com/maps";
    public static final String LOCATION = "Dublin";
    public static final String STARTING_POINT = "Portugal";
    public static final String ICONIC_PLACE = "Guinness Storehouse";

    public WebDriver getDriver () {
        return browserSetupSteps.getDriver();
    }

    @Rule
    public TestName name = new TestName();

    // METHOD called before each test to initialize the driver and verify if consent page is displayed
    // (@Before annotations are run before each test.)
    @Before
    public void beforeTests() throws Exception {
        try {
            // Initialize and setup browser driver
            browserSetupSteps.setUp(BROWSER);
            // Open given URL
            getDriver().get(URL);

            try
            {
                // Verify if the consent page is displayed and click the "Agree" button
                if(MapsPageElements.element_wait_search_by_locator(getDriver(),MapsPageLocators.CONSENT_IMAGE,2).isDisplayed()){
                    System.out.println("Consent page displayed!");
                    MapsPageElements.element_wait_search_by_locator(getDriver(),MapsPageLocators.CONSENT_AGREE_BUTTON,2).click();
                }
            }
            catch(Exception e) {
                System.out.println("Consent page not displayed!");
            }

        }catch(Exception e){
            System.out.println("Setup browser '" + BROWSER + "' Failed");
            throw e;
        }
    }

    // METHOD called before each test for logging purposes
    // (@Before annotations are run before each test.)
    @Before
    public void beforeTest() {
        System.out.println("Running test #" + name.getMethodName());
    }

    // METHOD called after each test to close the browser/quit driver
    // (@After annotations are run after each test.)
    @After
    public void closeWindow() {
        System.out.println("Shutting down the browser!");
        getDriver().quit();
    }

    // #TEST - Method called to search for a location ("Dublin")
    @Test
    public void searchForLocation () throws Exception{
        try {

            // ASSERTION to verify if the search box is displayed on the page
            Assert.assertTrue(MapsPageElements.element_wait_search_by_locator(getDriver(),MapsPageLocators.SEARCH_BOX,5).isDisplayed());

            // CLICK and WRITE location on search input field
            MapsPageElements.element_wait_search_by_locator(getDriver(), MapsPageLocators.SEARCH_INPUT_FIELD,2).click();
            MapsPageElements.element_wait_search_by_locator(getDriver(), MapsPageLocators.SEARCH_INPUT_FIELD,2).sendKeys(LOCATION);

            // CLICK on the search button
            MapsPageElements.element_wait_search_by_locator(getDriver(),MapsPageLocators.SEARCH_BUTTON,2).click();

            // ASSERTION to verify if the left panel is displayed on the page
            Assert.assertTrue(MapsPageElements.element_wait_search_by_locator(getDriver(),MapsPageLocators.SEARCH_LEFT_PANEL,5).isDisplayed());
            // ASSERTION to verify if the left panel headline contains the correct location ("Dublin")
            Assert.assertTrue(MapsPageElements.element_wait_search_by_locator(getDriver(),MapsPageLocators.SEARCH_LEFT_PANEL_HEADLINE,2).getText().contains(LOCATION));

            try {
                List<WebElement> iconicElements=MapsPageElements.elements_wait_search_by_locator(getDriver(),MapsPageLocators.SEARCH_LEFT_PANEL_ICONIC_PLACES,10);
                // Loop through array and verify if iconic section contains the correct place ("Guinness Storehouse")
                for (WebElement iconicElement : iconicElements) {
                    if (iconicElement.getAttribute("aria-label").contains(ICONIC_PLACE)){
                        System.out.println("Iconic place '" + ICONIC_PLACE + "' is displayed on the section!");
                        break;
                    }
                }
            }catch(Exception e){
            System.out.println("Search for iconic place '" + ICONIC_PLACE + "' Failed");
            throw e;
            }

            // WAIT 1s before ending the test
            Thread.sleep(1000);

        }catch(Exception e){
            System.out.println("Search for '" + LOCATION + "' Failed");
            throw e;
        }
    }

    // #TEST - Method called to get directions for a location ("Dublin")
    @Test
    public void getDirectionsForLocation () throws Exception{
        try {

            // ASSERTION to verify if the search box is displayed on the page
            Assert.assertTrue(MapsPageElements.element_wait_search_by_locator(getDriver(),MapsPageLocators.SEARCH_BOX,5).isDisplayed());

            // CLICK and WRITE location on search input field
            MapsPageElements.element_wait_search_by_locator(getDriver(), MapsPageLocators.SEARCH_INPUT_FIELD,2).click();
            MapsPageElements.element_wait_search_by_locator(getDriver(), MapsPageLocators.SEARCH_INPUT_FIELD,2).sendKeys(LOCATION);

            // CLICK on the search button
            MapsPageElements.element_wait_search_by_locator(getDriver(),MapsPageLocators.DIRECTIONS_BUTTON,2).click();

            // ASSERTION to verify that destination search input contains the correct location ("Dublin")
            Assert.assertTrue(MapsPageElements.element_wait_search_by_locator(getDriver(),MapsPageLocators.DIRECTIONS_DESTINATION_SEARCH_INPUT,5).getAttribute("aria-label").contains(LOCATION));

            // CLICK on the car button
            MapsPageElements.element_wait_search_by_locator(getDriver(),MapsPageLocators.DIRECTIONS_RADIO_CAR_BUTTON,5).click();

            // CLICK and WRITE the starting point on the search input
            MapsPageElements.element_wait_search_by_locator(getDriver(), MapsPageLocators.DIRECTIONS_STARTING_SEARCH_INPUT,2).click();
            MapsPageElements.element_wait_search_by_locator(getDriver(), MapsPageLocators.DIRECTIONS_STARTING_SEARCH_INPUT,2).sendKeys(STARTING_POINT);

            // CLICK on the directions search button
            MapsPageElements.element_wait_search_by_locator(getDriver(),MapsPageLocators.DIRECTIONS_SEARCH_BUTTON,2).click();

            // ASSERTION to verify if the trip section is displayed
            Assert.assertTrue(MapsPageElements.element_wait_search_by_locator(getDriver(),MapsPageLocators.DIRECTIONS_SECTION_TRIP,10).isDisplayed());

            // CLICK on the trip options button and select "km" radio button
            MapsPageElements.element_wait_search_by_locator(getDriver(),MapsPageLocators.DIRECTIONS_TRIP_OPTIONS_BUTTON,5).click();
            MapsPageElements.element_wait_search_by_locator(getDriver(),MapsPageLocators.DIRECTIONS_TRIP_OPTIONS_KM_RADIO,5).click();

            // ASSERTION to verify if the trip fields (time and distance) are displayed
            Assert.assertTrue(MapsPageElements.element_wait_search_by_locator(getDriver(),MapsPageLocators.DIRECTIONS_TRIP_HOURS,10).getText().contains("h"));
            Assert.assertTrue(MapsPageElements.element_wait_search_by_locator(getDriver(),MapsPageLocators.DIRECTIONS_TRIP_DISTANCE,5).getText().contains("km"));

            // WAIT 1s before ending the test
            Thread.sleep(1000);

        }catch(Exception e){
            System.out.println("Get directions for '" + LOCATION + "' from '" + STARTING_POINT + "' Failed");
            throw e;
        }
    }
}