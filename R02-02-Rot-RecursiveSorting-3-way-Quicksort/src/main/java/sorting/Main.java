package sorting;

import sorting.divideAndConquer.MergeSort;
import sorting.divideAndConquer.QuickSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AbstractSorting<Integer> s = new QuickSort<>();

        Integer[] arr = {0,9,1,8,2,7,3,6,4,5};

        System.out.println(Arrays.toString(arr));

        Integer[] cp = Arrays.copyOf(arr, arr.length);

        Arrays.sort(cp);
        s.sort(arr);
        System.out.println(Arrays.toString(cp));
        System.out.println(Arrays.toString(arr));
    }
}
