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
    public void shouldReturnMissingNumberForArraySizeTwo() {
        int[] nums = {0,2};
        assertEquals(findMissingNumber.findMissingNumber(nums), 1);
    }

    @Test
    public void shouldReturnMissingNumberForArraySizeThree() {
        int[] nums = {3, 0, 1};
        assertEquals(findMissingNumber.findMissingNumber(nums), 2);
    }

    @Test
    public void shouldReturnMissingNumberForArraySizeTwoUsingBruteForceApproach() {
        int[] nums = {0,2};
        assertEquals(findMissingNumber.findMissingNumberBruteForce(nums), 1);
    }

    @Test
    public void shouldReturnMissingNumberForArraySizeThreeUsingBruteForceMethod() {
        int[] nums = {3, 0, 1};
        assertEquals(findMissingNumber.findMissingNumberBruteForce(nums), 2);
    }

    private int[] generateArray(int n) {
        // TODO: If I had more a time, a good thing to do would be to generate an array of size n-1
        // with random numbers 0, 1, 2, ... n dispersed and return the array itself as well as whatever
        // value is missing
        return null;
    }
}