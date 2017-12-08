import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by griffin on 12/8/17.
 */
public class AreTwoStringsPermutationsTest {

    private AreTwoStringsPermutations areTwoStringsPermutations;

    @Before
    public void setup() {
        areTwoStringsPermutations = new AreTwoStringsPermutations();
    }

    @Test
    public void shouldReturnFalseWhenInputStringsDifferInLength() {
        String firstString = "aStringOfAnyLength";
        String secondString = "aStringOfAnyDifferentLength";

        assertFalse(areTwoStringsPermutations.arePermutations(firstString, secondString));
    }

    @Test
    public void shouldReturnTrueIfStringsAreEqual() {
        String firstString = "anyString";
        String secondString = firstString;
        assertTrue(areTwoStringsPermutations.arePermutations(firstString, secondString));
    }

    @Test
    public void shouldReturnTrueIfStringsArePermutations() {
        String firstString = "anyString";
        String secondString = new StringBuilder(firstString).reverse().toString();
        assertTrue(areTwoStringsPermutations.arePermutations(firstString, secondString));
    }

}