/*
File Name:          Chapter11Project02.java
Programmer:         Andrew Caldwell
Date Last Modified: March. 28, 2014
Problem Statement:
	Implement a recursive sequence using java. 
Overall Plan:
	Implement handshake.
	
Classes needed and Purpose:
main class - Chapter11Project02
*/

public class Chapter11Project02 {
	public static void main(String[] args) {
		for (int x = 1;x <= 10;x++)
			System.out.println(String.format("People: %-3d Handshakes: %-3d",x,handshake(x)));
	}
	public static int handshake(int n) {
		return (n <= 1)?(0):(n-1) + handshake(n-1);
	}
}