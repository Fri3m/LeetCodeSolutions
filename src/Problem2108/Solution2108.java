package Problem2108;

public class Solution2108 {
    //Leetcode result Runtime 2ms(Beats 71.53% of users with Java) Memory 44.5MB(Beats 91.24% of users with Java)
    public static void main(String[] args) {
        System.out.println( "Case 1 : words are [\"abc\",\"car\",\"ada\",\"racecar\",\"cool\"] answer is "+new Solution2108().firstPalindrome(new String[]{"abc","car","ada","racecar","cool"}));
        System.out.println( "Case 2 : words are [\"notapalindrome\",\"racecar\"] answer is "+new Solution2108().firstPalindrome(new String[]{"notapalindrome","racecar"}));
        System.out.println( "Case 3 : words are [\"def\",\"ghi\"] answer is "+new Solution2108().firstPalindrome(new String[]{"def","ghi"}));
        // You can try your own test cases
        // leetcode page is www.leetcode.com/problems/find-first-palindromic-string-in-the-array
    }
    public String firstPalindrome(String[] words) {
        for(String word: words){
            boolean isOk= true;
            for(int i=0,j=word.length() -1; i<j ;i++ , j--){
                if(word.charAt(i) != word.charAt(j)){
                    isOk = false;
                    break;
                }
            }
            if(isOk) return word;
        }
        return "";
    }
}
