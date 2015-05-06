package com.azl.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import com.sun.xml.internal.ws.util.StringUtils;

public class Solution {
	private static final String INT_MAX = "2147483647";
	public static boolean longestPalindrome(String s) {
		if (s.isEmpty()) {
            return false;
        }
        
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        boolean dotFlag = false;
        boolean eFlag = false;
        for (int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case '.':
                    if (dotFlag || eFlag || !(i > 0 && (s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9')) && !(i < s.length() - 1 && (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9'))) {
                            return false;
                        }
                    dotFlag = true;
                    break;
                case '+':
                case '-':
                    if (!((i == 0 || s.charAt(i - 1) == 'e') && (i + 1 < s.length() && ((s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') || s.charAt(i + 1) == '.'))))
                    return false;
                    break;
                case 'e':
                    if (eFlag || i == 0 || i == s.length() - 1) {
                        return false;
                    }
                    eFlag = true;
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    break;
                default :
                    return false;
            }
            
        }
        return true;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//2015-4-30 22:09:35
//		Queue<Integer> q1 = new LinkedList<Integer>();
//		q1.add(1);
//		Queue<Integer> q2 = new LinkedList<Integer>();
//		q2.add(2);
//		q2.add(3);
//		q1 = q2;
//		System.out.println(q1);
		String s = "1.2.3.d";
		String[] ss = s.split("\\.");
		System.out.println(ss.length);
		System.out.println(Arrays.toString(ss));
		StringBuffer sb = new StringBuffer();
		for (String s1 : ss) {
			sb.append(s1);
		}
		System.out.println(sb.toString());
		s.replaceAll("2", "4");
		System.out.println(s);
		//2015-4-27 09:42:48
//		Stack<Character> stacks = new Stack<Character>();
//		stacks.push('a');
//		stacks.push('b');
//		System.out.println(stacks);
//		System.out.println(stacks.isEmpty());
//		System.out.println(stacks.peek());
//		System.out.println(stacks);
//		System.out.println(stacks.pop());
//		System.out.println(stacks);
//		stacks.clear();
//		List<Character> left = new ArrayList<Character>(Arrays.asList('(','{', '['));
//		System.out.println(left.indexOf('{'));
		//2015-4-20 21:39:04
//		String s = "unclear";
//		char[] schars = s.toCharArray();
//		System.out.println(schars[1]);
//		Arrays.sort(schars);
//		System.out.println(schars);
//		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
//		map.put(1, 2);
//		map.put(2, 3);
//		System.out.println(map.size());
//		Set<Integer> set = map.keySet();
//		System.out.println(map.keySet());
//		Iterator<Integer> i = set.iterator();
//		while (i.hasNext()) {
//			System.out.println(i.next());
//		}
//		String st = "/a/./b";
//		System.out.println(st.indexOf("/", 1));
//		System.out.println(st.indexOf("/", 7));//indexOf中起始点越界也没关系
//		System.out.println(st.substring(2));
//		System.out.println(st.substring(0, st.indexOf("/", 1)));
//		
//		List<String> list = new ArrayList<String>();
//		list.add("/a");
//		list.add("/b");
//		list.add("/d");
//		System.out.println(list);
//		list.remove(list.size() - 1);
//		System.out.println(list);
//		
//		String s1 = "Hello World oh yedah ";
//		String[] s1s = s1.split(" ");
//		System.out.println(s1s[s1s.length - 1].length());
		
//		System.out.println("" + 's');
//		String s = "adcfd";
//		System.out.println(s.substring(0, 4));//注意substring的endIndex的意思，不包含endIndex
//		String astring="asdsfsaadfasdsddfdsaf";
//		String b="adf";
//		System.out.println(strStr("",""));
//		System.out.println(astring.indexOf(b));
//		
//		char c = '7';
//		System.out.println(c);
//		System.out.println('0');
//		int a = c - '0';
//		System.out.println(a);
//		char[] a1Array={'a','b','c',''};
//		System.out.println(new String(a1Array));
//		
//		String a1String = "2147483647";
//		String a2String = "2147483648";
//		System.out.println(a1String.compareTo(a2String));
//		List list = new ArrayList();
//		list.toArray();
//		char[] a2Array= new char[7];
//		a2Array[2] = '3';
//		System.out.println((new String(a2Array)));
//		System.out.println((new String(a2Array)).trim());
//		
//		System.out.println(0 - 2147483647);
//		
//		String a3String = "23";
//		String a4String = "2147483647";
//		System.out.println(a3String.compareToIgnoreCase(a4String));
//		INT_MAX.length();
//		
////		System.out.println(String);
	}
}
