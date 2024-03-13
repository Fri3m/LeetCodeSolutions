# 17ms 11.66MB
class Solution(object):
    def maxFrequencyElements(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_count = 0
        nums.sort()
        first = nums[0]
        current_count = 0

        maxSet = {0, 5}
        maxSet.clear()

        for x in nums:
            if x != first:
                if current_count > max_count:
                    max_count = current_count
                    maxSet.clear()
                    maxSet.add(first)
                elif current_count == max_count:
                    maxSet.add(first)
                current_count = 1
                first = x
            else:
                current_count += 1
        if current_count > max_count:
            max_count = current_count
            maxSet.clear()
            maxSet.add(first)
        elif current_count == max_count:
            maxSet.add(first)
        return len(maxSet) * max_count


print(Solution().maxFrequencyElements([15]))  # [3]
