class Solution(object):
    def kidsWithCandies(self, candies, extraCandies):
        """
        :type candies: List[int]
        :type extraCandies: int
        :rtype: List[bool]
        """
        maximum = 0
        result = [True for i in range(len(candies))]
        for i in range(len(candies)):
            # print(result)
            if candies[i] > maximum:
                maximum = candies[i]
            elif candies[i] + extraCandies < maximum:
                result[i] = False
        for i in range(len(candies)):
            if not result[i]:
                continue
            if candies[i] + extraCandies >= maximum:
                result[i] = True
            else:
                result[i] = False
        return result


print(Solution().kidsWithCandies([2, 3, 5, 1, 3], 3))
