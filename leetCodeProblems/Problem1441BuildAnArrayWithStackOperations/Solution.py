class Solution(object):
    def buildArray(self, target, n):
        """
        :type target: List[int]
        :type n: int
        :rtype: List[str]
        """
        target_index = 0
        result = list()
        for i in range(1,n+1):
            if target_index == len(target):
                break
            result.append("Push")
            if target[target_index] != i:
                result.append("Pop")
            else:
                target_index += 1

        return result

s = Solution()
print(s.buildArray([1,3], 3)) # ["Push","Push","Pop","Push"]
print(s.buildArray([1,2,3], 3)) # ["Push","Push","Push"]
print(s.buildArray([1,2], 4)) # ["Push","Push"]