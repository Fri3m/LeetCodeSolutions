package Problem4MedianOfTwoSortedArrays;

public class Solution4 {
    public static void main(String[] args) {
        Solution4 sol = new Solution4();
        int[] nums = {1,2,3,4,6,7,8,9,10};
        System.out.println(sol.binarySearch(nums, 0, nums.length-1, 4));
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));
        int[] nums3 = {1,2};
        int[] nums4 = {3,4};
        System.out.println(sol.findMedianSortedArrays(nums3, nums4));
        int[] nums5 = {0,0};
        int[] nums6 = {0,0};
        System.out.println(sol.findMedianSortedArrays(nums5, nums6));
        int[] nums7 = {};
        int[] nums8 = {1};
        System.out.println(sol.findMedianSortedArrays(nums7, nums8));
        int[] nums9 = {2};
        int[] nums10 = {};
        System.out.println(sol.findMedianSortedArrays(nums9, nums10));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int a = (nums1.length + nums2.length) / 2;
        int start1= 0, start2 = 0, end1 = nums1.length, end2 = nums2.length;
        while(true){
            if(end1 - start1 == 1 && end2 - start2 == 1){
                break;
            }
            if(end1 - start1 == 1){
                start2 += (end2 - start2) / 2;
                end2 -= (end2 - start2) / 2;
                continue;
            }
            if(end2 - start2 == 1){
                start1 += (end1 - start1) / 2;
                end1 -= (end1 - start1) / 2;
                continue;
            }
            int mid1 = (start1 + end1) / 2;
            int mid2 = (start2 + end2) / 2;
            if(nums1[mid1] < nums2[mid2]){
                start1 = mid1;
                end2 = mid2;
            }
            else{
                start2 = mid2;
                end1 = mid1;
            }
        }


        return 1;
    }
    private int binarySearch(int arr[], int l, int r, int x){
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);
        }
        return l;

    }
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        /*
        2ms 45.82 memory
        Time complexity: O(n+m).
        I didn't find any way to make it O(log(n+m)).
        It should be using binary search, but I couldn't figure it out.
         */
        int[] merged = new int[nums1.length + nums2.length];
        for (int i = 0,arr1=0,arr2=0; i <merged.length ; i++) {
            if(arr1 == nums1.length){
                merged[i] = nums2[arr2];
                arr2++;
            }
            else if(arr2 == nums2.length){
                merged[i] = nums1[arr1];
                arr1++;
            }
            else if (nums1[arr1] < nums2[arr2]){
                merged[i] = nums1[arr1];
                arr1++;
            }
            else{
                merged[i] = nums2[arr2];
                arr2++;
            }
        }
        if(merged.length % 2 == 0){
            return (merged[merged.length/2] + merged[merged.length/2 - 1]) / 2.0;
        }
        else{
            return merged[merged.length/2];
        }
    }
}
