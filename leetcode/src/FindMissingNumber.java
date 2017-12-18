/**
 * Created by griffin on 12/17/17.
 * <p>
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * Example 1
 * <p>
 * Input: [3,0,1]
 * Output: 2
 * Example 2
 * <p>
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * <p>
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class FindMissingNumber {


    public int findMissingNumber(int[] nums) {
        if (nums == null || (nums.length == 1 && nums[0] == 0)) return -1;

        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;

        for(int num : nums)
            actualSum += num;

        return expectedSum - actualSum;
    }
}
