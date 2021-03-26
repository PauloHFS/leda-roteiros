package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

import java.util.Arrays;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex < array.length) {
			if (leftIndex < rightIndex) {
				int middleIndex = (leftIndex + rightIndex) / 2;
				sort(array, leftIndex, middleIndex);
				sort(array, middleIndex + 1, rightIndex);
				merge(array, leftIndex, middleIndex, rightIndex);
			}
		}
	}

	private void merge(T[] array, int leftIndex, int middleIndex, int rightIndex) {

		T[] arrAux = (T[]) new Comparable[array.length];

		for (int i = leftIndex; i <= rightIndex; i++) {
			arrAux[i] = array[i];
		}

		int i = leftIndex, j = middleIndex + 1, x = leftIndex;

		while (i <= middleIndex && j <= rightIndex) {
			if (arrAux[i].compareTo(arrAux[j]) < 0) {
				array[x] = arrAux[i];
				i++;
			} else {
				array[x] = arrAux[j];
				j++;
			}
			x++;
		}

		for (;i <= middleIndex; i++) {
			array[x] = arrAux[i];
			x++;
		}


		for (;j <= rightIndex; j++) {
			array[x] = arrAux[j];
			x++;
		}
	}
}
