class Solution(object):
    def minimizeStringValue(self, s):
        """
        :type s: str
        :rtype: str
        """

        abc = [0 for _ in range(26)]

        totalQuestionMarks = 0
        for i in s:
            if i != "?":
                abc[ord(i) - 97] += 1
            else:
                totalQuestionMarks += 1
        # print(abc)

        minimum = min(abc)
        add = list(0 for _ in range(26))
        while totalQuestionMarks > 0:
            for i in range(26):
                if totalQuestionMarks == 0:
                    break
                if abc[i] == minimum:
                    add[i] += 1
                    abc[i] += 1
                    totalQuestionMarks -= 1
            minimum = min(abc)

        index = 0
        # print(add)
        # print(abc)
        result = ""
        for i in range(len(s)):
            if s[i] == "?":
                while add[index] == 0:
                    index += 1
                result += chr(index + 97)
                add[index] -= 1
                abc[index] += 1
            else:
                result += s[i]

        # print(add)
        # print(abc)
        return result


print(Solution().minimizeStringValue("?aa"))
print(Solution().minimizeStringValue("fd????c?mkhfk?to?l??fgzkkup???qtia"))  # "fdabbecjmkhfkntorlsvfgzkkupwxyqtia"
