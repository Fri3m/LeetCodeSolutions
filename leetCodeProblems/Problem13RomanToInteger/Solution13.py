#19ms 11.62MB
class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        romanDict = {"I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000}
        result = 0
        i = 0
        while i < len(s):
            if i + 1 < len(s) and romanDict[s[i]] < romanDict[s[i + 1]]:
                result += romanDict[s[i + 1]] - romanDict[s[i]]
                i += 2
            else:
                result += romanDict[s[i]]
                i += 1
        return result

print(Solution().romanToInt("III"))  # 3
print(Solution().romanToInt("LVIII"))  # 58