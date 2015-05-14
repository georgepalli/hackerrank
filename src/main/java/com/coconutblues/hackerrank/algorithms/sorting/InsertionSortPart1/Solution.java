package com.coconutblues.hackerrank.algorithms.sorting.InsertionSortPart1;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/insertionsort1
 * 
 * 
 * 
<pre>
Test Case 0
===========

Input
-----
5
2 4 6 8 3

Expected Output
---------------
2 4 6 8 8
2 4 6 6 8
2 4 4 6 8
2 3 4 6 8

Test Case 2
===========

Input
-----
10
2 3 4 5 6 7 8 9 10 1

Expected Output
---------------
2 3 4 5 6 7 8 9 10 10
2 3 4 5 6 7 8 9 9 10
2 3 4 5 6 7 8 8 9 10
2 3 4 5 6 7 7 8 9 10
2 3 4 5 6 6 7 8 9 10
2 3 4 5 5 6 7 8 9 10
2 3 4 4 5 6 7 8 9 10
2 3 3 4 5 6 7 8 9 10
2 2 3 4 5 6 7 8 9 10
1 2 3 4 5 6 7 8 9 10

</pre>
 * @author georgepalli
 */
public class Solution {

	   public static void insertIntoSorted(int[] ar) {
	        int size = ar.length;
	        if(ar.length <=1) {
	            // No shifting so simply return
	            return;
	        }
	        int valToMove = ar[size-1];
	        for(int i= size -2 ; i >=0 ; --i) {
	            int valToCompare = ar[i];
	            
	            if(i == 0) {
	                if(valToMove < valToCompare) {
	                    ar[1] = valToCompare;                   
	                    printArray(ar);
	                    ar[0] = valToMove;
	                    printArray(ar);
	                    
	                } else {                    
	                    //ar[0] = valToCompare;
	                    
	                    ar[1] = valToMove;                    
	                    printArray(ar);
	                }
	               

	                return;
	            }

	            
	            if(valToMove < valToCompare) {
	                ar[i+1] = valToCompare;  
	                printArray(ar);
	                continue;
	            } else {
	                ar[i+1] = valToMove;
	                printArray(ar);
	                break;
	            }

	        }
	    }
	    
	    
	/* Tail starts here */
	     public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int s = in.nextInt();
	        int[] ar = new int[s];
	         for(int i=0;i<s;i++){
	            ar[i]=in.nextInt(); 
	         }
	         insertIntoSorted(ar);
	    }
	    
	    
	    private static void printArray(int[] ar) {
	      for(int n: ar){
	         System.out.print(n+" ");
	      }
	        System.out.println("");
	   }
	    
	 
}
