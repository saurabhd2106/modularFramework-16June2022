package commonLibs;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonDriver {

	private WebDriver driver;

	private String projectDirectory;

	private int elementDetectionTimeout;

	private int pageloadTimeout;

	public WebDriver getDriver() {
		return driver;
	}

	public CommonDriver(String browserType) throws Exception {

		elementDetectionTimeout = 10;

		pageloadTimeout = 10;

		browserType = browserType.trim();

		projectDirectory = System.getProperty("user.dir");

		if (browserType.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", projectDirectory + "/driver/chromedriver");

			driver = new ChromeDriver();

		} else if (browserType.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", projectDirectory + "/driver/geckodriver");

			driver = new FirefoxDriver();

		} else if (browserType.equalsIgnoreCase("edge")) {

			System.setProperty("webdriver.gecko.driver", projectDirectory + "/driver/MicrosoftWebDriver");

			driver = new EdgeDriver();

		} else {
			throw new Exception("Invalid Broser type" + browserType);
		}

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

	}

	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}

	public void setPageloadTimeout(int pageloadTimeout) {
		this.pageloadTimeout = pageloadTimeout;
	}

	public void navigateToUrl(String url) {

		url = url.trim();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageloadTimeout));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(elementDetectionTimeout));

		driver.get(url);

	}

	public String getTitle() throws Exception {
		return driver.getTitle();
	}

	public String getCurrentUrl() throws Exception {
		return driver.getCurrentUrl();
	}

	public void closeBrowser() throws Exception {

		driver.close();

	}

	public void closeAllBrowser() throws Exception {

		driver.quit();

	}

}
