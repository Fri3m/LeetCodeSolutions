class Solution(object):
    def mostPoints(self, questions):
        """
        :type questions: List[List[int]]
        :rtype: int
        """
        points = [0] * (len(questions) + 1)
        for i in range(len(questions) - 1, -1, -1):
            x = i + questions[i][1] + 1 if i + questions[i][1] + 1 < len(points) else len(points) - 1
            points[i] = max(points[i + 1], questions[i][0] + points[x])
        print("questions", questions, " --- points", points)
        return points[0]



s = Solution()
# Example usage
questions = [[3, 2], [4, 3], [4, 4], [2, 5]]
print(s.mostPoints(questions))  # Output: 5
questions = [[1, 1], [2, 2], [3, 3]]
print(s.mostPoints(questions))  # Output: 4
questions = [[1, 2], [2, 3], [3, 4]]
print(s.mostPoints(questions))  # Output: 6