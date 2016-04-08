package testClasses;


import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import testCategories.GoodTestsCategory;

@Category(GoodTestsCategory.class)
@RunWith(JUnitParamsRunner.class)
public class HelloJUnitTest {

	@Test
	@Parameters(method = "getValues")
	public void test(String theValue) {
		System.out.println(theValue);
		assertTrue(true);
	}
	
	@Test
	public void test2(){
		System.out.println("hej");
		assertTrue(true);
	}
	
	private String[] getValues(){
		return new String[]{"hej", "då"};
	}

}
