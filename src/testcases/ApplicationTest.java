package testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ApplicationTest {
	SoftAssert softAssert=new SoftAssert();
	@BeforeTest
	public void startTest(){
		System.out.println("Starting test..");
	}
	@AfterTest
	public void endTest(){
		System.out.println("Ending the test..");
	}
	@BeforeMethod
	public void beforeMethods(){
		System.out.println("--Before the method--");
	}
	@AfterMethod
	public void afterMethods(){
		System.out.println("--After the method--");
	}
	@Test(priority=1)
	public void doLogin(){
		softAssert=new SoftAssert();
		/*Assert.fail("Stop the test");
		System.out.println("Loggin in");*/
		softAssert.fail("Warning user");
		System.out.println("Logging in...");
		softAssert.assertAll();
	}
	@Test(priority=2)
	public void doPasswordChange(){
		//throw new SkipException("Skipping this test due to invalid user");
		softAssert=new SoftAssert();
		softAssert.assertEquals("ab", "ab");
		System.out.println("Changing the password..");
		softAssert.assertAll();
	}
	@Test(priority=3,dependsOnMethods={"doPasswordChange"})
	public void doLogOut(){
		System.out.println("Logging out..");
	}
	@BeforeSuite
	public void beforeSuiteTest(){
		System.out.println("Before Suite");
	}
	@AfterSuite
	public void afterSuiteTest(){
		System.out.println("After Suite");
	}


}
