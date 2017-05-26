package customreports;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestNGMethod;
import org.testng.xml.XmlSuite;

public class CustomReporter implements IReporter{

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

		System.out.println("-----------Inside customreporter-----------");
		
		for(int suiteNum=0;suiteNum<suites.size();suiteNum++){
			ISuite currentSuite=suites.get(suiteNum);
			System.out.println("Test Suite Name-->"+currentSuite.getName());
			//System.out.println(currentSuite.getResults());
			Map<String, ISuiteResult> suiteMapResult=currentSuite.getResults();
			Set<String> suiteKey= suiteMapResult.keySet();
			
			Iterator<String> suiteIterator=suiteKey.iterator();
			while(suiteIterator.hasNext()){
				String testMethodName=suiteIterator.next();
				System.out.println("Test Name-->"+testMethodName);
				ISuiteResult testResult=suiteMapResult.get(testMethodName);
				
				IResultMap failedTest= testResult.getTestContext().getFailedTests();
				IResultMap passedTest= testResult.getTestContext().getPassedTests();
				IResultMap skippedTest= testResult.getTestContext().getSkippedTests();
				System.out.println("Test Method Names-->");
				ITestNGMethod[] alltests= testResult.getTestContext().getAllTestMethods();
				for(int testNum=0;testNum<alltests.length;testNum++){
					//alltests[testNum].
					
					//System.out.println(alltests[testNum].getMethodName());
					
					if(failedTest.getAllMethods().contains(alltests[testNum])){
						System.out.println(alltests[testNum].getMethodName()+" -- FAILED");
					}else if(passedTest.getAllMethods().contains(alltests[testNum])){
						System.out.println(alltests[testNum].getMethodName()+" -- PASSED");	
					}else if(skippedTest.getAllMethods().contains(alltests[testNum])){
						System.out.println(alltests[testNum].getMethodName()+" -- SKIPPED");	
					}
				}
				System.out.println("-------------------------------------");
			}
			
			
			 
		}
	}
	
	

}
