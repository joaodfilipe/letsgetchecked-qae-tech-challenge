package locators;

import org.openqa.selenium.By;

// CLASS WITH THE DEFINITION OF ALL LOCATORS
public class MapsPageLocators {

    public static final By CONSENT_IMAGE = By.xpath("//*[@class='HLqKFb'][@src='https://www.gstatic.com/ac/cb/scene_cookie_wall_maps_v2.svg']");

    public static final By CONSENT_AGREE_BUTTON = By.xpath("//*[@id='yDmH0d']/c-wiz/div/div/div/div[2]/div[1]/div[4]/form/div/div/button");

    public static final By SEARCH_BOX = By.id("omnibox-singlebox");

    public static final By SEARCH_INPUT_FIELD = By.id("searchboxinput");

    public static final By SEARCH_BUTTON = By.id("searchbox-searchbutton");

    public static final By SEARCH_LEFT_PANEL = By.className("x3AX1-LfntMc-header-title");

    public static final By SEARCH_LEFT_PANEL_HEADLINE = By.className("x3AX1-LfntMc-header-title-ij8cu");

    public static final By SEARCH_LEFT_PANEL_ICONIC_PLACES = By.xpath("//*[@class='xtu1r-K9a4Re-ibnC6b-haAclf']//div[@role='link']");

    public static final By DIRECTIONS_BUTTON = By.id("xoLGzf-T3iPGc");

    public static final By DIRECTIONS_STARTING_SEARCH_INPUT = By.xpath("//*[@id='sb_ifc51']/input");

    public static final By DIRECTIONS_DESTINATION_SEARCH_INPUT = By.xpath("//*[@id='sb_ifc52']/input");

    public static final By DIRECTIONS_RADIO_CAR_BUTTON = By.xpath("//*[@id='omnibox-directions']/div/div[2]/div/div/div[1]/div[2]/button/img");

    public static final By DIRECTIONS_SEARCH_BUTTON = By.xpath("//*[@id='directions-searchbox-0']//button[@jsaction='search;focus:pane.focusTooltip;blur:pane.blurTooltip']");

    public static final By DIRECTIONS_SECTION_TRIP = By.id("section-directions-trip-0");

    public static final By DIRECTIONS_TRIP_OPTIONS_BUTTON = By.xpath("//*[@id='pane']/div/div[1]/div/div/div[2]/button[2]");

    public static final By DIRECTIONS_TRIP_OPTIONS_KM_RADIO = By.xpath("//*[@id='pane']//*[@for='pane.directions-options-units-km']");

    public static final By DIRECTIONS_TRIP_HOURS = By.xpath("//*[@id='section-directions-trip-0']/div/div[1]/div[1]/div[1]/span[1]");

    public static final By DIRECTIONS_TRIP_DISTANCE = By.xpath("//*[@id='section-directions-trip-0']/div/div[1]/div[1]/div[2]/div");
}