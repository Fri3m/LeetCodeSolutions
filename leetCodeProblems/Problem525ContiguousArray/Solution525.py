

class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        if len(nums) == 0:
            return 0

        total = maximum = 0
        hmap = dict()
        hmap[0] = -1

        for i in range(len(nums)):
            if nums[i] == 0:
                total -= 1
            else:
                total += 1

            if total in hmap:
                if i - hmap[total] > maximum:
                    maximum = i - hmap[total]
            else:
                hmap[total] = i

        return maximum


print(Solution().findMaxLength([0, 1]))  # 2
