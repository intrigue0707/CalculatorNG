import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.epam.tat.module4.Timeout.sleep;


/**
 * Created by Maryia on 11/30/2015.
 */
public class SimpleOperations extends BaseCalculatorTest {

    private static final double num1 = 0.0;
    private static final double num2 = -0.5;
    private static final double num3 = 222.0;
    private static final double num4 = 555.0;
    private static final long num5 = -100L;
    private static final long num6 = 10000000L;
    private static final long num7 = 0L;
    private static final long num8 = -3456789123L;
    @BeforeMethod
    public void startTest(){
        System.out.println("Start test execution");
    }
    @AfterMethod
    public void finishTest(){
        System.out.println("Finish test execution");
    }
    private Calculator cal = new Calculator();


    @Test(dataProvider = "sumDP")
    public void sumVerifDouble(double num1, double num2, double num3){
        sleep(1);

        Assert.assertEquals(cal.sum(num1, num2), num3, "Incorrect result for sum double");
    }

    @Test(dataProvider = "sumDpLong", dependsOnMethods = "sumVerifDouble")
    public void sumVerifLong(long num1, long num2, long num3){
        sleep(1);
        Assert.assertEquals(cal.sum(num1, num2), num3, "Incorrect result for sum long");
    }

    @Test(dataProvider = "subDp", dependsOnMethods = "sumVerifLong")
    public void subVrifDouble(double num1, double num2, double num3){
        sleep(1);
        Assert.assertEquals(cal.sub(num1, num2), num3, "Incorrect result for sub double");
    }

    @Test(dataProvider = "subDpLong", dependsOnMethods = "subVrifDouble")
    public void subVerifLong(long num1, long num2, long num3){
        Assert.assertEquals(cal.sub(num1, num2), num3, "Incorrect result for sub long");
    }

    @Test(dataProvider = "multDp", dependsOnMethods = "subVerifLong")
    public void multVerifDouble(double num1, double num2, double num3){
        Assert.assertEquals(cal.mult(num1, num2), num3, "Incorrect result for mult double");
    }

    @Test(dataProvider = "multDpLong", dependsOnMethods = "multVerifDouble")
    public void multVerifLong(long num1, long num2, long num3){
        Assert.assertEquals(cal.mult(num1, num2), num3, "Incorrect result for mult double");
    }
    @Test(dataProvider = "divDp", dependsOnMethods = "multVerifLong")
    public void divVerifDouble(double num1, double num2, double num3){
        Assert.assertEquals(cal.mult(num1, num2), num3, "Incorrect result for div double");
    }
    @Test(dataProvider = "divDpLong",dependsOnMethods = "divVerifDouble")
    public void divVerifLong(long num1, long num2, long num3){
        Assert.assertEquals(cal.mult(num1, num2), num3, "Incorrect result for div long");
    }
    @DataProvider
    public Object[][] sumDP() {
        return new Object[][]{
                {num1, num2, num1+num2},
                {num2, num3, num2+num3},
                {num3, num4, num3+num4}};
}
    @DataProvider
    public Object[][] sumDpLong() {
        return new Object[][]{
                {num5, num6, num5+num6},
                {num7, num8, num7+num8},
                };
    }
    @DataProvider
    public Object[][] subDp() {
        return new Object[][]{
                {num2, num3, num2-num3},
                {num3, num4, num3-num4}};
    }
    @DataProvider
    public Object[][] subDpLong() {
        return new Object[][]{
                {num5, num6, num5-num6},
                 {num7, num8, num7-num8}};
    }
    @DataProvider
    public Object[][] multDp() {
        return new Object[][]{
                {num1, num2, num1*num2},
                {num3, num4, num3*num4}};
    }
    @DataProvider
    public Object[][]multDpLong() {
        return new Object[][]{
                {num5, num6, num5*num6},
                {num7, num8, num7*num8}};
    }
    @DataProvider
    public Object[][]divDpLong() {
        return new Object[][]{
                {num6, num7, num6/num7},
                {num5, num8, num5/num8}};
    }
    @DataProvider
    public Object[][] divDp() {
        return new Object[][]{
                {num1, num2, num1/num2},
                };
    }

}