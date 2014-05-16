public class QuickSort {
    
    public static void sort(double[] a) {
        sort(a,0,a.length-1);
    }
    
    private static void sort(double[] a, int begin, int end) {
        if ((end - begin) >= 1) {
            int splitPoint = split(a, begin, end);
            sort(a, begin, splitPoint);
            sort(a, splitPoint + 1, end);
        }
    }

    private static int split(double[] a, int begin, int end) {
        double splitValue = (a[begin] + a[end] + a[(end - begin + 1)/2])/3;        
        
        int up = begin - 1;
        int down = end + 1;

        while (true) {
            up++;
            while ( up < end && a[up] < splitValue) {
                up++;
            }
            down--;
            while (down>begin && a[down] > splitValue) {
                down--;
            }
            if (up < down) {
                swap(a, up, down);
            }
            else {
                return down;
            }
        }
    }

    private static void swap(double[] a, int i, int j) {
        double temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
