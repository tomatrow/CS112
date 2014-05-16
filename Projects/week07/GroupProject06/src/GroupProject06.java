/*



*/
import java.util.Arrays;

public class GroupProject06 {
	public static void main(String[] args) {
		String[] array = {"a","b", "c", "a", "d", "n", "f", "s","a"};
		int n = 0;
		int count = findCharInArray(array,"a", n);
		System.out.println(count);
	}
	public static int findCharInArray(String[] array , String character, int n) {
		if (array.length == 0)
			return n;
		if (array[array.length-1].equals(character))
			n++;
		return findCharInArray(Arrays.copyOf(array,array.length - 1), character, n);
	}
}