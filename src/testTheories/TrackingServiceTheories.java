package testTheories;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import org.junit.Assume;

import classes.TrackingService;

@RunWith(Theories.class)
public class TrackingServiceTheories {
	
	@DataPoints
	public static int[] data(){
		return new int[] {
			1, 5, 10, 15, 20, 50, -4	
		};
	}

	@Theory
	public void positiveValuesShouldAlwaysHavePrositiveTotals(int value){
		TrackingService service = new TrackingService(); //New instance for every test value
		service.addProtein(value);
		
		Assume.assumeTrue(value > 0); //Skips to test negative values e.g -4
		
		assertTrue(service.getTotal() > 0);
	}
}
