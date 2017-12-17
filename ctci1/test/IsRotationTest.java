import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by griffin on 12/15/17.
 */
public class IsRotationTest {

    private IsRotation isRotation;

    @Before
    public void setup() {
        isRotation = new IsRotation();
    }

    @Test
    public void shouldReturnTrueWhenS2IsRotationOfS1() {

        String s1 = "waterbottle", s2 = "erbottlewat";

        assertTrue(isRotation.isRotation(s1, s2));
    }

    @Test
    public void shouldReturnFalseWhenS2IsNotRotationOfS1() {
        String s1 = "aString", s2 = "gritnSa";
        assertFalse(isRotation.isRotation(s1, s2));
    }

    @Test
    public void shouldReturnFalseWhenInputStringsDifferInLength() {
        String s1 = "anyString", s2 = "anyOtherString";
        assertFalse(isRotation.isRotation(s1, s2));
    }

}