class Solution(object):
    def unmarkedSumArray(self, nums, queries):
        """
        :type nums: List[int]
        :type queries: List[List[int]]
        :rtype: List[int]
        """
        hmap = dict()
        for i in range(len(nums)):
            x = hmap.get(nums[i])
            if x is None:
                hmap[nums[i]] = [i]
            else:
                hmap[nums[i]].append(i)

        print(hmap)
        result = []
        for arr in queries:
            index = arr[0]
            value = nums[index]
            for key in hmap[value]:
                if key == index:
                    left = 0
                    right = len(hmap[value]) - 1
                    while left <= right:
                        mid = (left + right) // 2
                        if hmap[value][mid] == index:
                            aa = hmap[value].pop(mid)
                            print(aa)
                            break
                        elif hmap[value][mid] < index:
                            left = mid + 1
                        else:
                            right = mid - 1
                    break
            print(hmap)
            k = arr[1]
            for key in hmap:
                if k > 0:
                    hmap[key] = hmap[key][1:]
                    k -= 1
                else:
                    break
            res = 0
            for key in hmap:
                res += key * len(hmap[key])
            result.append(res)

        print(hmap)
        return result


print(Solution().unmarkedSumArray([1, 2, 2, 1, 2, 3, 1], [[1, 2], [3, 3], [4, 2]]))
