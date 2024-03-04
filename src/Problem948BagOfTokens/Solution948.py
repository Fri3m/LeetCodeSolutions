class Solution(object):
    def bagOfTokensScore(self, tokens, power):  # 30ms 11.86MB
        """
        :type tokens: List[int]
        :type power: int
        :rtype: int
        """
        tokens.sort()
        l, r = 0, len(tokens) - 1
        score = 0
        while l <= r:
            if power >= tokens[l]:
                power -= tokens[l]
                l += 1
                score += 1
            elif score > 0 and l != r:
                power += tokens[r]
                r -= 1
                score -= 1
            else:
                break
        return score


# Path: Solution949.py


print(Solution().bagOfTokensScore([100, 200, 300, 400], 200))
