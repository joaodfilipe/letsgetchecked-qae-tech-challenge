package definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class BrowserSetupSteps {

    private static WebDriver driver;

    // METHOD called to initialize the driver instance (according to browser parameter)
    public void setUp(String browser) throws Exception{
        try {

            // Detect the operating system (OS)
            String os = System.getProperty("os.name");

            // Set driver according to browser parameter
            switch (browser.toLowerCase()) {

                // CHROME DRIVER
                case ("chrome"):
                    // Set driver path according to OS
                    if (os.contains("Mac")) {
                        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
                    }
                    else if (os.contains("Windows")) {
                        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
                    }
                    else {
                        throw new Exception("Browser is not supported on this OS!");
                    }
                    // Initialize chrome driver
                    ChromeOptions optionsChr = new ChromeOptions();
                    optionsChr.addArguments("--incognito"); // Always run in incognito mode (clear session)
                    driver = new ChromeDriver(optionsChr);
                    driver.manage().window().maximize();
                    break;

                // SAFARI DRIVER
                case ("safari"):
                    // Set driver path according to OS
                    if (os.contains("Mac")) {
                        // Initialize safari driver (Requirement - Enable "Allow Remote Automation" option in Develop menu)
                        SafariOptions optionsSaf = new SafariOptions();
                        optionsSaf.setCapability("safari.cleanSession", true); // Always run a cleaned session
                        driver = new SafariDriver(optionsSaf);
                        driver.manage().window().maximize();
                    }
                    else {
                        throw new Exception("Browser is not supported on this OS!");
                    }
                    break;

                // FIREFOX DRIVER
                case ("firefox"):
                    // Set driver path according to OS
                    if (os.contains("Mac")) {
                        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
                    }
                    else if (os.contains("Windows")) {
                        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
                    }
                    else {
                        throw new Exception("Browser is not supported on this OS!");
                    }
                    // Initialize gecko driver
                    FirefoxOptions optionsFF = new FirefoxOptions();
                    optionsFF.setCapability("browser.privatebrowsing.autostart", true); // Always run in private mode (clear session)
                    driver = new FirefoxDriver(optionsFF);
                    driver.manage().window().maximize();
                    break;

                default:
                    throw new NotImplementedException();
            }
    }catch(Exception e){
        System.out.println("Browser '" + browser + "' setup Failed");
        throw e;
    }
    }

    // METHOD to return the driver instance
    public WebDriver getDriver() {
        return driver;
    }
}