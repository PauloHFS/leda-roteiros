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

		int indexArrayA = leftIndex, indexArrayB = middleIndex + 1, indexMain = leftIndex;

		while (indexArrayA <= middleIndex && indexArrayB <= rightIndex) {
			if (arrAux[indexArrayA].compareTo(arrAux[indexArrayB]) < 0) {
				array[indexMain] = arrAux[indexArrayA];
				indexArrayA++;
			} else {
				array[indexMain] = arrAux[indexArrayB];
				indexArrayB++;
			}
			indexMain++;
		}

		for (;indexArrayA <= middleIndex; indexArrayA++) {
			array[indexMain] = arrAux[indexArrayA];
			indexMain++;
		}

		for (;indexArrayB <= rightIndex; indexArrayB++) {
			array[indexMain] = arrAux[indexArrayB];
			indexMain++;
		}
	}
}
