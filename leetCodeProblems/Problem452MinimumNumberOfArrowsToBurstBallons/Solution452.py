class Solution(object):
    def findMinArrowShots(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        points = sorted(points, key=lambda x: x[1])
        print(points)
        if len(points) == 0:
            return 0
        arrows = 1
        lastEnd = points[0][1]
        for x in points:
            if x[0] > lastEnd:
                arrows += 1
                lastEnd = x[1]
        return arrows



print(Solution().findMinArrowShots([[10, 16], [2, 8], [1, 6], [7, 12]]))
print(Solution().findMinArrowShots([[1, 2], [3, 4], [5, 6], [7, 8]]))
print(Solution().findMinArrowShots([[1, 2], [2, 3], [3, 4], [4, 5]]))