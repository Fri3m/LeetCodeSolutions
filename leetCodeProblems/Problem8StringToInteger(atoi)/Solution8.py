#7ms 11.80MB
class Solution(object):
    def myAtoi(self, s):
        """
        :type s: str
        :rtype: int
        """
        result, index = str(), 0

        while index < len(s):
            if s[index] == '-' or s[index] == '+':
                if not (index + 1 < len(s) and s[index + 1].isdigit()):
                    return 0
                if s[index] == '-':
                    result += '-'
                index += 1
                break
            if s[index].isdigit():
                break
            if s[index] != ' ':
                return 0
            index += 1
        while index < len(s):
            if not s[index].isdigit():
                break
            result += s[index]
            index += 1

        if result == "":
            return 0

        return max(min(int(result), 2 ** 31 - 1), -2 ** 31)
