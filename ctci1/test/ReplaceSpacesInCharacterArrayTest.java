import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by griffin on 12/8/17.
 */
public class ReplaceSpacesInCharacterArrayTest {

    private ReplaceSpacesInCharacterArray replaceSpacesInCharacterArray;

    @Before
    public void setup() {
        replaceSpacesInCharacterArray = new ReplaceSpacesInCharacterArray();
    }

    @Test
    public void shouldReturnCharacterArrayWithSpacesReplacedByEncodedRepresentation() {
        final String stringWithSpaces = "Mr John Smith    ";
        final String stringWithSpacesReplaced = "Mr%20John%20Smith";
        char[] s = replaceSpacesInCharacterArray.replaceSpaces(stringWithSpaces.toCharArray(), 13);
        for(int i = 0; i < s.length; i++) {
            assertEquals(stringWithSpacesReplaced.charAt(i), s[i]);
        }
    }
}