class Solution(object):
    def minimumLength(self, s):
        """
        :type s: str
        :rtype: int
        """
        length = len(s)

        l, r = 0, length - 1
        while 1:
            while l < length and s[l] == s[r] and l + 1 < length and s[l] == s[l + 1]:
                l += 1
            while 0 <= r and s[l] == s[r] and r-1 > -1 and s[r] == s[r - 1]:
                r -= 1
            if s[l] == s[r] and l < r:
                l += 1
                r -= 1
            else:
                break

        if l > r and s[l] == s[r]:
            print("l > r and s[l] == s[r]")
            return 0
        elif l == r and s[l] == s[r]:
            print("l == r and s[l] == s[r]")
            return 1
        return r - l + +1


print(Solution().minimumLength("ca"), "\n")  # 2
print(Solution().minimumLength("cabaabac"), "\n")  # 0
print(Solution().minimumLength("aabccabba"), "\n")  # 3
print(Solution().minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"), "\n")  # 1
print(Solution().minimumLength("c"), "\n")  # 1
