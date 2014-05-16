/* File Name: Board.java
   Programmer:Brian Wong
   Date: April 30, 2007

   Problem Statement:
   Create a class that maintains the board for a chess game
   
   Overall Plan:
   1. Create a method to set all pieces in their starting places
   2. Create a method to display the board
   3. Create a private method to see if piece input into it is in the place
   	  user says it is
   4. Create a method to decide which piece movment it should use; if it returns
      false it means no movement has taken place. This method also uses another
      method to see if a move would put their king in check. This method will
      return false if that occurs. It will aslo check for pawn promotion
   5. Create methods for the movement each individual piece
   6. Create a method to see if a square is under attack
   7. Create a method to see if a player has no legal moves left
   8. Create a method to see if queen side castling is possible and execute it
   9. Create a method to see if king side castling is possible and execute it
   10.Create a method to promote pawns

   Classes needed and Purpose:  'java.util' is needed for the scanner class

*/
package com.idioticdevelopment.tomatrow;
import java.util.*;
public class Board
{
	//Booleans to keep track of movement of rooks and kings for castling purposes
	private boolean WQR=false;
	private boolean WKR=false;
	private boolean BQR=false;
	private boolean BKR=false;
	private boolean WKM=false;
	private boolean BKM=false;
	
	//Stops king from moving if there are no legal squares
	boolean WKCM=true;
	boolean BKCM=true;
	//Where the king is, since methods may move him to test legality of a move
	int BKingR = 0, BKingC = 4, WKingR = 7, WKingC = 4;
	//The board's filled and empty spaces
	String[][] Pieces;
	//Sets up the board for the start of the game
	public void setBoard()
	{ 
		WKCM=true;
		BKCM=true;
		WQR=false;
		WKR=false;
		BQR=false;
		BKR=false;
		WKM=false;
		BKM=false;
		//8x8 board
		Pieces = new String[8][8];
		Pieces[0][0] = "BR";
		Pieces[0][1] = "BN";
		Pieces[0][2] = "BB";
		Pieces[0][3] = "BQ";
		Pieces[0][4] = "BK";
		Pieces[0][5] = "BB";
		Pieces[0][6] = "BN";
		Pieces[0][7] = "BR";
		for(int counter = 0; counter<8; counter++)
		{
			Pieces[1][counter] = "BP";
		}
		for(int counter = 0; counter<4; counter++)
		{
			for(int count = 0; count<8; count++)
			{
				Pieces[counter+2][count]="  ";
			}
		}
		for(int counter = 0; counter<8; counter++)
		{
			Pieces[6][counter] = "WP";
		}
		Pieces[7][0] = "WR";
		Pieces[7][1] = "WN";
		Pieces[7][2] = "WB";
		Pieces[7][3] = "WQ";
		Pieces[7][4] = "WK";
		Pieces[7][5] = "WB";
		Pieces[7][6] = "WN";
		Pieces[7][7] = "WR";
		
	}	
	//Shows user the board
	public void showBoard()
	{
		int side;
		System.out.println("     a   b   c   d   e   f   g   h  ");
		System.out.println("   +---+---+---+---+---+---+---+---+");
		for(int counter = 0; counter<8; counter++)
		{
			side=8-counter;
			System.out.print(" "+side+" |");
			for(int count = 0; count<8; count++)
			{
				System.out.print(" "+Pieces[counter][count]+"|");
			}
			System.out.println();
			System.out.println("   +---+---+---+---+---+---+---+---+");
		}
	}
	//Checks to see if there is in fact a piece where the user said there was so
	//so as not to create pieces from nowhere
	private boolean checkPosition(String PieceType, int row, int col)
	{
		if(Pieces[row][col].equalsIgnoreCase(PieceType))
		return true;
		else
		return false;	
	}
	//General piece movement
	public boolean movePiece(String PieceType, int row, int col, int erow, int ecol)
	{
		boolean move = false;
		char color=PieceType.charAt(0);
		//If that piece is on the square the user said, continue
		if(checkPosition(PieceType,row,col))
		{
			//Do pawn movement and promotion
			if(PieceType.equalsIgnoreCase("WP") || PieceType.equalsIgnoreCase("BP"))
			{
				move=movePawn(color,row,col,erow,ecol);
				if(color=='B' && move)
				{
					if(check(color,BKingR,BKingC,BKingR,BKingC))
					{
						Pieces[row][col]="BP";
						Pieces[erow][ecol]="  ";
						return false;
					}
				}
				else if(color=='W' && move)
				{
					if(check(color,WKingR,WKingC,WKingR,WKingC))
					{
						Pieces[row][col]="WP";
						Pieces[erow][ecol]="  ";
						return false;
					}
				}
				else
				{
					if(PieceType.equals("WP") && row==0)
					promote("W",row,col);
					else if(PieceType.equals("BP") && row==7)
					promote("B",row,col);
				}
			}
			//Do rook movement
			if(PieceType.equalsIgnoreCase("WR") || PieceType.equalsIgnoreCase("BR"))
			{
				move=moveRook(color,row,col,erow,ecol);
				if(color=='B' && move)
				{
					if(check(color,BKingR,BKingC,BKingR,BKingC))
					{
						Pieces[row][col]="BR";
						Pieces[erow][ecol]="  ";
						return false;
					}
				}
				else if(color=='W' && move)
				{
					if(check(color,WKingR,WKingC,WKingR,WKingC))
					{
						Pieces[row][col]="WR";
						Pieces[erow][ecol]="  ";
						return false;
					}
				}
			}
			//Do knight movement
			if(PieceType.equalsIgnoreCase("WN") || PieceType.equalsIgnoreCase("BN"))
			{
				move=moveKnight(color,row,col,erow,ecol);
				if(color=='B' && move)
				{
					if(check(color,BKingR,BKingC,BKingR,BKingC))
					{
						Pieces[row][col]="BN";
						Pieces[erow][ecol]="  ";
						return false;
					}
				}
				else if(color=='W' && move)
				{
					if(check(color,WKingR,WKingC,WKingR,WKingC))
					{
						Pieces[row][col]="WN";
						Pieces[erow][ecol]="  ";
						return false;
					}
				}
			}
			//Do bishop movement
			if(PieceType.equalsIgnoreCase("WB") || PieceType.equalsIgnoreCase("BB"))
			{
				move=moveBishop(color,row,col,erow,ecol);
				if(color=='B' && move)
				{
					if(check(color,BKingR,BKingC,BKingR,BKingC))
					{
						Pieces[row][col]="BB";
						Pieces[erow][ecol]="  ";
						return false;
					}
				}
				else if(color=='W' && move)
				{
					if(check(color,WKingR,WKingC,WKingR,WKingC))
					{
						Pieces[row][col]="WB";
						Pieces[erow][ecol]="  ";
						return false;
					}
				}
			}
			//Make sure that space would not lead to check and do king movement
			if(PieceType.equalsIgnoreCase("WK") || PieceType.equalsIgnoreCase("BK"))
			{
				String current = Pieces[erow][ecol];
				if(!check(color,row,col,erow,ecol))
				{
					move=moveKing(color,row,col,erow,ecol);
					if(move)
					{
						if(color=='B')
						{
							BKingR=erow;
							BKingC=ecol;
							BKM=true;
						}
						else
						{
							WKingR=erow;
							WKingC=ecol;
							WKM=true;
						}
					}
				}
				else
				{
					Pieces[erow][ecol] = current;
					return false;
				}
			}
			//Do queen movement
			if(PieceType.equalsIgnoreCase("WQ") || PieceType.equalsIgnoreCase("BQ"))
			{
				move=moveQueen(color,row,col,erow,ecol);
				if(color=='B' && move)
				{
					if(check(color,BKingR,BKingC,BKingR,BKingC))
					{
						Pieces[row][col]="BQ";
						Pieces[erow][ecol]="  ";
						return false;
					}
				}
				else if(color=='W' && move)
				{
					if(check(color,WKingR,WKingC,WKingR,WKingC))
					{
						Pieces[row][col]="WQ";
						Pieces[erow][ecol]="  ";
						return false;
					}
				}
			}
		}
		//Tell whether a move was made or not
		if(move)
		{
			WKCM=true;
			BKCM=true;
		}
		return move;
	}
	//Pawn movement
	private boolean movePawn(char color, int row, int col, int erow, int ecol)
	{
		//Stops diagonal movement unless capturing
		if(!(col==ecol))
		{
			//Black pawn captures white piece
			if((color=='B'&&Pieces[erow][ecol].charAt(0)=='W')&&(erow-row==1))
			{
				Pieces[row][col]="  ";
				Pieces[erow][ecol]="BP";
				return true;
			}
			//White pawn captures black piece
			else if((color=='W'&&Pieces[erow][ecol].charAt(0)=='B')&&(row-erow==1))
			{
				Pieces[row][col]="  ";
				Pieces[erow][ecol]="WP";
				return true;
			}
			//No capture:illegal move
			else
			return false;
		}
		//Stops movement over 2 spaces for white pawns
		else if((row-erow>2 || erow-row>0) && color=='W')
		return false;
		//Stops movement over 2 spaces for black pawns
		else if((erow-row>2 || row-erow>0) && color=='B')
		return false;
		//Limits movement of 2 spaces to starting pawns for white pawns
		else if(row-erow==2 && color=='W')
		{
			//If pawn is in starting position it can move 2 spaces
			if(row==6)
			{
				boolean empty = false;
				if(Pieces[4][ecol].equals("  ")&&Pieces[5][col].equals("  "))
				empty=true;
				else
				empty=false;
				if(empty)
				{
					Pieces[row][col]="  ";
					Pieces[erow][ecol]="WP";
					return true;
				}
				else
				return false;
			}
			//Stops movement of 2 spaces if they are not on starting square
			else
			return false;
		}
		//Limits movement of 2 spaces to starting pawns for black pawns
		else if(row-erow==2 && color=='B')
		{
			//If pawn is in starting position it can move 2 spaces
			if(row==1)
			{
				boolean empty = false;
				if(Pieces[3][ecol].equals("  ")&&Pieces[2][col].equals("  "))
				empty=true;
				else
				empty=false;
				if(empty)
				{
					Pieces[row][col]="  ";
					Pieces[erow][ecol]="BP";
					return true;
				}
				else
				return false;
			}
			//Stops movement of 2 spaces if they are not on starting square
			else
			return false;
		}
		//Check to see if space ahead is empty
		else
		{
			boolean empty = true;
			if(Pieces[erow][ecol].equals("  "))
			empty=true;
			else
			empty=false;
			if(empty)
			{
				Pieces[row][col]="  ";
				if(color=='W')
				Pieces[erow][ecol]="WP";
				else
				Pieces[erow][ecol]="BP";
				return true;
			}
			else
			return false;
		}		
	}
	//Rook movement
	private boolean moveRook(char color, int row, int col, int erow, int ecol)
	{
		//Checks for moving diagonally
		if(!(row==erow)&&!(ecol==col))
		{
			return false;
		}
		//Check is there is a same color piece at end square
		if(Pieces[erow][ecol].charAt(0)==color)
			{
				return false;
			}
		//Right horizontal movement
		else if(!(ecol==col)&&ecol-col>0)
		{
			for(int add = 1;col+add<ecol; add++)
			{
				if(!Pieces[row][col+add].equals("  "))
				{
					return false;
				}
			}
			if(color=='W')
			{
				Pieces[row][col]="  ";
				Pieces[erow][ecol]="WR";
				if(row==7 && col==1)
				WQR=true;
				else if(row==7 && col==7)
				WKR=true;
			}
			else
			{
				Pieces[row][col]="  ";
				Pieces[erow][ecol]="BR";
				if(row==0 && col==1)
				BQR=true;
				else if(row==0 && col==7)
				BKR=true;
			}
			return true;
		}
		//Left horizontal movment
		else if(!(ecol==col)&&col-ecol>0)
		{
			for(int add = 1;ecol+add<col; add++)
			{
				if(!Pieces[row][ecol+add].equals("  "))
				{
					return false;
				}
			}
			if(color=='W')
			{
				Pieces[row][col]="  ";
				Pieces[erow][ecol]="WR";
				if(row==7 && col==1)
				WQR=true;
				else if(row==7 && col==7)
				WKR=true;
			}
			else
			{
				Pieces[row][col]="  ";
				Pieces[erow][ecol]="BR";
				if(row==0 && col==1)
				BQR=true;
				else if(row==0 && col==7)
				BKR=true;
			}
			return true;
		}
		//Downwards movement
		else if(!(erow==row)&&erow-row>0)
		{
			for(int add = 1;row+add<erow; add++)
			{
				if(!Pieces[row+add][col].equals("  "))
				{
					return false;
				}
			}
			if(color=='W')
			{
				Pieces[row][col]="  ";
				Pieces[erow][ecol]="WR";
				if(row==7 && col==1)
				WQR=true;
				else if(row==7 && col==7)
				WKR=true;
			}
			else
			{
				Pieces[row][col]="  ";
				Pieces[erow][ecol]="BR";
				if(row==0 && col==1)
				BQR=true;
				else if(row==0 && col==7)
				BKR=true;
			}
			return true;
		}
		//Upwards movement
		else if(!(erow==row)&&row-erow>0)
		{
			for(int add = 1;erow+add<row; add++)
			{
				if(!Pieces[erow+add][col].equals("  "))
				{
					return false;
				}
			}
			if(color=='W')
			{
				Pieces[row][col]="  ";
				Pieces[erow][ecol]="WR";
				if(row==7 && col==1)
				WQR=true;
				else if(row==7 && col==7)
				WKR=true;
			}
			else
			{
				Pieces[row][col]="  ";
				Pieces[erow][ecol]="BR";
				if(row==0 && col==1)
				BQR=true;
				else if(row==0 && col==7)
				BKR=true;
			}
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	//Knight movement
	private boolean moveKnight(char color, int row, int col, int erow, int ecol)
	{
		//Check is there is a same color piece at end square
		if(Pieces[erow][ecol].charAt(0)==color)
		{
			return false;
		}
		if(!((((erow-row==2)||(row-erow==2))&&((ecol-col==1)||(col-ecol==1)))
		   ||(((erow-row==1)||(row-erow==1))&&((ecol-col==2)||(col-ecol==2)))))
		return false;
		else
		{
			Pieces[row][col]="  ";
			if(color=='W')
			Pieces[erow][ecol]="WN";
			else
			Pieces[erow][ecol]="BN";
			return true;
		}
	}
	//Bishop movement
	private boolean moveBishop(char color, int row, int col, int erow, int ecol)
	{
		//Checks for not moving diagonally
		if((row==erow)||(ecol==col))
		{
			return false;
		}
		//Check is there is a same color piece at end square
		if(Pieces[erow][ecol].charAt(0)==color)
		{
			return false;
		}
		if(!(erow-row==ecol-col || erow-row==col-ecol))
		return false;
		//To the right
		if(col<ecol)
		{
			//Downwards movement
			if(row<erow)
			{
				for(int add = 1; col+add<ecol && row+add<erow; add++)
				{
					if(!Pieces[row+add][col+add].equals("  "))
					{
						return false;
					}
				}
				if(color=='W')
				{
					Pieces[row][col]="  ";
					Pieces[erow][ecol]="WB";
				}
				else
				{
					Pieces[row][col]="  ";
					Pieces[erow][ecol]="BB";
				}
				return true;
			}
			//Moving up
			else if(row>erow)
			{
				for(int add = 1; col+add<ecol && erow+add<row; add++)
				{
					if(!Pieces[row-add][col+add].equals("  "))
					{
						return false;
					}
				}
				if(color=='W')
				{
					Pieces[row][col]="  ";
					Pieces[erow][ecol]="WB";
				}
				else
				{
					Pieces[row][col]="  ";
					Pieces[erow][ecol]="BB";
				}
				return true;
			}
			return false;
		}
		//To the left
		if(ecol<col)
		{
			//Down
			if(row<erow)
			{
				for(int add = 1; ecol+add<col && row+add<erow; add++)
				{
					if(!Pieces[row+add][col-add].equals("  "))
					{
						return false;
					}
				}
				if(color=='W')
				{
					Pieces[row][col]="  ";
					Pieces[erow][ecol]="WB";
				}
				else
				{
					Pieces[row][col]="  ";
					Pieces[erow][ecol]="BB";
				}
				return true;
			}
			//Up
			else if(row>erow)
			{
				for(int add = 1; ecol+add<col && erow+add<row; add++)
				{
					if(!Pieces[row-add][col-add].equals("  "))
					{
						return false;
					}
				}
				if(color=='W')
				{
					Pieces[row][col]="  ";
					Pieces[erow][ecol]="WB";
				}
				else
				{
					Pieces[row][col]="  ";
					Pieces[erow][ecol]="BB";
				}
				return true;
			}
			return false;
		}
		return false;
	}
	//King movement
	private boolean moveKing(char color, int row, int col, int erow, int ecol)
	{
		if((color=='B' && !BKCM )|| (color=='W' && !WKCM))
		{
			return false;
		}
		//Stops king from moving more than 1 square
		if((erow-row>1 || row-erow>1) || (ecol-col>1 || col-ecol>1))
		{;
			return false;
		}
		//Check if there is a same color piece at end square
		if(Pieces[erow][ecol].charAt(0)==color)
		{
			return false;
		}
		else
		{
			if(color=='W')
				{
					Pieces[row][col]="  ";
					Pieces[erow][ecol]="WK";
				}
				else
				{
					Pieces[row][col]="  ";
					Pieces[erow][ecol]="BK";
				}
				return true;
		}
		
	}
	//Queen movement
	private boolean moveQueen(char color, int row, int col, int erow, int ecol)
	{
		//Check if there is a same color piece at end square
		if(Pieces[erow][ecol].charAt(0)==color)
		{
			return false;
		}
		//If the Queen moves like a rook
		if(row==erow || col==ecol)
		{
			//Do Room movement with Queen and change final square to say BQ or WQ
			if(moveRook(color, row, col, erow, ecol))
			{
				if(color=='W')
				Pieces[erow][ecol]="WQ";
				else
				Pieces[erow][ecol]="BQ";
				return true;
			}
			return false;
		}
		else
		{
			if(moveBishop(color,row,col,erow,ecol))
			{
				if(color=='W')
				Pieces[erow][ecol]="WQ";
				else
				Pieces[erow][ecol]="BQ";
				return true;
			}
			return false;
		}
		
	}
	//Checks if a square is in check. Initial row and column are to remove king
	//so that he does not block the possible path that the enemy can take
	public boolean check(char color,int row, int col, int erow, int ecol)
	{
		String Type;
		String EColor;
		String KColor=Pieces[row][col].substring(0,1);
		
		//Check for enemy knights
		
		//Get the type of piece at square being checked
		if(erow-2>-1 && ecol-1>-1)
		{
			Type=Pieces[erow-2][ecol-1].substring(1,2);
			
			//Get the color of piece at square being checked
			EColor=Pieces[erow-2][ecol-1].substring(0,1);
			
			if(!(EColor.equals(KColor)))
			{
				//Check if square has a rook or queen
				if(Type.equals("N"))
				{
			   		//Check if it would be possible for it to reach the square
			   		if(moveKnight(EColor.charAt(0),erow-2,ecol-1,erow,ecol))
			   		{
			   			//Undo what moveKnight did
			   			Pieces[erow-2][ecol-1]=EColor+Type;
			   			Pieces[erow][ecol]="  ";
			   			Pieces[row][col]=KColor+"K";
			   			return true;
			   		}
			   		Pieces[erow-2][ecol-1]=EColor+Type;
			   		Pieces[erow][ecol]="  ";
			   		Pieces[row][col]=KColor+"K";
				}
			}
		}
		//Get the type of piece at square being checked
		if(erow-2>-1 && ecol+1<8)
		{
			Type=Pieces[erow-2][ecol+1].substring(1,2);
			
			//Get the color of piece at square being checked
			EColor=Pieces[erow-2][ecol+1].substring(0,1);
			
			if(!(EColor.equals(KColor)))
			{
				//Check if square has a rook or queen
				if(Type.equals("N"))
				{
			   		//Check if it would be possible for it to reach the square
			   		if(moveKnight(EColor.charAt(0),erow-2,ecol+1,erow,ecol))
			   		{
			   			//Undo what moveKnight did
			   			Pieces[erow-2][ecol+1]=EColor+Type;
			   			Pieces[erow][ecol]="  ";
			   			Pieces[row][col]=KColor+"K";
			   			return true;
			   		}
			   		Pieces[erow-2][ecol+1]=EColor+Type;
			   		Pieces[erow][ecol]="  ";
			   		Pieces[row][col]=KColor+"K";
				}
			}
		}
		//Get the type of piece at square being checked
		if(erow-1>-1 && ecol-2>-1)
		{
			Type=Pieces[erow-1][ecol-2].substring(1,2);
			
			//Get the color of piece at square being checked
			EColor=Pieces[erow-1][ecol-2].substring(0,1);
			
			if(!(EColor.equals(KColor)))
			{
				//Check if square has a rook or queen
				if(Type.equals("N"))
				{
			   		//Check if it would be possible for it to reach the square
			   		if(moveKnight(EColor.charAt(0),erow-1,ecol-2,erow,ecol))
			   		{
			   			//Undo what moveKnight did
			   			Pieces[erow-1][ecol-2]=EColor+Type;
			   			Pieces[erow][ecol]="  ";
			   			Pieces[row][col]=KColor+"K";
			   			return true;
			   		}
			   		Pieces[erow-1][ecol-2]=EColor+Type;
			   		Pieces[erow][ecol]="  ";
			   		Pieces[row][col]=KColor+"K";
				}
			}
		}
		//Get the type of piece at square being checked
		if(erow-1>-1 && ecol+2<8)
		{
			Type=Pieces[erow-1][ecol+2].substring(1,2);
			
			//Get the color of piece at square being checked
			EColor=Pieces[erow-1][ecol+2].substring(0,1);
			
			if(!(EColor.equals(KColor)))
			{
				//Check if square has a rook or queen
				if(Type.equals("N"))
				{
			   		//Check if it would be possible for it to reach the square
			   		if(moveKnight(EColor.charAt(0),erow-1,ecol+2,erow,ecol))
			   		{
			   			//Undo what moveKnight did
			   			Pieces[erow-1][ecol+2]=EColor+Type;
			   			Pieces[erow][ecol]="  ";
			   			Pieces[row][col]=KColor+"K";
			   			return true;
			   		}
			   		Pieces[erow-1][ecol+2]=EColor+Type;
			   		Pieces[erow][ecol]="  ";
			   		Pieces[row][col]=KColor+"K";
				}
			}
		}
		//Get the type of piece at square being checked
		if(erow+1<8 && ecol-2>-1)
		{
			Type=Pieces[erow+1][ecol-2].substring(1,2);
			
			//Get the color of piece at square being checked
			EColor=Pieces[erow+1][ecol-2].substring(0,1);
			
			if(!(EColor.equals(KColor)))
			{
				//Check if square has a rook or queen
				if(Type.equals("N"))
				{
			   		//Check if it would be possible for it to reach the square
			   		if(moveKnight(EColor.charAt(0),erow+1,ecol-2,erow,ecol))
			   		{
			   			//Undo what moveKnight did
			   			Pieces[erow+1][ecol-2]=EColor+Type;
			   			Pieces[erow][ecol]="  ";
			   			Pieces[row][col]=KColor+"K";
			   			return true;
			   		}
			   		Pieces[erow+1][ecol-2]=EColor+Type;
			   		Pieces[erow][ecol]="  ";
			   		Pieces[row][col]=KColor+"K";
				}
			}
		}
		//Get the type of piece at square being checked
		if(erow+1<8 && ecol+2<8)
		{
			Type=Pieces[erow+1][ecol+2].substring(1,2);
			
			//Get the color of piece at square being checked
			EColor=Pieces[erow+2][ecol+2].substring(0,1);
			
			if(!(EColor.equals(KColor)))
			{
				//Check if square has a rook or queen
				if(Type.equals("N"))
				{
			   		//Check if it would be possible for it to reach the square
			   		if(moveKnight(EColor.charAt(0),erow+1,ecol+2,erow,ecol))
			   		{
			   			//Undo what moveKnight did
			   			Pieces[erow+1][ecol+2]=EColor+Type;
			   			Pieces[erow][ecol]="  ";
			   			Pieces[row][col]=KColor+"K";
			   			return true;
			   		}
			   		Pieces[erow+1][ecol+2]=EColor+Type;
			   		Pieces[erow][ecol]="  ";
			   		Pieces[row][col]=KColor+"K";
				}
			}
		}
		//Get the type of piece at square being checked
		if(erow+2<8 && ecol-1>-1)
		{
			Type=Pieces[erow+2][ecol-1].substring(1,2);
			
			//Get the color of piece at square being checked
			EColor=Pieces[erow+2][ecol-1].substring(0,1);
			
			if(!(EColor.equals(KColor)))
			{
				//Check if square has a rook or queen
				if(Type.equals("N"))
				{
			   		//Check if it would be possible for it to reach the square
			   		if(moveKnight(EColor.charAt(0),erow+2,ecol-1,erow,ecol))
			   		{
			   			//Undo what moveKnight did
			   			Pieces[erow+2][ecol-1]=EColor+Type;
			   			Pieces[erow][ecol]="  ";
			   			Pieces[row][col]=KColor+"K";
			   			return true;
			   		}
			   		Pieces[erow+2][ecol-1]=EColor+Type;
			   		Pieces[erow][ecol]="  ";
			   		Pieces[row][col]=KColor+"K";
				}
			}
		}
		//Get the type of piece at square being checked
		if(erow+2<8 && ecol+1<8)
		{
			Type=Pieces[erow+2][ecol+1].substring(1,2);
			
			//Get the color of piece at square being checked
			EColor=Pieces[erow+2][ecol+1].substring(0,1);
			
			if(!(EColor.equals(KColor)))
			{
				//Check if square has a rook or queen
				if(Type.equals("N"))
				{
			   		//Check if it would be possible for it to reach the square
			   		if(moveKnight(EColor.charAt(0),erow+2,ecol+1,erow,ecol))
			   		{
			   			//Undo what moveKnight did
			   			Pieces[erow+2][ecol=1]=EColor+Type;
			   			Pieces[erow][ecol]="  ";
			   			Pieces[row][col]=KColor+"K";
			   			return true;
			   		}
			   		Pieces[erow+2][ecol+1]=EColor+Type;
			   		Pieces[erow][ecol]="  ";
			   		Pieces[row][col]=KColor+"K";
				}
			}
		}
		//Check for enemy rooks and queens to the sides
		for(int count = 0; count<8; count++)
		{
			//Get the type of piece at square being checked
			Type=Pieces[erow][count].substring(1,2);
			
			//Get the color of piece at square being checked
			EColor=Pieces[erow][count].substring(0,1);
			if(!(EColor.equals(KColor)))
			{
				//Check if square has a rook or queen
				if(Type.equals("R") || Type.equals("Q"))
				{
			   		//Empty king's square so he doesn't get in the way of the check
			   		Pieces[row][col]="  ";
			   		
			   		//Check if it would be possible for it to reach the square
			   		if(moveRook(EColor.charAt(0),erow,count,erow,ecol))
			   		{
			   			//Undo what moveRook did
			   			Pieces[erow][count]=EColor+Type;
			   			Pieces[erow][ecol]="  ";
			   			Pieces[row][col]=KColor+"K";
		   				return true;
		   			}
		   			Pieces[erow][count]=EColor+Type;
			   		Pieces[erow][ecol]="  ";
			   		Pieces[row][col]=KColor+"K";
				}
			}
		}
		
		//Check for enemy rooks and queens above and below
		for(int count = 0; count<8; count++)
		{
			//Get the type of piece at square being checked
			Type=Pieces[count][ecol].substring(1,2);
			
			//Get the color of piece at square being checked
			EColor=Pieces[count][ecol].substring(0,1);
			
			if(!EColor.equals(KColor))
			{
				//Check if square has a rook or queen
				if(Type.equals("R") || Type.equals("Q"))
				{
			   		//Empty king's square so he doesn't get in the way of the check
			   		Pieces[row][col]="  ";
			   			
			   		//Check if it would be possible for it to reach the square
			   		if(moveRook(EColor.charAt(0),count,ecol,erow,ecol))
			   		{
			   			//Undo what moveRook did
			   			Pieces[count][ecol]=EColor+Type;
			   			Pieces[erow][ecol]="  ";
			   			Pieces[row][col]=KColor+"K";
			   			return true;
			   		}
			   		Pieces[count][ecol]=EColor+Type;
			   		Pieces[erow][ecol]="  ";
			   		Pieces[row][col]=KColor+"K";
				}
			}
		}
		
		//Check upper right for bishops and queens
		for(int count = 1; ecol+count<8 && erow+count<8; count++)
		{
			//Get the type of piece at square being checked
			Type=Pieces[erow+count][ecol+count].substring(1,2);
			
			//Get the color of piece at square being checked
			EColor=Pieces[erow+count][ecol+count].substring(0,1);
			
			if(!EColor.equals(KColor))
			{
				//Check if square has a bishop or queen
				if(Type.equals("B") || Type.equals("Q"))
				{
					//Empty king's square so he doesn't get in the way of the check
			   		Pieces[row][col]="  ";
			   		
					if(moveBishop(EColor.charAt(0),erow+count,ecol+count,erow,ecol))
			   		{
			   			//Undo what moveBishop did
			   			Pieces[erow+count][ecol+count]=EColor+Type;
			   			Pieces[erow][ecol]="  ";
			   			Pieces[row][col]=KColor+"K";
			   			return true;
			   		}
			   		Pieces[erow+count][ecol+count]=EColor+Type;
			   		Pieces[erow][ecol]="  ";
			   		Pieces[row][col]=KColor+"K";
				}
			}
		}
		
		//Check lower right for bishops and queens
		for(int count = 1; ecol+count<8 && erow-count>0; count++)
		{
			//Get the type of piece at square being checked
			Type=Pieces[erow-count][ecol+count].substring(1,2);
			
			//Get the color of piece at square being checked
			EColor=Pieces[erow-count][ecol+count].substring(0,1);
			
			if(!EColor.equals(KColor))
			{
				if(Type.equals("B") || Type.equals("Q"))
				{
					//Empty king's square so he doesn't get in the way of the check
			   		Pieces[row][col]="  ";
			   		
					if(moveBishop(EColor.charAt(0),erow-count,ecol+count,erow,ecol))
			   		{
			   			//Undo what moveBishop did
			   			Pieces[erow-count][ecol+count]=EColor+Type;
			   			Pieces[erow][ecol]="  ";
			   			Pieces[row][col]=KColor+"K";
			   			return true;
			   		}
			   		Pieces[erow-count][ecol+count]=EColor+Type;
			   		Pieces[erow][ecol]="  ";
			   		Pieces[row][col]=KColor+"K";
				}
			}
		}
		//Check upper left for bishops and queens
		for(int count = 1; ecol-count>0 && erow+count<8; count++)
		{
			//Get the type of piece at square being checked
			Type=Pieces[erow+count][ecol-count].substring(1,2);
			
			//Get the color of piece at square being checked
			EColor=Pieces[erow+count][ecol-count].substring(0,1);
			
			if(!EColor.equals(KColor))
			{
				if(Type.equals("B") || Type.equals("Q"))
				{
					//Empty king's square so he doesn't get in the way of the check
			   		Pieces[row][col]="  ";
			   		
					if(moveBishop(EColor.charAt(0),erow+count,ecol-count,erow,ecol))
			   		{
			   			//Undo what moveBishop did
			   			Pieces[erow+count][ecol-count]=EColor+Type;
			   			Pieces[erow][ecol]="  ";
			   			Pieces[row][col]=KColor+"K";
			   			return true;
			   		}
			   		Pieces[erow+count][ecol-count]=EColor+Type;
			   		Pieces[erow][ecol]="  ";
			   		Pieces[row][col]=KColor+"K";
				}
			}
		}
		//Check lower left for bishops and queens
		for(int count = 1; ecol-count>0 && erow-count>0; count++)
		{
			//Get the type of piece at square being checked
			Type=Pieces[erow-count][ecol-count].substring(1,2);
			
			//Get the color of piece at square being checked
			EColor=Pieces[erow-count][ecol-count].substring(0,1);
			
			if(!EColor.equals(KColor))
			{
				if(Type.equals("B") || Type.equals("Q"))
				{
					//Empty king's square so he doesn't get in the way of the check
			   		Pieces[row][col]="  ";
			   		
					if(moveBishop(EColor.charAt(0),erow-count,ecol-count,erow,ecol))
			   		{
		   				//Undo what moveBishop did
		   				Pieces[erow-count][ecol-count]=EColor+Type;
		   				Pieces[erow][ecol]="  ";
		   				Pieces[row][col]=KColor+"K";
		   				return true;
		   			}
		   			Pieces[erow-count][ecol-count]=EColor+Type;
			   		Pieces[erow][ecol]="  ";
			   		Pieces[row][col]=KColor+"K";
				}
			}
		}
		//Check for pawns
		{
			if(erow-1>-1 && ecol-1>-1)
			{
				//Get the type of piece at square being checked
				Type=Pieces[erow-1][ecol-1].substring(1,2);
				
				//Get the color of piece at square being checked
				EColor=Pieces[erow-1][ecol-1].substring(0,1);
				if(!EColor.equals(KColor))
				{
					if(Type.equals("P"))
					{
						//Place a piece to see if pawn threatens that square
				   		Pieces[erow][ecol]=KColor+"K";
				   		
						if(movePawn(EColor.charAt(0),erow-1,ecol-1,erow,ecol))
				   		{
				   			//Undo what movePawn did
				   			Pieces[erow-1][ecol-1]=EColor+Type;
				   			Pieces[erow][ecol]="  ";
				   			Pieces[row][col]=KColor+"K";
				   			return true;
				   		}
				   		Pieces[erow-1][ecol-1]=EColor+Type;
				   		Pieces[erow][ecol]="  ";
				   		Pieces[row][col]=KColor+"K";
					}
				}
			}
			if(erow+1<8 && ecol+1<8)
			{
				//Get the type of piece at square being checked
				Type=Pieces[erow+1][ecol+1].substring(1,2);
				
				//Get the color of piece at square being checked
				EColor=Pieces[erow+1][ecol+1].substring(0,1);
				if(!EColor.equals(KColor))
				{
					if(Type.equals("P"))
					{
						//Place a piece to see if pawn threatens that square
				   		Pieces[erow][ecol]=KColor+"K";
				   		
						if(movePawn(EColor.charAt(0),erow+1,ecol+1,erow,ecol))
				   		{
				   			//Undo what movePawn did
				   			Pieces[erow+1][ecol+1]=EColor+Type;
				   			Pieces[erow][ecol]="  ";
				   			Pieces[row][col]=KColor+"K";
				   			return true;
				   		}
				   		Pieces[erow+1][ecol+1]=EColor+Type;
				   		Pieces[erow][ecol]="  ";
				   		Pieces[row][col]=KColor+"K";
					}
				}
			}
			if(erow+1<8 && ecol-1>-1)
			{
				//Get the type of piece at square being checked
				Type=Pieces[erow+1][ecol-1].substring(1,2);
				
				//Get the color of piece at square being checked
				EColor=Pieces[erow+1][ecol-1].substring(0,1);
				if(!EColor.equals(KColor))
				{
					if(Type.equals("P"))
					{
						//Place a piece to see if pawn threatens that square
				   		Pieces[erow][ecol]=KColor+"K";
				   		
						if(movePawn(EColor.charAt(0),erow+1,ecol-1,erow,ecol))
				   		{
				   			//Undo what movePawn did
				   			Pieces[erow+1][ecol-1]=EColor+Type;
				   			Pieces[erow][ecol]="  ";
				   			Pieces[row][col]=KColor+"K";
				   			return true;
				   		}
				   		Pieces[erow+1][ecol-1]=EColor+Type;
				   		Pieces[erow][ecol]="  ";
				   		Pieces[row][col]=KColor+"K";
					}
				}
			}
			if(erow-1>-1 && ecol+1<8)
			{
				//Get the type of piece at square being checked
				Type=Pieces[erow-1][ecol+1].substring(1,2);
				
				//Get the color of piece at square being checked
				EColor=Pieces[erow-1][ecol+1].substring(0,1);
				if(!EColor.equals(KColor))
				{
					if(Type.equals("P"))
					{
						//Place a piece to see if pawn threatens that square
				   		Pieces[erow][ecol]=KColor+"K";
				   		
						if(movePawn(EColor.charAt(0),erow-1,ecol+1,erow,ecol))
				   		{
				   			//Undo what movePawn did
				   			Pieces[erow-1][ecol+1]=EColor+Type;
				   			Pieces[erow][ecol]="  ";
				   			Pieces[row][col]=KColor+"K";
				   			return true;
				   		}
				   		Pieces[erow-1][ecol+1]=EColor+Type;
				   		Pieces[erow][ecol]="  ";
				   		Pieces[row][col]=KColor+"K";
					}
				}
			}
		}
		//Check for enemy kings
		if(ecol+1<8)
		{
			//Get the type of piece at square being checked
			Type=Pieces[erow][ecol+1].substring(1,2);
			
			//Get the color of piece at square being checked			
			EColor=Pieces[erow][ecol+1].substring(0,1);
			
			if(!EColor.equals(KColor))
			{
				//Check if square has a king
				if(Type.equals("K"))
				{
					//Empty king's square so he doesn't get in the way of the check
				   	Pieces[row][col]="  ";
				   		
				   	//Check if it would be possible for it to reach the square
				   	if(moveKing(EColor.charAt(0),erow,ecol+1,erow,ecol))
				   	{
				   		//Undo what moveKing did
				   		Pieces[erow][ecol+1]=EColor+Type;
				   		Pieces[erow][ecol]="  ";
				   		Pieces[row][col]=KColor+"K";
				   		return true;
				   	}
				   	Pieces[erow][ecol+1]=EColor+Type;
				   	Pieces[erow][ecol]="  ";
				  	Pieces[row][col]=KColor+"K";
				}
			}
		}
		if(ecol-1>-1)
		{
			//Get the type of piece at square being checked
			Type=Pieces[erow][ecol-1].substring(1,2);
			
			//Get the color of piece at square being checked			
			EColor=Pieces[erow][ecol-1].substring(0,1);
			
			if(!EColor.equals(KColor))
			{
				//Check if square has a king
				if(Type.equals("K"))
				{
					//Empty king's square so he doesn't get in the way of the check
				   	Pieces[row][col]="  ";
				   		
				   	//Check if it would be possible for it to reach the square
				   	if(moveKing(EColor.charAt(0),erow,ecol-1,erow,ecol))
				   	{
				   		//Undo what moveKing did
				   		Pieces[erow][ecol-1]=EColor+Type;
				   		Pieces[erow][ecol]="  ";
				   		Pieces[row][col]=KColor+"K";
				   		return true;
				   	}
				   	Pieces[erow][ecol-1]=EColor+Type;
				   	Pieces[erow][ecol]="  ";
				   	Pieces[row][col]=KColor+"K";
				}
			}
		}
		if(erow+1<8 && ecol+1<8)
		{
			//Get the type of piece at square being checked
			Type=Pieces[erow+1][ecol+1].substring(1,2);
			
			//Get the color of piece at square being checked			
			EColor=Pieces[erow+1][ecol+1].substring(0,1);
			
			if(!EColor.equals(KColor))
			{
				//Check if square has a king
				if(Type.equals("K"))
				{
					//Empty king's square so he doesn't get in the way of the check
				   	Pieces[row][col]="  ";
				   		
				   	//Check if it would be possible for it to reach the square
				   	if(moveKing(EColor.charAt(0),erow+1,ecol+1,erow,ecol))
				   	{
				   		//Undo what moveKing did
				   		Pieces[erow+1][ecol+1]=EColor+Type;
				   		Pieces[erow][ecol]="  ";
				   		Pieces[row][col]=KColor+"K";
				   		return true;
				   	}
				   	Pieces[erow+1][ecol+1]=EColor+Type;
				   	Pieces[erow][ecol]="  ";
				   	Pieces[row][col]=KColor+"K";
				}
			}
		}
		if(erow-1>-1 && ecol+1<8)
		{
			//Get the type of piece at square being checked
			Type=Pieces[erow-1][ecol+1].substring(1,2);
			
			//Get the color of piece at square being checked			
			EColor=Pieces[erow-1][ecol+1].substring(0,1);
			
			if(!EColor.equals(KColor))
			{
				//Check if square has a king
				if(Type.equals("K"))
				{
					//Empty king's square so he doesn't get in the way of the check
				   	Pieces[row][col]="  ";
				   		
				   	//Check if it would be possible for it to reach the square
				   	if(moveKing(EColor.charAt(0),erow-1,ecol+1,erow,ecol))
				   	{
				   		//Undo what moveKing did
				   		Pieces[erow-1][ecol+1]=EColor+Type;
				   		Pieces[erow][ecol]="  ";
				   		Pieces[row][col]=KColor+"K";
				   		return true;
				   	}
				   	Pieces[erow-1][ecol+1]=EColor+Type;
				   	Pieces[erow][ecol]="  ";
				   	Pieces[row][col]=KColor+"K";
				}
			}
		}
		if(erow+1<8 && ecol-1>-1)
		{
			//Get the type of piece at square being checked
			Type=Pieces[erow+1][ecol-1].substring(1,2);
			
			//Get the color of piece at square being checked			
			EColor=Pieces[erow+1][ecol-1].substring(0,1);
			
			if(!EColor.equals(KColor))
			{
				//Check if square has a king
				if(Type.equals("K"))
				{
					//Empty king's square so he doesn't get in the way of the check
				   	Pieces[row][col]="  ";
				   		
				   	//Check if it would be possible for it to reach the square
				   	if(moveKing(EColor.charAt(0),erow+1,ecol-1,erow,ecol))
				   	{
				   		//Undo what moveKing did
				   		Pieces[erow+1][ecol-1]=EColor+Type;
				   		Pieces[erow][ecol]="  ";
				   		Pieces[row][col]=KColor+"K";
				   		return true;
				   	}
				   	Pieces[erow+1][ecol-1]=EColor+Type;
				   	Pieces[erow][ecol]="  ";
				   	Pieces[row][col]=KColor+"K";
				}
			}
		}
		if(erow-1>-1 && ecol-1>-1)
		{
			//Get the type of piece at square being checked
			Type=Pieces[erow-1][ecol-1].substring(1,2);
			
			//Get the color of piece at square being checked			
			EColor=Pieces[erow-1][ecol-1].substring(0,1);
			
			if(!EColor.equals(KColor))
			{
				//Check if square has a king
				if(Type.equals("K"))
				{
					//Empty king's square so he doesn't get in the way of the check
				   	Pieces[row][col]="  ";
				   		
				   	//Check if it would be possible for it to reach the square
				   	if(moveKing(EColor.charAt(0),erow-1,ecol-1,erow,ecol))
				   	{
				   		//Undo what moveKing did
				   		Pieces[erow-1][ecol-1]=EColor+Type;
				   		Pieces[erow][ecol]="  ";
				   		Pieces[row][col]=KColor+"K";
				   		return true;
				   	}
				   	Pieces[erow-1][ecol-1]=EColor+Type;
				   	Pieces[erow][ecol]="  ";
				   	Pieces[row][col]=KColor+"K";
				}
			}
		}
		if(erow+1<8)
		{
			//Get the type of piece at square being checked
			Type=Pieces[erow+1][ecol].substring(1,2);
			
			//Get the color of piece at square being checked			
			EColor=Pieces[erow+1][ecol].substring(0,1);
			
			if(!EColor.equals(KColor))
			{
				//Check if square has a king
				if(Type.equals("K"))
				{
					//Empty king's square so he doesn't get in the way of the check
				   	Pieces[row][col]="  ";
				   		
				   	//Check if it would be possible for it to reach the square
				   	if(moveKing(EColor.charAt(0),erow+1,ecol,erow,ecol))
				   	{
				   		//Undo what moveKing did
				   		Pieces[erow+1][ecol]=EColor+Type;
				   		Pieces[erow][ecol]="  ";
				   		Pieces[row][col]=KColor+"K";
				   		return true;
				   	}
				   	Pieces[erow+1][ecol]=EColor+Type;
				   	Pieces[erow][ecol]="  ";
				   	Pieces[row][col]=KColor+"K";
				}
			}
		}
		if(erow-1>-1)
		{
			//Get the type of piece at square being checked
			Type=Pieces[erow-1][ecol].substring(1,2);
			
			//Get the color of piece at square being checked			
			EColor=Pieces[erow-1][ecol].substring(0,1);
			
			if(!EColor.equals(KColor))
			{
				//Check if square has a king
				if(Type.equals("K"))
				{
					//Empty king's square so he doesn't get in the way of the check
				   	Pieces[row][col]="  ";
				   		
				   	//Check if it would be possible for it to reach the square
				   	if(moveKing(EColor.charAt(0),erow-1,ecol,erow,ecol))
				   	{
				   		//Undo what moveKing did
				   		Pieces[erow-1][ecol]=EColor+Type;
				   		Pieces[erow][ecol]="  ";
				   		Pieces[row][col]=KColor+"K";
				   		return true;
				   	}
				   	Pieces[erow-1][ecol]=EColor+Type;
				   	Pieces[erow][ecol]="  ";
				   	Pieces[row][col]=KColor+"K";
				}
			}
		}
		return false;
	}
	//Checks for checkmate
	public boolean checkmate(char color, int erow, int ecol)
	{
		boolean danger;
		boolean escape;
		String fix=Pieces[0][0];
		String KColor=Pieces[erow][ecol].substring(0,1);
		String current;
		int order = 0;
		int[] DangerRow = new int[8];
		int[] DangerCol = new int[8];
		//Check if king's square is in danger
		danger=check(color, erow, ecol, erow, ecol);
		if(danger)
		{
			//Check if he could move away safely
			for(int count = 0;count < 8; count++)
			{
				for(int counter = 0; counter<8; counter++)
				{
					current=Pieces[count][counter];
					if(moveKing(color, erow, ecol, count, counter))
					{
						if(!check(color,erow,ecol,count,counter))
						{
							//Put pieces back where they were
							Pieces[erow][ecol]=KColor+"K";
							Pieces[count][counter]=current;
							return false;
						}
						else
						{
							//Set that square as dangerous
							DangerRow[order]=count;
							DangerCol[order]=counter;
							Pieces[erow][ecol]=KColor+"K";
							Pieces[count][counter]=current;
							order++;
						}
					}
				}
			}
			if(color=='W')
				WKCM=false;
			else
				BKCM=false;
			
			String Type;
			String Type2;
			
			//Check if pieces can intervene in the danger squares
			for(order = 0; order < 8; order++)
			{
				for(int count = 0;count < 8; count++)
				{
					for(int counter = 0; counter<8; counter++)
					{
						if(Pieces[count][counter].charAt(0)==color)
						{
							Type=Pieces[count][counter];
							Type2=Pieces[DangerRow[order]][DangerCol[order]];
							
							if(movePiece(Pieces[count][counter],count,counter,DangerRow[order],DangerCol[order]))
							{
								//See if that makes king safe
								if(check(color,erow,ecol,erow,ecol))
								{
									System.out.println("Replacing "+Pieces[count][counter]+" with "+Type+" at"+count+" "+counter);
									Pieces[count][counter]=Type;
									System.out.println("Replacing "+Pieces[DangerRow[order]][DangerCol[order]]+" with "+Type2+" at"+DangerRow[order]+" "+DangerCol[order]);
									Pieces[DangerRow[order]][DangerCol[order]]=Type2;
									return false;
								}
							}
							Pieces[count][counter]=Type;
							Pieces[DangerRow[order]][DangerCol[order]]=Type2;
						}
					}
				}
			}
			return true;
		}
		Pieces[0][0]=fix;
		return false;
	}
	//Queen side castling
	public boolean QCastle(char color)
	{
		if(color=='W')
		{
			//Checks if spaces inbetween are empty and that neither king nor rook has moved yet
			if(Pieces[7][0].equals("WR") && Pieces[7][1].equals("  ")  && Pieces[7][2].equals("  ")
			   && Pieces[7][3].equals("  ") && Pieces[7][4].equals("WK")
			   && !check('W',7,4,7,2) && !check('W',7,4,7,3)&&!WQR&&!WKM)
			{
				Pieces[7][0]="  ";
				Pieces[7][2]="WK";
				Pieces[7][3]="WR";
				Pieces[7][4]="  ";
				WKingC=2;
				return true;
			}
		}
		else
		{
			//Checks if spaces inbetween are empty and that neither king nor rook has moved yet
			if(Pieces[0][0].equals("BR") && Pieces[0][1].equals("  ")  && Pieces[0][2].equals("  ")
			   && Pieces[0][3].equals("  ") && Pieces[0][4].equals("BK")
			   && !check('W',0,4,0,2) && !check('W',0,4,0,3)&&!BQR&&!BKM)
			{
				Pieces[0][0]="  ";
				Pieces[0][2]="BK";
				Pieces[0][3]="BR";
				Pieces[0][4]="  ";
				BKingC=2;
				return true;
			}
		}
		return false;
	}
	//King side castling
	public boolean Castle(char color)
	{
		//Checks if it is a white or black king attempting
		if(color=='W')
		{
			//Checks if spaces inbetween are empty and that neither king nor rook has moved yet
			if(Pieces[7][4].equals("WK") && Pieces[7][5].equals("  ")  && Pieces[7][6].equals("  ")
			   && Pieces[7][7].equals("WR") && !check('W',7,4,7,5) && !check('W',7,4,7,6)&&!WKR&&!WKM)
			{
				Pieces[7][4]="  ";
				Pieces[7][5]="WR";
				Pieces[7][6]="WK";
				Pieces[7][7]="  ";
				WKingC=6;
				return true;
			}
		}
		else
		{
			//Checks if spaces inbetween are empty and that neither king nor rook has moved yet
			if(Pieces[0][4].equals("BK") && Pieces[0][5].equals("  ")  && Pieces[0][6].equals("  ")
			   && Pieces[0][7].equals("BR") && !check('B',0,4,0,5) && !check('B',0,4,0,6)&&!BKR&&!BKM)
			{
				Pieces[0][4]="  ";
				Pieces[0][5]="BK";
				Pieces[0][6]="BK";
				Pieces[0][7]="  ";
				BKingC=6;
				return true;
			}
		}
		return false;
	}
	//Promotes pawns
	public void promote(String color,int row, int col)
	{
		char piece;
		String Piece;
		Scanner Keyboard = new Scanner(System.in);
		//Repeat until user specifies a valid peice
		while(true)
		{
			System.out.println("What kind of piece do you want?");
			Piece=Keyboard.nextLine();
			piece=Piece.charAt(1);
			Piece=color+Piece;
			//If a correct piece is specified replace the pawn with it
			if(piece=='Q' || piece=='B' || piece=='N' || piece=='R')
			Pieces[row][col]=Piece;
			else
			System.out.println("Put in Q, B, N, or R");
		}
	}
}