package spotify.Automation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG {
	
	
	@BeforeSuite
	public void userid1() {
		System.out.println("userid1");
	}
	
	@BeforeTest
	public void userid2() {
		System.out.println("userid2");
	}
	
	@BeforeClass
	public void userid3() {
		System.out.println("userid3");
	}
	
	@BeforeMethod
	public void userid4() {
		System.out.println("userid4");
	}
	
	
	@AfterTest
	public void userid5() {
		System.out.println("userid5");
	}
	@AfterClass
	public void userid6() {
		System.out.println("userid6");
	}
	
	@AfterMethod
	public void userid7() {
		System.out.println("userid7");
	}
	
	@AfterSuite
	public void userid8() {
		System.out.println("userid8");
	}
	
	
	@Test(priority=1,enabled=true)
	public void Test1() {
		System.out.println("******Test1******");
	}
	
	
	@Test(dependsOnMethods = "Test1")
		public void Test2() {
			System.out.println("******Test2******");
		
		}
	
	}
	


