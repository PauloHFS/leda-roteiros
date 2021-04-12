package problems;

import util.Util;

import java.util.Arrays;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {

		if (array.length == 0) {
			return null;
		}

		int leftIndex = 0, rightIndex = array.length-1, pivotIndex = leftIndex;

		while (true) {
			pivotIndex = partition(array, leftIndex, rightIndex);
			System.out.println(rightIndex + " " + leftIndex);
			if (rightIndex - leftIndex <= 1 ) {
				if (rightIndex >= 0 && leftIndex >= 0) {
					if (array[rightIndex] < x) {
						return array[rightIndex];
					} else {
						return  array[leftIndex];
					}
				} else if (rightIndex < 0) {
					return array[leftIndex];
				} else if (leftIndex < 0) {
					return array[rightIndex];
				} else  {
					return null;
				}
			} else if (array[pivotIndex] < x) {
				leftIndex = pivotIndex + 1;
			} else if (array[pivotIndex] > x) {
				rightIndex = pivotIndex - 1;
			}
		}
	}

	private int partition(Integer[] array, int leftIndex, int rightIndex) {

		Integer pivot = array[leftIndex];

		int start = leftIndex, end = rightIndex, i = leftIndex + 1;

		while (i <= end) {
			if (array[i].compareTo(pivot) < 0) {
				Util.swap(array, i, start);
				start += 1;
				i++;
			} else if (array[i].compareTo(pivot) > 0) {
				Util.swap(array, i, end);
				end--;
			} else {
				i++;
			}
		}

		return start;
	}
}
