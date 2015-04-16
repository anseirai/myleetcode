/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/
public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1 || s.length() == 2) {
            return s;
        }
        
        int max = -1;
        int begin = -1;
        for (int i = 1; i <= s.length() - 2; i++) {
            int j = 1;
            int num = 1;
            int begintmp = -1;
            int p1 = 0;
            int p2 = 0;
            for (; i - j >= 0 && i + j < s.length(); j++) {
                p1 = i - j;
                p2 = i + j;
                if (s.charAt(p1) == s.charAt(p2)) {
                    num+=2;
                    begintmp = p1;
                    continue;
                }
                break;
            }
            if (num > max) {
                max = num;
                begin = begintmp;
            }
        }
        
        for (int i = 0; i < s.length() - 1; i++) {
            int j = 1;
            int num = 0;
            int begintmp = -1;
            int p1 = 0;
            int p2 = 0;
            if (s.charAt(i) == s.charAt(i + 1)) {
                num+=2;
                begintmp = i;
                j++;
            } else {
                continue;
            }
            for (; i - j + 1 >= 0 && i + j < s.length(); j++) {
                p1 = i - j + 1;
                p2 = i + j;
                if (s.charAt(p1) == s.charAt(p2)) {
                    num+=2;
                    begintmp = p1;
                    continue;
                }
                break;
            }
            if (num > max) {
                max = num;
                begin = begintmp;
            }
        }
        return s.substring(begin, begin + max);
    }
}