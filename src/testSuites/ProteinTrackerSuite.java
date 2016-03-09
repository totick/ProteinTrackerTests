package testSuites;

import org.junit.runner.*;
import org.junit.runners.*;
import testClasses.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	HelloJUnitTest.class,
	TrackingServiceTests.class
})
/**
 * 
 * @author john
 * Class used to run a testSuite (multiple test classes)
 *
 */
public class ProteinTrackerSuite {

}
