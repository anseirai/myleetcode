/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Update (2014-11-02):
The signature of the function had been updated to return the index instead of the pointer. If you still see your function signature returns a char * or String, please click the reload button  to reset your code definition.
*/
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {//注意增加为空判断
            return 0;
        }
        
        if (haystack.length() < needle.length()) {//为简便起见，分为三种情况进行判断，这里为第一种：haystack长度<needle长度
            return -1;
        }
        
        if (haystack.length() == needle.length()) {//长度相等
            if (haystack.compareTo(needle) == 0) {
                return 0;
            } else {
                return -1;
            }
        }
        
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {//长度大于的needle的长度。这里注意i的范围，几次提交不过就是这个原因。
            int j = 0;
            for (; j < needle.length(); j++) {
                if (i + j < haystack.length() && haystack.charAt(i + j) != needle.charAt(j)) {//这里注意的问题是i+j的范围，防止边界异常抛出。
                    break;
                }
                continue;
            }
            if (j == needle.length()) {//判断结束条件
                return i;
            }
        }
        
        return -1;
    }
}