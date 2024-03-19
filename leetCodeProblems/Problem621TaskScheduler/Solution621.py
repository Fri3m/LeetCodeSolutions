class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """

        taskFreq = [0 for _ in range(26)]
        for task in tasks:
            taskFreq[ord(task) - ord('A')] += 1

        taskFreq.sort(reverse=True)

        spaces = set()

        first_task = taskFreq.pop(0)
        total = 0

        while first_task > 0:
            total += 1
            for _ in range(n):
                total += 1
                spaces.add(total - 1)
            first_task -= 1
        for _ in range(n):
            total -= 1
            spaces.remove(total)

        index = 0
        for task in taskFreq:
            if task == 0:
                break
            for i in range(1, task + 1):
                calc = (i * (n + 1) - n + index)
                if calc >= total:
                    for _ in range(calc - total - 1):
                        spaces.add(total - 1)
                        total += 1
                    total += 1
                elif calc in spaces:
                    spaces.remove(calc)
                elif calc not in spaces:
                    if len(spaces) > 0:
                        calc = min(spaces)
                        spaces.remove(calc)
                    else:
                        total += 1
            index += 1
        return total


sol = Solution()
print(sol.leastInterval(["A", "A", "A", "A", "A", "A", "B", "C", "D", "E", "F", "G"], 1))
print(sol.leastInterval(["A", "A", "A", "B", "B", "B"], 2))
