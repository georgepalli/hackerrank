package com.coconutblues.hackerrank.datastructures.SwapNodesAlgo;


import java.util.*;

/**
 * https://www.hackerrank.com/challenges/swap-nodes-algo
 * Use BFS to build the tree.
 * Use BFS to swap
 * Use In Order DFS to print.
 * 
 * 
 * 
 * 
<pre>
Sample Input #00

3
2 3
-1 -1
-1 -1
2
1
1
Sample Output #00

3 1 2
2 1 3
Sample Input #01

5
2 3
-1 4
-1 5
-1 -1
-1 -1
1
2
Sample Output #01

4 2 1 5 3
Sample Input #02

11
2 3
4 -1
5 -1
6 -1
7 8
-1 9
-1 -1
10 11
-1 -1
-1 -1
-1 -1
2
2
4
Sample Output #02

2 9 6 4 1 3 7 5 11 8 10
2 6 9 4 1 3 7 5 10 8 11
</pre>
 *
 */
public class Solution {


	private static int[] visitedNodes;
	private static int numberOfNodes;
	
	public static Solution INSTANCE = new Solution();
	
	/**
	 * Breadth First Search based swap.
	 * @param node The root node.
	 * @param height The height at which all children should be swapped
	 * @return
	 */
	public static boolean swap(Node node, int height) {
	
		Boolean swapped = Boolean.FALSE;
		if(node == null) {
			return swapped;
		}
		
		// BFS setup - a queue with the root node.
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(node);
		
		while(!queue.isEmpty()){
			
			Node current = queue.remove();		
			
			// Swap only if node is at appropriate height
			if(current.height == height){
				
				// If children are null - nothing to do.
				if(current.right == null && current.left == null) {
					continue;
				} 
				
				Node right = current.right;
				current.right = current.left;
				current.left = right;	
				swapped |= Boolean.TRUE ;
			}
			
			// If we reach a node at a greater height, the rest are also done
			// This is a side effect of BFS.
			if(current.height > height) {
				break;
			}
			visit(queue,current);
		}
		
		return swapped;

		
	}

	/**
	 * Print a tree using BFS.
	 * Use this to debug.
	 * @param node
	 */
	public static void printBFS(Node node){
		visitedNodes = new int[numberOfNodes];

		if(node == null) {
			return;			
		}
								
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(node);
		while(!queue.isEmpty()){
			Node current = queue.remove();
			if(visitedNodes[current.value -1] ==0) {
				System.out.println("Value = " + current.value + ", H="+current.height);
			}
			visit(queue,current);				
		}
		
	}
	
	/**
	 * Print a tree using in-order traversal.
	 * @param node The root node
	 */
	public static void printInorder(Node node) {		
		if(node == null) {
			return;
		}
		printInorder(node.left);
		System.out.print(node.value + " ");
		printInorder(node.right);
	}
	
	/**
	 * Helper method for BFS. 
	 * Visit will mark a node visited and add non null children to the queue
	 * @param queue
	 * @param node
	 */
	public static void visit(LinkedList<Node> queue, Node node){
	
		visitedNodes[node.value -1]=1;
		Node left = node.left;
		Node right = node.right;
		
		if(left != null){
			queue.add(left);
		}

		if(right != null) {
			queue.add(right);	
		}
	}
	
	/**
	 * Build the tree using BFS.
	 * @param tree The tree
	 * @param in The Scanner
	 */
	public static void buildTree(BinaryTree tree, Scanner in) {
		
		// Reset visited nodes.
		visitedNodes = new int[numberOfNodes];

		Node node = tree.root;
		if(node == null) {
			return;			
		}
								
		
		// BFS setup - initialize a queue and add the root node
		LinkedList<Node> queue = new LinkedList<Node>();
		node.left = newNode(in.nextInt(),node.height+1);
		node.right = newNode(in.nextInt(),node.height+1);
		visit(queue,node);

		while(!queue.isEmpty()){
			
			Node current = queue.remove();
			// Visit unvisited nodes and enqueue
			if(visitedNodes[current.value - 1] ==0){
				
				Node left = newNode(in.nextInt(),current.height+1);
				Node right = newNode(in.nextInt(),current.height+1);
				current.left = left;
				current.right = right;
				visit(queue,current);
				
			}
			
			// Update tree height.
			tree.height=current.height;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		numberOfNodes = in.nextInt();
		
		if(numberOfNodes > 0) {
			
			Node rootNode = newNode(1,1);
			
			BinaryTree tree = newTree(rootNode);			
			buildTree(tree,in);

			
			int numberOfSwaps = in.nextInt();
			
			for(int i=1; i <= numberOfSwaps; ++i) {
				int k = in.nextInt();
				for(int h=k; h<=tree.height; h=h+k){
					swap(tree.root, h);					
				}
				printInorder(tree.root);	
				System.out.println();
			}
			
		}
	}
	
	/**
	 * Helper static method to create a new Node.
	 * @param value
	 * @param height
	 * @return
	 */
	public static Node newNode(int value, int height) {
		if(value != -1) {
			Node node = INSTANCE.new Node();
			node.value = value;
			node.height = height;
			return node;
		}
		return null;
	}
	
	/**
	 * Helper static method to create a new Tree
	 * @param node
	 * @return
	 */
	public static BinaryTree newTree(Node node) {
		BinaryTree tree = INSTANCE.new BinaryTree();
		tree.root = node;
		return tree;
				
	}

	/**
	 * A Node
	 */
	public class Node {
		public Node left;
		public Node right;
		public int value;
		public int height;
	}

	/**
	 * A Binary Tree
	 */
	public class BinaryTree {
		public Node root;
		int height;
	}

}

