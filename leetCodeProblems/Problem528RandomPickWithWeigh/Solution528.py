import random


class Solution(object):

    def __init__(self, w):
        """
        :type w: List[int]
        """
        weights = [0 for i in range(len(w))]
        for x in range(len(w)):
            if x == 0:
                weights[x] = w[x]
            else:
                weights[x] = weights[x-1] + w[x]
        self.weights = weights


    def pickIndex(self):
        """
        :rtype: int
        """
        total = self.weights[-1]
        r = random.randint(1, total)
        left, right = 0, len(self.weights) - 1
        while left < right:
            mid = (left + right) // 2
            if self.weights[mid] < r:
                left = mid + 1
            else:
                right = mid
        return left


obj = Solution([1, 3])
print(obj.pickIndex())
print(obj.pickIndex())
print(obj.pickIndex())
print(obj.pickIndex())
print(obj.pickIndex())
print(obj.pickIndex())
print(obj.pickIndex())
print(obj.pickIndex())
print(obj.pickIndex())
print(obj.pickIndex())
print(obj.pickIndex())
print(obj.pickIndex())
print(obj.pickIndex())
print(obj.pickIndex())
print(obj.pickIndex())
print(obj.pickIndex())

# Your Solution object will be instantiated and called as such:
# obj = Solution(w)
# param_1 = obj.pickIndex()