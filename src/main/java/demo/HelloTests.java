package demo;

import junit.framework.Assert;
import org.junit.Test;

public class HelloTests {
    
    @Test
    public void whenThisThenThat() {
        // given two numbers
        int a = 2;
        int b=2;
        // when we add them
        int total = a + b;
        // then the total is four
        Assert.assertEquals(4,total);
        // Assert.assertEquals(5,total);
    }
}
