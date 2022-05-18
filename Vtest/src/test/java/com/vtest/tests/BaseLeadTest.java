package com.vtest.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.vtest.reusemethods.SeleniumWebDriver;
import com.vtest.reusemethods.VideoRecording;

public class BaseLeadTest {
	
	public WebDriver driver;
	public VideoRecording videoRecording;
	
	
	@BeforeTest
	@Parameters({ "nodeIp", "nodePort", "driverType" })
	public void beforeClass( String nodeIp, String nodePort, String driverType) throws Exception {
		videoRecording=new VideoRecording();
		videoRecording.startRecording();
		
		// Get the browser type based on parameter provided
		driver = SeleniumWebDriver.getRemoteWebDriver(driverType, nodeIp, nodePort);
		
	
	}



	@AfterTest()
	public void afterClass() {
		
			try {
				videoRecording.stopRecording();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}

