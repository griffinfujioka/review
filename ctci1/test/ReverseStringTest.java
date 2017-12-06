import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by griffin on 12/5/17.
 */
public class ReverseStringTest {

    private ReverseString reverseString;

    @Before
    public void setup() {
        reverseString = new ReverseString();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenInputIsNull() {
        reverseString.reverse(null);
    }

    @Test
    public void shouldReturnReversedString() {
        char[] s = "abcd".toCharArray();
        reverseString.reverse(s);
        assertTrue(s[0] == 'd');
        assertTrue(s[1] == 'c');
        assertTrue(s[2] == 'b');
        assertTrue(s[3] == 'a');
    }
}