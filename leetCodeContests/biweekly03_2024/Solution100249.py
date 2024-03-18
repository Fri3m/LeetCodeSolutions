class Solution(object):
    def minimizeStringValue(self, s):
        """
        :type s: str
        :rtype: str
        """
        hmap = dict()
        hmap[0] = list()
        for i in range(97, 123):
            hmap[0].append(chr(i))

        cmap = dict()
        for i in range(97, 123):
            cmap[chr(i)] = 0

        result = str()
        howMany = 0

        for i in range(len(s)):
            if s[i] != '?':
                x = cmap[s[i]]
                cmap[s[i]] = x + 1
                hmap[x].remove(s[i])
                if hmap.get(x + 1) is None:
                    hmap[x + 1] = [s[i]]
                else:
                    hmap.get(x + 1).append(s[i])
                    hmap.get(x + 1).sort()
            else:
                howMany += 1

        currentHowMany = howMany
        for i in range(len(s)):
            if s[i] == '?':
                for key in hmap:
                    # print(hmap[key])
                    if len(hmap[key]) < currentHowMany:
                        currentHowMany -= len(hmap[key])
                        print(howMany, currentHowMany, hmap[key])
                        continue
                    x = ''
                    while len(hmap[key]) == 0:
                        key += 1
                    x = hmap[key].pop(0)
                    print(x, hmap[key])
                    result += x
                    howMany -= 1
                    currentHowMany = howMany
                    cmap[x] += 1
                    if hmap.get(key + 1) is None:
                        hmap[key + 1] = [x]
                    else:
                        hmap[key + 1].append(x)
                        hmap[key + 1].sort()
                    break
            else:
                result += s[i]
        return result


print(Solution().minimizeStringValue("g?xvgroui??xk?zqb?da?jan?cdhtksme"))  # "g b xvgroui cf xk l zqb p da w jan y cdhtksme"
