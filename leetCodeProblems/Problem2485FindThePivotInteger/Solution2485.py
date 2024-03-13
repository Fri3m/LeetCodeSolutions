# 17ms 11.50MB
class Solution(object):
    def pivotInteger(self, n):
        """
        :type n: int
        :rtype: int
        """
        l, r = 1, n
        lt, rt = 1, n
        while l < r:
            if lt < rt:
                l += 1
                lt += l
            else:
                r -= 1
                rt += r

        return l if lt == rt else -1


print(Solution().pivotInteger(4))
