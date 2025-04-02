class Solution(object):
    def maximumTripletValue(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        leftmax = [0] * len(nums)
        rightmax = [0] * len(nums)

        for i in range(1, len(nums)):
            leftmax[i] = max(leftmax[i-1], nums[i-1])

        for i in range(len(nums)-2, -1, -1):
            rightmax[i] = max(rightmax[i+1], nums[i+1])

        result = 0
        for i in range(1, len(nums)-1):
            result = max(result, (leftmax[i] - nums[i]) * rightmax[i])

        return result


# Example usage:
if __name__ == "__main__":
    solution = Solution()
    print(solution.maximumTripletValue(nums = [12,6,1,2,7])) # 77
    print("\n\n\n----------------------")
    print(solution.maximumTripletValue(nums =[18,15,8,13,10,9,17,10,2,16,17]))
    print("\n\n\n----------------------")
    print(solution.maximumTripletValue(nums =[8,6,3,13,2,12,19,5,19,6,10,11,9])) #266