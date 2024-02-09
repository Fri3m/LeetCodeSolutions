package Problem3031;

public class Solution3031 {

    // Problem 3031. Minimum Time to Revert Word to Initial State II
    // You are given a 0-indexed string word and an integer k.
    // At every second, you must perform the following operations:
    // Remove the first k characters of word. Add any k characters to the end of word.
    // Note that you do not necessarily need to add the same characters that you removed.
    // However, you must perform both operations at every second.
    // Return the minimum time greater than zero required for word to revert to its initial state.

    // Leetcode result Runtime 22ms Memory 46.57MB
    public static void main(String[] args) {
        System.out.println( "Case 1 : word is abacaba k is 3 answer is "+new Solution3031().minimumTimeToInitialState("abacaba", 3));
        System.out.println( "Case 1 : word is abacaba k is 4 answer is"+new Solution3031().minimumTimeToInitialState("abacaba", 4));
        System.out.println( "Case 1 : word is abcbabcd k is 2 answer is" +new Solution3031().minimumTimeToInitialState("abcbabcd", 2));
        // You can try your own test cases
        // leetcode page is www.leetcode.com/problems/minimum-time-to-revert-word-to-initial-state-ii
    }

    public int minimumTimeToInitialState(String word, int k) {
        word = arrangeWord(word, k);
        return findFirstIndexOfNewString(word, k) / k;
    }

    int findFirstIndexOfNewString(String word, int k) {
        int breakpoint = -1, breakpointMax = -1;
        for (int i = 1; i < word.length() / k; i++) {
            if(breakpoint - i * k>=0) {
                if (word.charAt(breakpoint) != word.charAt(breakpoint - i * k))
                    continue;
            }
            if(breakpointMax - i * k>=0) {
                if (word.charAt(breakpointMax) != word.charAt(breakpointMax - i * k))
                    continue;
            }
            for (int j = 0; j < word.length(); j++) {
                if (i * k + j >= word.length()) {
                    return i * k;
                }
                char c = word.charAt(i * k + j);
                if (c == ' ' || c == '\0') {
                    return i * k;
                }
                if (c != word.charAt(j)) {
                    breakpoint = i * k + j;
                    if(breakpointMax < breakpoint)  breakpointMax = breakpoint;
                    break;
                }
            }
        }
        return word.length();
    }


    String arrangeWord(String word, int k) {
        if (word.length() % k != 0) {
            StringBuilder wordBuilder = new StringBuilder(word);
            wordBuilder.append(" ".repeat(Math.max(0, k - wordBuilder.length() % k)));
            word = wordBuilder.toString();
        }
        return word;
    }
}