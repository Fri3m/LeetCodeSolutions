package Problem268;

import java.util.Arrays;
import java.util.HashSet;

public class Solution268 {
    public static void main(String[] args) {
        Solution268 solution = new Solution268();
        int[] nums = {0,2};
        System.out.println(solution.missingNumber(nums));
    }
    public int missingNumber(int[] nums) {
        // 5ms 45.42 memory
        Arrays.sort(nums);
        int left = 0, right = nums.length-1,mid=(left + right +1 ) / 2;
        while (left <= right) {
            if (nums[mid] == mid) {
                left = mid+1;
            } else {
                right = mid-1;
            }
            mid = (left + right +1 ) / 2;
        }
        return mid;
    }
    public int missingNumber2(int[] nums) {
        // 5ms 45.62 memory
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }
    public int missingNumber3(int[] nums) {
        // 7ms 45.24 memory
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(nums.length - num)) {
                set.remove(nums.length - num);
            } else {
                set.add(num);
            }
        }
        if(set.isEmpty())
            return nums.length/2;
        else if (set.size()==2) {
            set.remove(nums.length/2);
        }
        return nums.length - set.stream().toList().get(0);
    }
}
