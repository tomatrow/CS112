import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class MyMathClass <T extends Number> {
	public double standardDeviation(ArrayList<T> array) {
		double normalSum = 0;
		for (Number n : array) {
			normalSum += n.doubleValue();
		}
		double average = normalSum / array.size();
		
		double differenceSum = 0;
		for (Number n : array) {
			double squaredDifference = Math.pow(n.doubleValue() - average,2);
			differenceSum += squaredDifference;
		}

		double stdDev = Math.sqrt(differenceSum / array.size());

		return stdDev;
	}
}