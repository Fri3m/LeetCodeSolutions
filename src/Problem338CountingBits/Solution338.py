class Solution(object):
    def countBits(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        res = [0]
        power = 0
        left, right = 0, 1
        for i in range(n):
            print(left, right)
            if left == right:
                left = 0
                power += 1
                right = 2 ** power
                res.append(1)
                left += 1
            else:
                res.append(res[left] + 1)
                left += 1
        return res


print(Solution().countBits(5))  # [0, 1, 1, 2, 1, 2]
