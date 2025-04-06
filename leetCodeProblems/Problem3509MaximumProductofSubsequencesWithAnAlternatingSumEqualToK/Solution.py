class Solution(object):
    def maxProduct(self, nums, k, limit):
        """
        :type nums: List[int]
        :type k: int
        :type limit: int
        :rtype: int
        """
        result = -1
        solution_set = set()
        has_zero = True if 0 in nums else False

        if sum(nums) < abs(k):
            return -1

        for i in range(len(nums)):
            current = nums[i]
            if current > limit:
                break
            if current == k and limit >= current > result:
                result = current

            copy_of_set = solution_set.copy()
            solution_set.add((current, current, True))
            for x, y, z in copy_of_set:
                if y * current > limit:
                    continue
                if z:
                    solution_set.add((x - current, current * y, False))
                    if x - current == k and result < current * y <= limit:
                        result = current * y
                else:
                    solution_set.add((x + current, current * y, True))
                    if x + current == k and result < current * y <= limit:
                        result = current * y

        if result == -1 and has_zero:
            solution_set = set()
            for i in range(len(nums)):
                current = nums[i]
                if current == k and limit >= current > result:
                    result = current

                copy_of_set = solution_set.copy()
                solution_set.add((current, current, True))
                for x, y, z in copy_of_set:
                    if z:
                        solution_set.add((x - current, current * y, False))
                        if x - current == k and result < current * y <= limit:
                            result = current * y
                    else:
                        solution_set.add((x + current, current * y, True))
                        if x + current == k and result < current * y <= limit:
                            result = current * y

        # print(solution_set)
        return result


# Example usage:

if __name__ == "__main__":
    solution = Solution()
    print(solution.maxProduct(nums=[1, 2, 3], k=2, limit=10))  # Output: 6
    print()
    print(solution.maxProduct(nums=[4, 2], k=2, limit=10))  # Output: 8
    print()
    print(solution.maxProduct(nums=[10, 10, 9, 0], k=1, limit=20))  # Output: 0
    print()
    print(
        solution.maxProduct(nums=[12, 12, 9, 7, 7, 10, 5, 2, 11, 9, 11, 2, 5, 8, 0, 10, 12, 0, 10, 2, 10, 2, 11, 5, 10],
                            k=35, limit=100))  # Output: 0
    print()
    print(solution.maxProduct(nums=[3, 2], k=2, limit=20))  # Output: 2
    print()
    print(solution.maxProduct(
        nums=[7, 8, 12, 2, 9, 0, 5, 12, 10, 1, 11, 9, 5, 9, 7, 12, 12, 12, 6, 7, 5, 7, 9, 2, 7, 7, 11, 8, 9, 1, 6, 12,
              11, 6, 1, 4, 2, 6, 5, 4], k=15, limit=100))  # Output:
