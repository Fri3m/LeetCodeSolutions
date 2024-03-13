package Problem2864MaximumOddBinaryNumber;

public class Solution2864 {
    public static void main(String[] args) {
        Solution2864 a = new Solution2864();
        System.out.println(a.maximumOddBinaryNumber("101101"));
    }
    public String maximumOddBinaryNumber(String s) {
        /*
        * 2ms 42.91Mb Memory
        * */
        int ones=-1,length = s.length();
        for (int i = 0; i<length; i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }
        StringBuilder sBuilder = new StringBuilder();
        while (ones > 0) {
            sBuilder.append("1");
            ones--;
        }
        while (sBuilder.length() < length -1) {
            sBuilder.append("0");
        }
        sBuilder.append("1");
        s = sBuilder.toString();

        return s;
    }
}
