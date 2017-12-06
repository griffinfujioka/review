import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by griffin on 12/5/17.
 */
public class AllUniqueCharactersTest {

    private AllUniqueCharacters allUniqueCharacters;

    @Before
    public void setup() {
        allUniqueCharacters = new AllUniqueCharacters();
    }

    @Test
    public void shouldReturnFalseWhenInputStringHasMoreThanTwoHundredFiftySixCharacters() {
        StringBuilder stringBuilder = new StringBuilder(257);
        for(int i = 0; i <= 256; i++) {
            stringBuilder.append("a");
        }
        assertFalse(allUniqueCharacters.hasAllUniqueCharacters(stringBuilder.toString()));
    }

    @Test
    public void shouldReturnFalseWhenInputStringHasDuplicateCharacters() {
        assertFalse(allUniqueCharacters.hasAllUniqueCharacters("aa"));
    }

    @Test
    public void shouldReturnTrueWhenInputHasAllUniqueCharacters() {
        assertTrue(allUniqueCharacters.hasAllUniqueCharacters("abcdefg"));
    }

}