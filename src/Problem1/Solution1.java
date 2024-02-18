package Problem1;

import java.util.Arrays;
import java.util.HashMap;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1().twoSum(new int[]{0, 3, -3, 4, -1}, -1)));
    }

    public int[] twoSum(int[] nums, int target) {
        // Runtime: 2ms , Memory: 45.02mb
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hashMap.containsKey(complement)) {
                return new int[]{hashMap.get(complement), i};
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return new int[]{0, 99};
    }
}


// My old solution this solution has O(n^2) time complexity
class Solution1Old {

    //44ms and 44.7 memory
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i<nums.length-1;i++){
            System.out.println("\ni: "+i);
            for(int j=i+1; j< nums.length;j++){
                System.out.print("-j: "+j);
                if(nums[i]+nums[j] == target){
                    result[0] = i; result[1] = j;
                    return result;
                }
            }
        }
        return new int[]{-1,-1};
    }
}
