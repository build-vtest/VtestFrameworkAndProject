package com.vtest.reusemethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumWebDriver {

	/**
	 * This method is used get the Web Driver(BROWSER).
	 * 
	 * @param driverType
	 *            is type of the browser
	 * @param ip
	 *            is IP of the HUB machine
	 * @param port
	 *            is Port No on which Node is registered to carry out the test
	 *            execution
	 * @return returns webdriver
	 */

	public static synchronized WebDriver getRemoteWebDriver(String driverType, String ip, String port) throws MalformedURLException {
		WebDriver driver = null;
		DesiredCapabilities capabilities = null;

		String nodeURL = "http://" + ip + ":" + port + "/wd/hub";
		if (driverType != null) {
			if (driverType.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", "");
				capabilities = DesiredCapabilities.internetExplorer();
				driver = new InternetExplorerDriver(capabilities);
				driver.manage().window().maximize();
				/*
				 * capabilities = DesiredCapabilities.internetExplorer();
				 * capabilities.setCapability("requireWindowFocus", false);
				 * capabilities.setCapability("enablePersistentHover",
				 * false);
				 */
			} else if (driverType.equalsIgnoreCase("FireFox") || driverType.equalsIgnoreCase("Mozilla")) {
				
			    System.setProperty("webdriver.gekco.driver", "./src/main/resources/drivers/geckodriver.exe");
				FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference("browser.cache.disk.enable", false);
				profile.setPreference("browser.cache.memory.enable", false);
				profile.setPreference("browser.cache.offline.enable", false);
				profile.setPreference("network.http.use-cache", false);
				capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability(FirefoxDriver.PROFILE, profile);
			} else if (driverType.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
				capabilities = DesiredCapabilities.chrome();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("test-type");
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver=new ChromeDriver();
				
				driver.manage().window().maximize();

			} else if (driverType.equalsIgnoreCase("safari")) {
				capabilities = DesiredCapabilities.safari();
			}
			//driver = new RemoteWebDriver(new URL(nodeURL), capabilities);
			
		}

		return driver;
	}

	public static synchronized WebDriver getLocalWebDriver(String driverType) {
		WebDriver driver = null;
		// DesiredCapabilities capabilities = null;

		if (driverType != null) {
			if (driverType.equalsIgnoreCase("IE")) {
				driver = new InternetExplorerDriver();
			} else if (driverType.equalsIgnoreCase("FireFox")) {
				driver = new FirefoxDriver();
			}

		}

		return driver;
	}

	/**
	 * DRIVER CLOSING METHOD
	 * 
	 * @param driver
	 *            is browser instance
	 */
	public static synchronized void closeWebDriver(WebDriver driver) {
		try {
			driver.quit();
		} catch (WebDriverException e) {
			e.printStackTrace();
			
		}
	}
}
