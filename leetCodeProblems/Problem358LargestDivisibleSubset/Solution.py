class Solution(object):
    def largestDivisibleSubset(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        solutions = list()
        nums.sort()
        result = list()


        for i in range(len(nums)):
            solutions.append([nums[i]])
            for j in range(i - 1, -1, -1):
                if nums[i] % nums[j] == 0:
                    if len(solutions[j]) + 1 > len(solutions[i]):
                        solutions[i] = solutions[j] + [nums[i]]
                        if result[-1] == solutions[j][-1]:
                            break
            if len(solutions[i]) > len(result):
                result = solutions[i]
        # print("solutions: ", solutions)
        return result


# Example usage:
if __name__ == "__main__":
    solution = Solution()
    nums = [1, 2, 3]
    print(solution.largestDivisibleSubset(nums))  # Output: [1, 2] or [1, 3]
    nums = [1, 2, 4, 8]
    print(solution.largestDivisibleSubset(nums))  # Output: [1, 2, 4, 8]