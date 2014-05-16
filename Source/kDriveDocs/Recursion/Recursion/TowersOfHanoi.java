// This class demonstrates the recursive method, Towers of Hanoi, which is
// a mathematical game that illustrates the power of recursion.
// The game uses three pegs and a set of different size rings with holes 
// in their centers. The game begins with all rings stacked on the leftmost
// peg from smallest at the top to largest at the bottom.
// The idea of the game is to get all the rings from the leftmost to the rightmost
// peg using all three pegs including the middle peg as a temporary holder.
// The rules for the game are as follows.
//   1. Only one ring can be moved at a time.
//   2. A larger ring cannot be placed on top of a smaller ring.
//   3. All rings must be stored on a peg except while being moved.
// Note that the complexity of the game increases as the number of rings increase.


public class TowersOfHanoi
{
	private int numRings;
	
	// Constructor receives the number of rings to use in the current game.
	public TowersOfHanoi(int n)
	{
		// Assign the number of rings
		numRings = n;
		
		// Move the number of rings from peg 1 to peg 3 using peg 2 as
		// a temporary storage location.
		moveRings(numRings, 1, 3, 2);
	}

	// The MoveRing recursive method accepts the number of rings to move,
	// the peg to move from, the peg to move to, and the temporary peg as
	// arguments. It uses recursion to display the necessary ring moves.
	private void moveRings(int num, int fromPeg, int toPeg, int tempPeg)
	{
		if (num > 0)
		{
			moveRings(num - 1, fromPeg, tempPeg, toPeg);
			System.out.println("Move a ring from peg " + fromPeg
			                   + " to peg " + toPeg);
			moveRings(num - 1, tempPeg, toPeg, fromPeg);
		}
	}
}	
	
