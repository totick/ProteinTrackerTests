package testClasses;

import org.junit.*;

import classes.TrackingService;
import exceptions.InvalidGoalException;

import static org.junit.Assert.*;



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
	public void newTrackingServiceTotalIsZero(){
		assertEquals("Tracking service total was not zero", 0, service.getTotal());
	}
	
	@Test
	public void whenAddingProteinTotalIncreasesByThatAmount(){
		service.addProtein(10);
		assertEquals("Protein amount was not correct", 10, service.getTotal());
	}
	
	@Test
	public void whenRemovingProteinTotalRemainsZero(){
		service.removeProtein(5);
		assertEquals("Tracking service total was not zero", 0, service.getTotal());
	}
	
	//The test method expects that an exception is going be thrown
	@Test(expected = InvalidGoalException.class)
	public void whenGoalIsSetToLessThanZeroExceptionIsThrown() throws InvalidGoalException{
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
