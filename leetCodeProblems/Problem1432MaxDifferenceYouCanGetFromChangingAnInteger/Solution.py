class Solution(object):
    def maxDiff(self, num):
        """
        :type num: int
        :rtype: int
        """
        numstr = str(num)
        index = 0
        while index < len(numstr) and numstr[index] == '9':
            index += 1
        x1 = numstr[index] if index < len(numstr) else '0'
        index = 0
        while index < len(numstr) and (numstr[index] == '1' or index>0 and numstr[index] == '0'):
            index += 1
        x2 = numstr[index] if index < len(numstr) else '0'
        y = '1' if index == 0 else '0'
        num1 = int(numstr.replace(x1, '9'))
        num2 = int(numstr.replace(x2, y))
        # print(num1, num2)
        return num1 - num2



s = Solution()
print(s.maxDiff(555))  # Output: 888
print(s.maxDiff(123456)) # Output: 820000
print(s.maxDiff(1101057)) # Output: 8808050
