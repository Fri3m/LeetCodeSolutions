# 1552ms Beats 97.74% of users with Python, 51.16MB Beats 98.49% of users with Python
class Solution(object):
    def findAllPeople(self, n, meetings, firstPerson):
        """
        :type n: int
        :type meetings: List[List[int]]
        :type firstPerson: int
        :rtype: List[int]
        """
        whoKnows = {firstPerson: 0, 0: 0}
        personQueue = [0, firstPerson]
        lastIndex = 0

        newMeetings = [[] for _ in range(n)]
        for arr in meetings:
            newMeetings[arr[0]].append(arr)
            newMeetings[arr[1]].append(arr)

        while lastIndex < len(personQueue):
            person = personQueue[lastIndex]
            print(personQueue[lastIndex:])
            lastIndex += 1
            for meeting in newMeetings[person]:
                print(meeting)
                if whoKnows.get(meeting[0]) is None and whoKnows.get(meeting[1]) is not None:
                    # print(1)
                    if whoKnows.get(meeting[1]) <= meeting[2]:
                        print("meeting[0]", meeting[0], "none")
                        whoKnows[meeting[0]] = meeting[2]
                        personQueue.append(meeting[0])
                elif whoKnows.get(meeting[0]) > meeting[2] and whoKnows.get(meeting[1]) is not None:
                    print(2)
                    if whoKnows.get(meeting[1]) <= meeting[2]:
                        print("meeting[0]", meeting[0], "dict", whoKnows.get(meeting[0]), "meeting[2]", meeting[2])
                        whoKnows[meeting[0]] = meeting[2]
                        personQueue.append(meeting[0])

                if whoKnows.get(meeting[1]) is None and whoKnows.get(meeting[0]) is not None:
                    print(3)
                    if whoKnows.get(meeting[0]) <= meeting[2]:
                        print("meeting[1]", meeting[1], "none")
                        whoKnows[meeting[1]] = meeting[2]
                        personQueue.append(meeting[1])
                elif whoKnows.get(meeting[1]) > meeting[2] and whoKnows.get(meeting[0]) is not None:
                    print(4)
                    if whoKnows.get(meeting[0]) <= meeting[2]:
                        print("meeting[1]", meeting[1], "dict", whoKnows.get(meeting[1]), "meeting[2]", meeting[2])
                        whoKnows[meeting[1]] = meeting[2]
                        personQueue.append(meeting[1])
        aaaa = list(whoKnows.keys())
        aaaa.sort()
        return aaaa


arr = [[3, 4, 2], [1, 2, 1], [2, 3, 1]]
print("\n", Solution().findAllPeople(5, arr, 1))
