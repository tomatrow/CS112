/* File Name: Chess.java
   Programmer:Brian Wong
   Date: April 30, 2007

   Problem Statement:
   Create a program to play chess
   
   Overall Plan:
   1. Tell user how to use program
   2. Get input on what user wants to do and check if it is a valid command
   3. Execute command(Resign, Move, QCastle, or Castle)
   4. For Move make sure user inputs valid squares
   5. Change squares to correct integers for index of the array in Board
   6. Check if checkmate has occured
   7. Move to next turn if a legal move has been made
   8. Show the updated board
   9. End game if checkmate has occured otherwise loop to 2

   Classes needed and Purpose:'java.util' is needed for the scanner class and
   							  'Board' is needed to mantain the chess board

*/
package com.idioticdevelopment.tomatrow;
import java.util.*;
public class Chess
{
	public static void main(String[] args)
	{
		String piece;
		String rowL;
		String erowL;
		String positionI;
		String positionF;
		String useless;	
		String command;
		char Continue='y';
		char ecolumnL;
		char columnL;
		int row;
		int erow;
		int column = 0;
		int ecolumn = 0;
		int turn = 1;
		boolean turnDone=false;
		boolean skip=true;
		boolean end;
		
		//Explanation of how to use the program
		System.out.println("The commands are:");
		System.out.println("Move: To move a piece");
		System.out.println("Castle: To castle king side");
		System.out.println("QCastle: To castle queen side");
		System.out.println("Resign: To give up");
		System.out.println("The pieces starting with W are White and those starting with B are Black");
		System.out.println("Valid piece types are R,N,B,Q,K,P");
		Scanner Keyboard = new Scanner(System.in);
		System.out.println("It is white's turn first");
		System.out.println("Squares are called by the letter and nuumber");
		System.out.println("For instance, the White King starts on e1");
		Board Game = new Board();
		Game.setBoard();
		Game.showBoard();
		while(Continue=='y')
		{
			//Ask user for piece to move and square it is in and will end at
			//until valid entries are aquired
			do
			{
				skip = true;
				System.out.println("Type in a command");
				command=Keyboard.nextLine();
				//Resign command
				if(command.equalsIgnoreCase("resign"))
				{
					System.out.println("Game Over, a player has resigned");
					System.out.println("Do you want to play again?(y/n)");
					Continue=Keyboard.nextLine().charAt(0);
					if(!(Continue=='y'))
					System.exit(0);
					Game.setBoard();
					turn=1;
				}
				//Queen side castle command
				else if(command.equalsIgnoreCase("Qcastle"))
				{
					if(turn==1)
						turnDone=Game.QCastle('W');
					else
						turnDone=Game.QCastle('B');
					skip=true;
				}
				//King side castle command
				else if(command.equalsIgnoreCase("castle"))
				{
					if(turn==1)
						turnDone=Game.Castle('W');
					else
						turnDone=Game.Castle('B');
					skip=true;
				}
				//Move command
				else if(command.equalsIgnoreCase("Move"))
				{
					System.out.println("Type in the type of piece you want to move");
					piece=Keyboard.nextLine();
					System.out.println("Type in where it currently is");
					positionI=Keyboard.nextLine();
					System.out.println("Type in where you want it to go");
					positionF=Keyboard.nextLine();
					columnL=positionI.charAt(0);
					ecolumnL=positionF.charAt(0);
					rowL=positionI.substring(1,2);
					row=Integer.parseInt(rowL);
					erowL=positionF.substring(1,2);
					erow=Integer.parseInt(erowL);
					switch(columnL)
					{
						case 'A':
						case 'a':
						{
							column=0;
							break;
						}
						case 'B':
						case 'b':
						{
							column=1;
							break;
						}
						case 'C':
						case 'c':
						{
							column=2;
							break;
						}
						case 'D':
						case 'd':
						{
							column=3;
							break;
						}
						case 'E':
						case 'e':
						{
							column=4;
							break;
						}
						case 'F':
						case 'f':
						{
							column=5;
							break;
						}
						case 'G':
						case 'g':
						{
							column=6;
							break;
						}
						case 'H':
						case 'h':
						{
							column=7;
							break;
						}
						default:
						{
							System.out.println("Input move again");
							skip=false;
						}
					} 
					switch(ecolumnL)
					{
						case 'A':
						case 'a':
						{
							ecolumn=0;
							break;
						}
						case 'B':
						case 'b':
						{
							ecolumn=1;
							break;
						}
						case 'C':
						case 'c':
						{
							ecolumn=2;
							break;
						}
						case 'D':
						case 'd':
						{
							ecolumn=3;
							break;
						}
						case 'E':
						case 'e':
						{
							ecolumn=4;
							break;
						}
						case 'F':
						case 'f':
						{
							ecolumn=5;
							break;
						}
						case 'G':
						case 'g':
						{
							ecolumn=6;
							break;
						}
						case 'H':
						case 'h':
						{
							ecolumn=7;
							break;
						}
						default:
						{
							System.out.println("Input move again");
							skip=false;
						}
					}
					if(piece.length()>1)
					{
						System.out.println("Type a single character out for your piece type");
						skip=false;
					}
				if(turn==1)
				{
					piece="W"+piece;
				}
				else
					piece="B"+piece;
				row=8-row;
				erow=8-erow;
				turnDone=Game.movePiece(piece,row,column,erow,ecolumn);
				}
			}while(!skip);
			//Check for checkmate
			if(turn==0)
			end=Game.checkmate('W',Game.WKingR,Game.WKingC);
			else
			end=Game.checkmate('B',Game.BKingR,Game.BKingC);
			//Move to next turn if a valid move was made
			if(turnDone)
			turn=(turn+1)%2;
			//Display whose turn it is
			if(turn==1)
			System.out.println("It is white's turn");
			else
			System.out.println("It is black's turn");
			//Show the updated board
			Game.showBoard();
			//End game if checkmate occurs
			if(end)
			{
				System.out.println("Checkmate! Game over!");
				System.out.println("Do you want to play again?(y/n)");
				Continue=Keyboard.nextLine().charAt(0);
				if(!(Continue=='y'))
				System.exit(0);
				Game.setBoard();
				turn=1;
			}
			//Reset turnDone to false
			turnDone=false;
		}		
	}
}