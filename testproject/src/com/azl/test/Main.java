package com.azl.test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
	
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	int times = in.nextInt();
        	
        	for (int i = 0; i < times; i++) {
        		Map<Integer, Integer> result = new HashMap<Integer, Integer>();
        		 int modulesNum = in.nextInt();
        		 int initialSignalsNum = in.nextInt();
        		 int[] initialSignals = new int[10001];
        		 for (int j = 0; j < initialSignalsNum; j++) {
        			 initialSignals[j] = in.nextInt();
        		 }
        		 
        		 Map<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();
        		 for (int j = 0; j < modulesNum; j++) {
        			 int start = in.nextInt();
        			 Integer[] generate = new Integer[10];
        			 int k = 0;
        			 generate[k] = in.nextInt();
        			 for (k = 1; k <= generate[0]; k++) {
        				 generate[k] = in.nextInt();
        			 }
        			 
        			 map.put(start, generate);
        		 }
        		 
        	}
        }
    }
}
