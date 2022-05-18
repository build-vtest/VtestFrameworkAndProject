package com.vtest.tests;
import org.testng.annotations.Test;

public class ConactusTest extends BaseLeadTest {
	

	

	@Test
	public void name()
	{
		driver.get("https://www.vtestcorp.com/");
		System.out.println("Test");
		driver.close();
	}
	
	
	}
