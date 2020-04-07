package demo;

import junit.framework.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

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
//        Assert.assertEquals(5,total);
    }

    @Test
    public void firstNamesShallNotHaveLetterY() {
        List<Map<String, String>> lines = Singleton.getSingleton().getLines();
        for (Map<String, String> line: lines) {
            String firstName = line.get("FIRSTNAME");
            if (firstName.indexOf('Y') >= 0) {
                String fancyMessage=String.format("First name '%s' has a 'Y' in it.  This is forbidden.  Line number %s",
                        firstName, line.get(Hello.LINE_NUMBER));
                Assert.assertTrue(fancyMessage, firstName.indexOf('Y') < 0);
            }
        }
    }
}
