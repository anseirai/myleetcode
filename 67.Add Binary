/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/
public class Solution {
    public String addBinary(String a, String b) {
        if (isBlank(a) && isBlank(b)) {
            return null;
        } else if (isBlank(a)) {
            return b;
        } else if (isBlank(b)) {
            return a;
        }
        char[] r = new char[(a.length() > b.length() ? a.length() : b.length()) + 1];
        int k = r.length - 1;
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        for (; i >= 0 && j >= 0; i--, j--, k--) {
            char ac = a.charAt(i);
            char bc = b.charAt(j);
            int sum = (ac - '0') + (bc - '0') + carry;
            if (sum >= 2) {
                carry = 1;
            } else {
                carry = 0;
            }
            r[k] = sum % 2 == 1 ? '1' : '0';//注意转换成字符后，才能再次赋值
        }
        
        while (i >= 0) {//注意在剩下的字符赋值过程中，也是存在着进位的可能的。
            int sum = a.charAt(i) - '0' + carry;
            if (sum >= 2) {
                carry = 1;
            } else {
                carry = 0;
            }
            r[k] = sum % 2 == 1 ? '1' : '0';
            i--;
            k--;
        }
        
        while (j >= 0) {
            int sum = b.charAt(j) - '0' + carry;
            if (sum >= 2) {
                carry = 1;
            } else {
                carry = 0;
            }
            r[k] = sum % 2 == 1 ? '1' : '0';
            j--;
            k--;
        }
        
        if (carry == 1) {//最后确定carry是否加完
            r[k] = '1';
        }
        
        return (new String(r)).trim();//注意去掉其中的空字符
    }
    
    public boolean isBlank(String s) {
        if (s == null || s == "") {
            return true;
        }
        return false;
    }
}