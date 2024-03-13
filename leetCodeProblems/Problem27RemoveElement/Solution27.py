# 13ms 11.58MB
class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        length = len(nums)
        i, j, k = 0, 0, length - 1
        while i < length:
            if nums[i] is val:
                print(i, j, k, nums)
                while k > i and nums[k] is val:
                    k -= 1
                if k <= i:
                    j = length - i
                    break
                temp = nums[i]
                nums[i] = nums[k]
                nums[k] = temp
                j += 1
                k -= 1

            i += 1
        return length - j


print(Solution().removeElement([3, 3], 3))
