package testClasses;


import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import testCategories.GoodTestsCategory;

@Category(GoodTestsCategory.class)
public class HelloJUnitTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

}
