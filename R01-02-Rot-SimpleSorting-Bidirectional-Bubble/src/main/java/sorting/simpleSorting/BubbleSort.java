package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex <= array.length && rightIndex - leftIndex > 0) {
			boolean teveTroca;
			
			do {
				teveTroca = false;

				for (int i = 0; i < rightIndex; i++) {
					if (array[i].compareTo(array[i+1]) > 0) {
						Util.swap(array, i, i+1);
						teveTroca = true;
					}
				}

				rightIndex -= 1;
			} while(teveTroca);
		}
	}
}
