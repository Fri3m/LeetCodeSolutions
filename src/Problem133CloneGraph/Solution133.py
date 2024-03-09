#27ms 11.87MB
class Node(object):
    def __init__(self, val=0, neighbors=None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


class Solution(object):
    def cloneGraph(self, node):
        """
        :type node: Node
        :rtype: Node
        """
        max = 0
        if node is None:
            return None
        adjMatrix = {}
        visited = set()
        queue = [node]
        while queue:
            cur = queue.pop(0)
            if cur.val > max:
                max = cur.val
            if cur.val not in visited:
                visited.add(cur.val)
                a = list()
                for x in cur.neighbors:
                    a.append(x.val)
                    queue.append(x)
                adjMatrix.update({cur.val: a})
        print(adjMatrix)
        i = 1
        nodes = []
        while i <= max:
            nodes.append(Node(i))
            i += 1
        for x in adjMatrix:
            for y in adjMatrix[x]:
                nodes[x-1].neighbors.append(nodes[y-1])
        return nodes[1]



n1 = Node(1)
n2 = Node(2)
n3 = Node(3)
n4 = Node(4)
n1.neighbors.append(n2)
n1.neighbors.append(n4)
n2.neighbors.append(n1)
n2.neighbors.append(n3)
n3.neighbors.append(n2)
n3.neighbors.append(n4)
n4.neighbors.append(n1)
n4.neighbors.append(n3)

print(Solution().cloneGraph(n1))

# print(Solution().cloneGraph(None))
