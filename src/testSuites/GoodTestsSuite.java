package testSuites;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import testCategories.GoodTestsCategory;
import testClasses.HelloJUnitTest;
import testClasses.TrackingServiceTests;

@RunWith(Categories.class)
@IncludeCategory(GoodTestsCategory.class) //Filters the methods which implements the GoodTestsCategory interface
@Suite.SuiteClasses({
	HelloJUnitTest.class,
	TrackingServiceTests.class
})
public class GoodTestsSuite {

}
