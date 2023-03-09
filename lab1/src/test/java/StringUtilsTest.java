
import org.example.StringUtils;
import org.junit.Assert;
import org.junit.Test;


public class StringUtilsTest {
    @Test
    public void sumShouldBe7() {
        Assert.assertEquals(7, StringUtils.sumNumbers("52"));
    }
    @Test
    public void sumShouldBe28() {
        Assert.assertEquals(28, StringUtils.sumNumbers("1234567"));
    }
    @Test
    public void ItShouldBePalindrome1() {
        Assert.assertTrue(StringUtils.palindrome("Aga"));
    }
    @Test
    public void ItShouldBePalindrome2() {
        Assert.assertTrue(StringUtils.palindrome("A kilku tu klika"));
    }
    @Test
    public void ItShouldNotBePalindrome1() {
        Assert.assertFalse(StringUtils.palindrome("Witam jestem Jacek"));
    }
    @Test
    public void ItShouldNotBePalindrome2() {
        Assert.assertFalse(StringUtils.palindrome("Mam m"));
    }
}