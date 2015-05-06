package com.azl.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

public class Test extends TestCase {
	
	public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
	}
	
	public static void main(String[] args) {
		List<Integer> result = new ArrayList<Integer>(); 
		result.add(2);
		result.set(0, 5);
		for (int i = 0; i > 3; i++) {
			System.out.println(i);
		}
		System.out.println(result);
	}
	
	public ListNode deleteDuplicates(ListNode head) {
        ListNode head2 = new ListNode(-1);
        ListNode p1 = head2;
        if (head != null) {
            if (head.next != null) {
                if (head.next.val != head.val) {
                    p1.next = head;
                    p1 = head;
                }
            } else {
                p1.next = head;
                p1 = head;
            }
        } else {
            return null;
        }
        
        ListNode prev = null;
        for (prev = head; prev != null && prev.next != null && prev.next.next != null; prev = prev.next) {
            ListNode cur = prev.next;
            ListNode post = cur.next;
            if (prev.val != cur.val && cur.val != post.val) {
                p1.next = cur;
                p1 = cur;
            }
        }
        
        if (prev.next != null && prev.val != prev.next.val) {
            p1.next = prev.next;
        }
        
        return head2.next;
    }
	
	public static int singleNumberTest(int[] A) {
        /*
        element in A is 32bit,
        sum corresponding bits from all elements and mod each by 3 then should left the single number
        */
        int[] sum=new int[32];
        int res=0;
        for(int i=0;i<32;i++)
        {
            for(int j=0;j<A.length;j++)
            {
                sum[i]+=((A[j]>>>i)&1);//sum every bit of all numbers
            }
            sum[i]%=3;
            res+=((sum[i]&1)<<i);// recover the single number
        }
        return res;
    }
	
	public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int j = -1;
        for (int i = 0, sum = 0; i < gas.length; ++i) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                j = i;
                sum = 0;
            }
        }
        return total >= 0 ? j + 1 : -1;
    }
	
	public static List<Integer> grayCode(int n) {
		if (n == 0) {
			return new ArrayList<Integer>() {{add(0);}};
		}
        List<String> stringGrayCode = getGrayCode(n);
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < stringGrayCode.size(); i++) {
            result.add(Integer.parseInt(stringGrayCode.get(i), 2));
        }
        
        return result;
    }
    
    public static List<String> getGrayCode(int n) {
        List<String> list1 = new ArrayList<String>();
        List<String> list = null;
        if (n == 1) {
            list1.add("0");
            list1.add("1");
            
            return list1;
        } else {
            list = getGrayCode(n - 1);
        }
        
        for (int i = 0; i < list.size(); i++) {
            list1.add("0" + list.get(i));
        }
        
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            list1.add("1" + list.get(i));
        }
        
        return list1;
    }
    
    public static void convertArrayListTest() {
    	List<String> list = new ArrayList<String>(Arrays.asList("00","01","11","10"));
		System.out.print(list);
		Collections.reverse(list);
		System.out.print(list);
    }
	
	public static void array2ArrayListTest() {
		Integer[] a = {2,1,0,4};
		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(a));
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(2,1,0,2));
		list1.add(0, 5);
		int[] b = new int[list1.size()];
		for (int i = 0; i < list1.size(); i++) {
			b[i] = list1.get(i);
		}
		
		System.out.println(Arrays.toString(b));
	}
	
	public static int trap(int[] A) {
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < A.length; i++) {
            if (max < A[i]) {
                max = A[i];
                maxIndex = i;
            }
        }
        
        int result = 0;
        for (int i = 0; i < maxIndex; i++) {
            if (A[i] > A[i + 1]) {
                result += A[i] - A[i + 1];
                A[i + 1] = A[i];
            }
        }
        
        for (int i = A.length - 1; i > maxIndex; i--) {
            if (A[i] > A[i - 1]) {
                result += A[i] - A[i - 1];
                A[i - 1] = A[i];
            }
        }
        
        return result;
    }
	
	public static void validSudoku() {
		String aString = "....5..1.,.4.3.....,.....3..1,8......2.,..2.7....,.15......,.....2...,.2.9.....,..4......";
		String[] aStringArray = aString.split(",");
		char[][] board = new char[9][9];
		for (int i = 0; i < 9; i++) {
			char[] a = aStringArray[i].toCharArray();
			board[i] = a;
		}
		System.out.println(isValidSudoku(board));
	}
	
	public static boolean isValidSudoku(char[][] board) {
		boolean[] num = new boolean[10];
        for (int i = 0; i < 10; i++) {
            num[i] = false;
        }
        
        for (int i = 0; i < 9; i++) {
        	 for (int m = 0; m < 10; m++) {
                 num[m] = false;
             }
        	
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && num[board[i][j] - 48]) {
                    return false;
                } else if (board[i][j] != '.') {
                    num[board[i][j] - 48] = true;
                }
            }
        }
        
        for (int i = 0; i < 10; i++) {
            num[i] = false;
        }
        for (int j = 0; j < board[0].length; j++) {
        	for (int m = 0; m < 10; m++) {
                num[m] = false;
            }
        	
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] != '.' && num[board[i][j] - 48]) {
                    return false;
                } else if (board[i][j] != '.') {
                    num[board[i][j] - 48] = true;
                }
            }
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 10; k++) {
                    num[k] = false;
                }
                
                for (int k = i * 3; k < i * 3 + 3; k++) {
                    for (int l = j * 3; l < j * 3 + 3; l++) {
                        if (board[k][l] != '.' && num[board[k][l] - 48]) {
                            return false;
                        } else if (board[k][l] != '.') {//not board[i][j]
                            num[board[k][l] - 48] = true;
                        }
                    }
                }
            }
        }
        
        return true;
    }
	
	public static void convertCharToIntTest() {
		char a = '2';
		int[] intArray = { 1, 2, 3, 4, 5 }; 
		System.out.println(intArray[a - 48]);
	}
	
	public void dyadicArrayLengthTest() {
		char[][] board = {{'1','2','.'},{'2','6','8'},{'.','3','4'}};
		System.out.println("max j : " + board.length);
		System.out.println("max i : " + board[0].length);
		System.out.println("max i : " + board[1].length);
	}
	
	public void listContainsTest() {
		List list1 = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
		List list2 = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
		
		List list = new ArrayList();
		list.add(list1);
		System.out.println(list.contains(list2));
	}
	
	public static void listValueRemoveTest() {
		List list1 = new ArrayList<Integer>(Arrays.asList(1,2,2,4));
		
		list1.remove(2);
		System.out.println(list1);
	}
	
	public static void arraysSortPartTest() {
		int[] intArray = { 1, 2, 3, 4, 5 }; 
		Arrays.sort(intArray, 2, 4);
		System.out.println(Arrays.toString(intArray)); 
	}
	
	public static void reverseTest() {
		int[] intArray = { 1, 2, 3, 4, 5 };  
		reverse(intArray, 1, 3);  
		System.out.println(Arrays.toString(intArray)); 
	}
	
	public static void permutationSequece() {
		int n = 2;
		int k = 2;
		Date date1 = new Date();
		List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        System.out.println("list size is : " + list.size()); 
        
        int[] num = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            num[i] = list.get(i);
        }
        System.out.println("list size is : " + Arrays.toString(num)); 
        
        for (int i = 0; i < k - 1; i++) {
            nextPermutation(num);
        }
		Date date2 = new Date();
		
		System.out.println("time is : "); 
		System.out.println(date2.getTime() - date1.getTime()); 
		System.out.println(Arrays.toString(num).replaceAll(",| |\\]|\\[", "")); 
	}
	
	public static void nextPermutation(int[] num) {
		int a = num.length - 2;
		int b = num.length - 1;
		while (a >= 0 && num[a] >= num[a + 1]) {
			a--;
		}
		if (a >= 0) {
			while (b > a && num[b] <= num[a]) {
				b--;
			}
			
			swap(num, a, b);
			System.out.println(Arrays.toString(num));
			System.out.println(a);
			reverse(num, a + 1, num.length - 1);
			
			System.out.println(Arrays.toString(num));
		} else {
			reverse(num, 0, num.length - 1);
			System.out.println(Arrays.toString(num));
		}
	}
	
	private static void swap(int[] num, int a,int b) {
		int temp = num[a];
		num[a] = num[b];
		num[b] = temp;
	}
	
	private static void reverse(int[] num, int a,int b) {
		while (a < b) {
			num[a] ^= num[b];
			num[b] ^= num[a];
			num[a] ^= num[b];
			
			a++;
			b--;
		}
	}
}
