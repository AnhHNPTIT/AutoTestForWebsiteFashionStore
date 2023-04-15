package TestSuite;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Initialization;
import Common.Utilities;
import CommonScreen.RegisterScreen;


public class Register extends Initialization{	
	@BeforeClass()
	public void setUpClass() throws Exception{	
		driver = RegisterScreen.openScreen(browser);
	}
	
	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception{	
		Utilities.testID = method.getName();
	}
		
	@Test()
	public void ITS_01_01() throws IOException{
		RegisterScreen.register(driver, "", RegisterScreen.emptyPhoneMsg);
	}	

	
			
	@AfterMethod()  
	public void tearDownMethod(ITestResult result, Method method){
		afterMethod(result, method);
		Utilities.refreshScreen(driver);
	}
	
	@AfterClass()
	public void tearDownClass() throws Exception{	
		Utilities.closeDriver(driver);
	}
}
