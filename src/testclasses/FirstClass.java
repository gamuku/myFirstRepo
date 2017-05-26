package testclasses;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class FirstClass {
	
	@Test
	public void doCalculate(){
		throw new SkipException("skipped!!!!!!!!!!!!!!!!");
	}

}
