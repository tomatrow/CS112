/*
File Name:          Chapter15Project01.java
Programmer:         Andrew Caldwell
Date Last Modified: April. 18, 2014
Problem Statement:
	implement Random Husband Selection. Also known as RHS. 

Overall Plan:
	* Node
		* Links nodes before and after 
		* Always has non-null links 
	* DoublyCircularLinkedList
		* Make a single direction linked list
		* Make it double directional
		* Enable wrapping

Classes needed and Purpose:
main class - Chapter15Project01
DoublyCircularLinkedList - doubly wrapped linked list
Node - doubly linked node
*/

/*
Initial Plan
	* Node
		* int data
		* Node nextLink
	* normal linked list
	* wrapped linked list
		* currentNode
		* insertNode(Node node)
			* inserts node between currentNode and currentNode.nextLink
	* DoublyCircularLinkedList
*/

public class Chapter15Project01 {
	public static String iterative_Format = "Suitor %d eliminated; continue counting from %d.\n";
	public static String end_Format = "Suitor %d eliminated; %d is the lucky winner.\n";

	public static void main(String[] args) {
		// testMove();
		DoublyCircularLinkedList <Integer> list = createPrincessList(6);
		int winner = chooseWinner(list);
	}
	public static Integer chooseWinner(DoublyCircularLinkedList <Integer> list) {
		int loopCount = list.count() - 1;
		int lastLoop = loopCount - 1;
		System.out.println("Initial list of suitors; start counting from " + 1 + ".");
		for (int x = 0;x < loopCount;++x) {
			list.move(2);
			int eliminated = list.currentData();
			list.remove();
			System.out.format((x != lastLoop)?iterative_Format:end_Format, eliminated, list.currentData());
		}

		return list.currentData();
	}
	public static DoublyCircularLinkedList <Integer> createPrincessList(int n) {
		DoublyCircularLinkedList <Integer> list = new DoublyCircularLinkedList<Integer>();
		if (n < 0)
			throw new IllegalArgumentException("Princess list is positive");

		list.insertBelow(1);
		for (int x = n;x > 1;--x) {
			list.insertBelow(x);
		}

		return list;
	}
	public static void testMove() {
		DoublyCircularLinkedList <Integer> list = new DoublyCircularLinkedList<Integer>();
		list.insertBelow(new Integer(100));
		// list.insertBelow(new Integer(400));
		list.insertBelow(new Integer(300));
		list.insertBelow(new Integer(200));

		for (int x = 0;x < 9;x++) {
			System.out.println(x + " "+ list.currentData());
			list.move(1);
		}
		for (int x = 0;x < 9;x++) {
			System.out.println(x + " "+ list.currentData());
			list.move(-1);
		}
	}
}