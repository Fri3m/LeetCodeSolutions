#14ms 11.47MB
class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        """
        total = m + n
        i, j, k = 0, 0, 0
        a = nums1[:m]
        while i < total:
            print(i, j, k, nums1, a, nums2)
            if j >= m:
                nums1[i] = nums2[k]
                k += 1
            elif k >= n:
                nums1[i] = a[j]
                j += 1
            elif a[j] < nums2[k]:
                nums1[i] = a[j]
                j += 1
            else:
                nums1[i] = nums2[k]
                k += 1
            i += 1
        print(i, j, k, nums1, a, nums2)


print(Solution().merge([4, 5, 6, 0, 0, 0], 3, [1, 2, 3], 3))
