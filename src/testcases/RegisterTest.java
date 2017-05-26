package testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegisterTest {
SoftAssert softAssert=new SoftAssert();	
	@Test
	public void doRegisterTest(){
		/*try{
		System.out.println("A");
		Assert.assertEquals("abcd","abcde");
		System.out.println("B");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}*/
		
		System.out.println("A");
		softAssert.assertEquals("ABCD", "EFG");
		softAssert.assertEquals(12, 200);
		System.out.println("B");
		softAssert.assertAll();
	}
	@Test(priority=2)
	public void doFail(){
		Assert.assertEquals(true,false);
	}
	@Test(priority=3)
	public void doSkip(){
		throw new SkipException("Skipped---=====");
	}

}
