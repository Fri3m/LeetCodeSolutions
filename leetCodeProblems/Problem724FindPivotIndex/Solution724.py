class Solution(object):
    def pivotIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        left = 0
        right = sum(nums)
        for i in range(len(nums)):
            x = nums[i]
            right -= x
            if left == right:
                return i
            left += x
        return -1


print(Solution().pivotIndex([2, 1, -1]))
print()
print(Solution().pivotIndex([1, 7, 3, 6, 5, 6]))
print()
print(Solution().pivotIndex([1, 2, 3]))
