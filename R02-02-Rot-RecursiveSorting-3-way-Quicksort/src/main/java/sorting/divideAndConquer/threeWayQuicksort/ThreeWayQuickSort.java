package sorting.divideAndConquer.threeWayQuicksort;

import sorting.AbstractSorting;
import util.Util;

public class ThreeWayQuickSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * No algoritmo de quicksort, selecionamos um elemento como pivot,
	 * particionamos o array colocando os menores a esquerda do pivot 
	 * e os maiores a direita do pivot, e depois aplicamos a mesma estrategia 
	 * recursivamente na particao a esquerda do pivot e na particao a direita do pivot. 
	 * 
	 * Considerando um array com muitos elementos repetidos, a estrategia do quicksort 
	 * pode ser otimizada para lidar de forma mais eficiente com isso. Essa melhoria 
	 * eh conhecida como quicksort tree way e consiste da seguinte ideia:
	 * - selecione o pivot e particione o array de forma que
	 *   * arr[l..i] contem elementos menores que o pivot
	 *   * arr[i+1..j-1] contem elementos iguais ao pivot.
	 *   * arr[j..r] contem elementos maiores do que o pivot. 
	 *   
	 * Obviamente, ao final do particionamento, existe necessidade apenas de ordenar
	 * as particoes contendo elementos menores e maiores do que o pivot. Isso eh feito
	 * recursivamente. 
	 **/

	private static int start, end;

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, start - 1);
			sort(array, end + 1, rightIndex);
		}
	}

	private void partition(T[] array, int leftIndex, int rightIndex) {
		T pivot = array[leftIndex];

		start = leftIndex;
		end = rightIndex;

		int i = leftIndex + 1;

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
	}
}
