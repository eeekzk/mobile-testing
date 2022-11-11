package data;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider
    public static Object[][] getData() { return new Object[][] {{"IKEA", "Sofa", "123", "1", "Bedroom","Edit"}}; }
}
