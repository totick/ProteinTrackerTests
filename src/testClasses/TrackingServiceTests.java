package testClasses;

//For advanced Assertions
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

import classes.TrackingService;
import exceptions.InvalidGoalException;
import testCategories.GoodTestsCategory;



public class TrackingServiceTests {
	
	private TrackingService service;
	
	//Gets invoked before class, method must be static
	@BeforeClass
	public static void beforeClass(){
		System.out.println("Before class");
	}
	
	//Gets invoked after class, method must be static
	@AfterClass
	public static void afterClass(){
		System.out.println("After class");
	}
	
	//Gets invoked before every Test method
	@Before
	public void setUp(){
		System.out.println("Before test method");
		service = new TrackingService();
	}
	
	//Gets invoked after every Test method
	@After
	public void tearDown(){
		System.out.println("After test method");
	}

	@Test
	@Category(GoodTestsCategory.class)
	public void newTrackingServiceTotalIsZero(){
		assertEquals("Tracking service total was not zero", 0, service.getTotal());
	}
	
	@Test
	@Category(GoodTestsCategory.class)
	public void whenAddingProteinTotalIncreasesByThatAmount(){
		service.addProtein(10);
		assertEquals("Protein amount was not correct", 10, service.getTotal());
		assertThat(service.getTotal(), is(10)); //Same as above but easier to read.
		assertThat(service.getTotal(), allOf(is(10), instanceOf(Integer.class))); //Tests multiple conditions.
	}
	
	@Test
	@Category(GoodTestsCategory.class)
	public void whenRemovingProteinTotalRemainsZero(){
		service.removeProtein(5);
		assertEquals("Tracking service total was not zero", 0, service.getTotal());
	}
	
	//The test method expects that an exception is going be thrown
	@Test(expected = InvalidGoalException.class)
	public void whenGoalIsSetToLessThanZeroExceptionIsThrown() throws InvalidGoalException{
		service.setGoal(-5);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	//Test method that checks if and specific exception is thrown and that the expected message matches.
	//Uses the rule above
	@Test
	public void whenGoalIsSetToLessThanZeroExceptionIsThrownWithRule() throws InvalidGoalException{
		thrown.expect(InvalidGoalException.class);
		thrown.expectMessage(containsString("Goal"));
		//thrown.expectMessage("Goal was less than zero"); //Exact string match
		service.setGoal(-5);
	}
	
	//The test method must finish before the timeout constraint (in milliseconds)
	@Test(timeout = 200)
	@Ignore //Skips running this method
	public void badTest(){
		for (int i = 0; i < 10000000; i++) {
			service.addProtein(1);
		}
	}
}
