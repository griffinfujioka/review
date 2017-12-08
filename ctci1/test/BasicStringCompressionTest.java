import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by griffin on 12/8/17.
 */
public class BasicStringCompressionTest {

    private BasicStringCompression basicStringCompression;

    @Before
    public void setup() {
        basicStringCompression = new BasicStringCompression();
    }

    @Test
    public void shouldReturnOriginalStringIfCompressedStringIsLongerInLength() {
        String s = "abc";
        assertEquals(s, basicStringCompression.compress(s));
    }

    @Test
    public void shouldReturnCompressedString() {
        String s = "aaabbcccdd";
        String expectedCompressedString = "a3b2c3d2";
        assertEquals(expectedCompressedString, basicStringCompression.compress(s));
    }

}