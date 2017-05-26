package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogInTest {
	
	@Test(dataProvider="getData")
	public void doLoginTest(String username, String password, int mobileNum, String browser){
		
		System.out.println(username+password);
	}
	
	@AfterMethod
	public void afterData(){
		System.out.println("----");
	}
	
	@DataProvider (parallel=true)
	public Object[][] getData(){
		Object[][] data=new Object[3][4];
		//1st row
		data[0][0]="User1";
		data[0][1]="Passw1";
		data[0][2]=12325;
		data[0][3]="Mozilla";
		
		//2nd row
		data[1][0]="User2";
		data[1][1]="Passw2";
		data[1][2]=1532;
		data[1][3]="Chrome";

		//3rd row
		data[2][0]="User3";
		data[2][1]="Passw3";
		data[2][2]=124676;
		data[2][3]="IE";

		return data;
	}

}
