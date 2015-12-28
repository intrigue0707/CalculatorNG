import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Maryia on 12/1/2015.
 */
public class TrigOperations {

    private static final double n1 = 0;
    private static final double n2 = 30;
    private static final double n3 = 180.0;
    private static final double n4 = 75.0;
    private static final long n5 = -100L;
    private static final long n6 = 10000000L;
    private static final long n7 = 0L;
    private Calculator cal = new Calculator();
    @Test(dataProvider = "verCos")
    public void cosVerifDouble(double n2,double n1){
        Assert.assertEquals(cal.cos(n2),n1, "Incorrect cos value!");
    }
    @Test(dataProvider = "verSin")
    public void sinVerifDouble(double n1, double n2){
        Assert.assertEquals(cal.sin(n1), n2, "Incorrect sin value!");
    }
    @Test(dataProvider = "verCtg", dependsOnMethods = "tanVerifDouble")
    public void ctgVerifDouble(double n1, double n2){
        Assert.assertEquals(cal.ctg(n1), n2, "Incorrect ctg value!");
    }
    @Test(dataProvider = "verTan", dependsOnMethods = "cosVerifDouble")
    public void tanVerifDouble(double n1, double n2){
        Assert.assertEquals(cal.tg(n1), n2, "Incorrect tg value!");
    }
    @Test(dataProvider = "verSqrt")
    public void sqrtVerifDouble(double n1, double n2){
        Assert.assertEquals(cal.sqrt(n1), n2, "Incorrect sqrt value!");
    }
    @Test(dataProvider = "verPow")
    public void powVerifDouble(double n1, double n2, double n3){
        Assert.assertEquals(cal.pow(n1, n2), n3, "Incorrect pow value!");
    }
    @Test(dataProvider = "verPositive")
    public void isPositiveVer(long n1, boolean n2){
        Assert.assertEquals(cal.isPositive(n1), n2, "Incorrect positive value!");
    }
    @Test(dataProvider = "verNegativ")
    public void isNegativeVer(long n1, boolean n2){
        Assert.assertEquals(cal.isNegative(n1), n2, "Incorrect negative value!");
    }
    @DataProvider
    public Object[][] verCos() {
        return new Object[][]{
                {n1, Math.cos(n1)},
                {n2, Math.cos(n2)}

                };
    }
    @DataProvider
    public Object[][] verSin() {
        return new Object[][]{
                {n1, Math.sin(n1)},
                {n2, Math.sin(n2)},
                {n3, Math.sin(n3)}};
    }
    @DataProvider
    public Object[][] verCtg() {
        return new Object[][]{
                {n1, Math.sin(n1) / Math.cos(n1)},
                {n2, Math.sin(n2) / Math.cos(n2)},
                {n3, Math.sin(n3) / Math.cos(n3)}};
    }
    @DataProvider
    public Object[][] verTan() {
        return new Object[][]{
                {n4, Math.tan(n4)},
                {n2, Math.tan(n2)},
                {n3, Math.tan(n3)}};
    }
    @DataProvider
    public Object[][] verSqrt() {
        return new Object[][]{{n1, Math.sqrt(n1)},
                {n2, Math.sqrt(n2)},
                {n3, Math.sqrt(n3)}};
    }
    @DataProvider
    public Object[][] verPow() {
        return new Object[][]{{n1, n2, Math.pow(n1,n2)},
                {n3, n4, Math.pow(n3, n4)}};
    }

    @DataProvider
    public Object[][] verPositive() {
        return new Object[][]{{n5, false},
                {n6, true},
                {n7, false}};
    }
    @DataProvider
    public Object[][] verNegativ() {
        return new Object[][]{{n5, true},
                {n6, false},
                {n7, false}};
    }
}
