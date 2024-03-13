#18ns 11.83MB
class Solution(object):
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        nums2set = set(nums2)
        result = set()
        for x in nums1:
            if x in nums2set:
                result.add(x)
        return list(result)
