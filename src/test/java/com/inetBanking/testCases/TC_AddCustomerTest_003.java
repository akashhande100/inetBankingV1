package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		 
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		addcust.custName("Akash");
		addcust.custgender("male");
		addcust.custdob("01", "03", "97");
		
		Thread.sleep(5000);
		
		logger.info("providing customer details....");
		
		addcust.custaddress("India");
		addcust.custcity("Pune");
		addcust.custstate("MH");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		
		String email = randomeString()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if (res==true) {
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else {
			
			logger.info("test case failed....");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
		
	}
	


}
