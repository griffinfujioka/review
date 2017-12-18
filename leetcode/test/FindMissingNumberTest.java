import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by griffin on 12/17/17.
 */
public class FindMissingNumberTest {

    private FindMissingNumber findMissingNumber;

    @Before
    public void setup() {
        findMissingNumber = new FindMissingNumber();
    }

    @Test
    public void shouldReturnNegativeOneWhenInputArrayIsNull() {
        assertEquals(findMissingNumber.findMissingNumber(null), -1);
    }

    @Test
    public void shouldReturnNegativeOneWhenOnlyElementInInputArrayIsZero() {
        int[] nums = {0};
        assertEquals(findMissingNumber.findMissingNumber(nums), -1);
    }

    @Test
    public void shouldReturnMissingNumberForArraySizeThree() {
        int[] nums = {3, 0, 1};
        assertEquals(findMissingNumber.findMissingNumber(nums), 2);
    }
}