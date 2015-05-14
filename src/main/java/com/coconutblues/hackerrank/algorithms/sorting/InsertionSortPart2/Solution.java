package com.coconutblues.hackerrank.algorithms.sorting.InsertionSortPart2;

import java.util.Scanner;


/**
 * https://www.hackerrank.com/challenges/insertionsort2
 * Breakdown the problem into two parts
 * 1) The outer loop will pick a sub array 
 * 2) The inner loop will do insertionSort1 on the sub array picked by the outer loop
 * Print out the array after the entire run of the insertionSort1 in the sub array.

<pre>
 Test Case 0
===========

Input
-----
6
1 4 3 5 6 2

Expected Output
---------------
1 4 3 5 6 2
1 3 4 5 6 2
1 3 4 5 6 2
1 3 4 5 6 2
1 2 3 4 5 6

Test Case 1
===========
9
9 8 6 7 3 5 4 1 2

Expected Output
---------------
8 9 6 7 3 5 4 1 2
6 8 9 7 3 5 4 1 2
6 7 8 9 3 5 4 1 2
3 6 7 8 9 5 4 1 2
3 5 6 7 8 9 4 1 2
3 4 5 6 7 8 9 1 2
1 3 4 5 6 7 8 9 2
1 2 3 4 5 6 7 8 9
</pre>
 */
public class Solution {

	public static void insertionSortPart2(int[] ar)
	{       
		int size = ar.length;
		// Edge case - simply return and print nothing.
		if(size<=1){
			return;
		}

		// Outer loop
		for (int outer=2; outer<= size; outer++) {
			int valToMove = ar[outer-1];

			// inner loop where the insertionSort is done.
			for (int inner = outer-2; inner >=0 ; inner--) {
				int valToCompare = ar[inner];

				if(inner == 0) {

					if(valToMove < valToCompare) {
						ar[1] = valToCompare;                   
						ar[0] = valToMove;

					} else {                    	                    
						ar[1] = valToMove;                    
					}
					break;
				}

				if(valToMove < valToCompare) {
					ar[inner+1] = valToCompare;  
					continue;
				} else {
					ar[inner+1] = valToMove;
					break;
				}


			}

			// Print after execution of each outer loop
			printArray(ar);
		}




	}  



	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for(int i=0;i<s;i++){
			ar[i]=in.nextInt(); 
		}
		insertionSortPart2(ar);    

	}    
	private static void printArray(int[] ar) {
		for(int n: ar){
			System.out.print(n+" ");
		}
		System.out.println("");
	}
}

