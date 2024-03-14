# 198ms 13.12MB
class Solution(object):
    def numSubarraysWithSum(self, nums, goal):
        """
        :type nums: List[int]
        :type goal: int
        :rtype: int
        """

        ones = [-1]

        index = 1
        for i in range(len(nums)):
            if nums[i] == 1:
                ones.append(i)
                index += 1

        ones.append(len(nums))

        print(ones)

        left, result = 1, 0
        right = left + goal - 1

        if goal == 0:
            while left < len(ones):
                result += (ones[left] - ones[left - 1]) * (ones[left] - ones[left - 1] - 1) / 2
                left += 1
            return int(result)

        while right < len(ones) - 1:
            print(left, right, (ones[left] - ones[left - 1]), (ones[right + 1] - ones[right]))
            result += (ones[left] - ones[left - 1]) * (ones[right + 1] - ones[right])
            left += 1
            right += 1

        return result


print(Solution().numSubarraysWithSum([0, 0, 0, 0, 0], 0))
print()
print(Solution().numSubarraysWithSum([1, 0, 1, 0, 1], 2))
