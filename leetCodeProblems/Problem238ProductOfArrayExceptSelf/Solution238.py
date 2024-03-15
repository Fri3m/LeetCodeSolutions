# 158ms 17.53MB
class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        total = 1
        totalBeforeZero = 1
        zeroCount = 0
        for i in nums:
            if i == 0:
                zeroCount += 1
                if zeroCount > 1:
                    return [0 for x in nums]
            else:
                totalBeforeZero *= i
            total *= i

        result = list()
        for i in nums:
            if i != 0:
                result.append(total / i)
            else:
                result.append(totalBeforeZero)
        return result
