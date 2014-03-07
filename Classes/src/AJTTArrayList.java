import java.lang.reflect.Array;
import java.util.Arrays;

public class AJTTArrayList <T> {
	private Object[] _array;
	AJTTArrayList() {
		this(0);
	}
	AJTTArrayList(int length) {
		_array = new Object[length];
	}
	AJTTArrayList(T[] array) {
		_array = array;
	}
	
	// single object operations
	public T get(int index) {
		if (!(index < _array.length))
			throw new ArrayIndexOutOfBoundsException();
		@SuppressWarnings("unchecked")
        final T t = (T) _array[index];
        return t;
	}
	public void set(int index, T object) {
		if (AJTTArrayList.isValidIndex(_array,index))
			throw new ArrayIndexOutOfBoundsException();
		_array[index] = object;
	}
	public void add(T object) {
		_array = AJTTArrayList.append(_array,object);
	}
	public void remove(int index) {
		if (AJTTArrayList.isValidIndex(_array,index))
			AJTTArrayList.remove(_array,index);
		else 
			throw new ArrayIndexOutOfBoundsException();
	}
	public void remove(T object) {
		remove(AJTTArrayList.indexOf(_array,object));
	}

	// Private helper methods 
	private static <T> T[] concat(T[] first, T[] second) {
	  T[] result = Arrays.copyOf(first, first.length + second.length);
	  System.arraycopy(second, 0, result, first.length, second.length);
	  return result;
	}
	private static <T> T[] append(T[] array, T object) {
		T[] result = Arrays.copyOf(array,array.length+1);
		result[result.length-1] = object;
		return result;
	}
	private static <T> boolean contains(T[] array, T object) {
		boolean result = false;
		for (T o : array) {
			if (o.equals(object))
				result = true;
		}
		return result;
	}
	private static <T> int indexOf(T[] array, T object) {
		for (int x = 0;x < array.length;x++) {
			if (array[x].equals(object)) {
				return x;
			}
		}
		return -1;
	}
	public static <T> T[] remove(T[] array,int index) {
		if (index == 0 && array.length > 1) {
			return Arrays.copyOfRange(array,1,array.length);
		}
		else if (index == 0 && array.length == 1) {
			@SuppressWarnings("unchecked")
			T[] t = (T[]) new Object[0];
			return t;
		}
		// Now that all the edge cases are taken care of 
		T[] before = Arrays.copyOfRange(array,0,index-1);
		T[] after = Arrays.copyOfRange(array,index+1,array.length);
		return AJTTArrayList.concat(before,after);
	}
	private static <T> boolean isValidIndex(T[] array, int index) {
		boolean belowUpperBound = index < array.length;
		boolean aboveLowerBound = index >= 0;
		return aboveLowerBound && belowUpperBound;
	}
}