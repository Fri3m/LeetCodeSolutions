class Solution(object):
    # 11ms 11.6MB
    def customSortString(self, order, s):
        """
        :type order: str
        :type s: str
        :rtype: str
        """
        orderDic = set(order)
        result = ""
        inOrder = ""
        for c in s:
            if c not in orderDic:
                result += c
            else:
                inOrder += c

        for c in order:
            x = 0
            for c2 in inOrder:
                if c == c2:
                    x += 1
            for i in range(x):
                result += c

        return result


class DictionarySolution(object):
    # 12ms 11.7MB
    def customSortString(self, order, s):
        """
        :type order: str
        :type s: str
        :rtype: str
        """
        orderSet = set(order)
        result = ""
        inOrderdict = {}
        for c in s:
            if c not in orderSet:
                result += c
            else:
                if c not in inOrderdict:
                    inOrderdict[c] = 1
                else:
                    inOrderdict[c] += 1

        for c in order:
            if c in inOrderdict:
                result += c * inOrderdict[c]
                inOrderdict.pop(c)

        return result
