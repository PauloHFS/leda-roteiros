package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int kMin = array[leftIndex], kMax = array[leftIndex];

			for (int i = leftIndex + 1; i <= rightIndex; i++) {
				if (array[i] < kMin) {
					kMin = array[i];
				}
				if (array[i] > kMax) {
					kMax = array[i];
				}
			}

			Integer[] count = new Integer[kMax - kMin + 1];

			for (int i = 0; i < count.length; i++) {
				count[i] = 0;
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				count[array[i] - kMin] += 1;
			}

			for (int i = 1; i < count.length; i++) {
				count[i] += count[i - 1];
			}

			Integer[] ordenada = new Integer[rightIndex + 1 - leftIndex];

			for (int i = rightIndex; i >= leftIndex; i--) {
				ordenada[count[array[i] - kMin] - 1] = array[i];
				count[array[i] - kMin] -= 1;
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = ordenada[i];
			}
		}
	}

}
