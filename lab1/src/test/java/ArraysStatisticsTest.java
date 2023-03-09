
import org.example.ArraysStatistics;
import org.junit.Assert;
import org.junit.Test;

public class ArraysStatisticsTest {
    @Test
    public void maximumShouldBePositiveNumber() {
        Assert.assertEquals(1, ArraysStatistics.max(new int[]{-10, -5, 1, -
                2, -13}));
    }
    @Test
    public void maxShouldBe1001() {
        Assert.assertEquals(1001, ArraysStatistics.max(new int[]{1000, 500,
                1001, 222, 131}));
    }
    @Test
    public void minShouldBeNegativeNumber() {
        Assert.assertEquals(-13, ArraysStatistics.min(new int[]{-10, -5, 1,
                -2, -13}));
    }
    @Test
    public void minShouldBe131() {
        Assert.assertEquals(131, ArraysStatistics.min(new int[]{1000, 500,
                1001, 222, 131}));
    }
    @Test
    public void avgShouldBeMinusFivePointEight() {
        Assert.assertEquals(-5.8, ArraysStatistics.avg(new int[]{-10, -5,
                1, -2, -13}),0.01);
    }
    @Test
    public void minShouldBe570PointEight() {
        Assert.assertEquals(570.8, ArraysStatistics.avg(new int[]{1000,
                500, 1001, 222, 131}),0.01);
    }
    @Test
    public void sumShouldBeMinus29() {
        Assert.assertEquals(-29, ArraysStatistics.sum(new int[]{-10, -5, 1,
                -2, -13}));
    }
    @Test
    public void sumShouldBe2854() {
        Assert.assertEquals(2854, ArraysStatistics.sum(new int[]{1000, 500,
                1001, 222, 131}));
    }
}