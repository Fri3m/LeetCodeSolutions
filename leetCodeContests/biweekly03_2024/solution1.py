class Solution(object):
    def sumOfEncryptedInt(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        result = 0
        for num in nums:
            digit = 0
            for c in str(num):
                if int(c) > digit:
                    digit = int(c)
            x = 0
            for i in range(len(str(num))):
                x = x * 10 + digit
            result += x
        
        return result
