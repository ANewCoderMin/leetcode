package com.xixi.leetcode.editor.cn;

public class LongestPalindromicSubstring{
    public static void main(){
        Solution solution = new LongestPalindromicSubstring().new Solution();
        solution.longestPalindrome("babad");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        if (s == null || s.isBlank()){
            return result;
        }
        for (int i = 0; i < s.length(); i++) {
            int[] res = core(i - 1, i + 1, s);
            if (res[1] - res[0] + 1 > result.length()){
                result = s.substring(res[0], res[1] + 1);
            }
        }
        return result;
    }

    public int[] core(int start, int end, String s){
        while (start >= 0 && end < s.length() && s.indexOf(start) == s.indexOf(end)){
            start--;
            end++;
        }
        return new int[]{++start, --end};
    }
}


}