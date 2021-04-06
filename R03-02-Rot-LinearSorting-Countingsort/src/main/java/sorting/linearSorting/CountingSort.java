package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Voce pode assumir que o maior inteiro armazenado não chega a 100.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			Integer[] count = new Integer[100];

			for (int i = 0; i < count.length; i++) {
				count[i] = 0;
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				count[array[i]] += 1;
			}

			for (int i = 1; i < count.length; i++) {
				count[i] += count[i - 1];
			}

			Integer[] ordenada = new Integer[rightIndex + 1 - leftIndex];

			for (int i = rightIndex; i >= leftIndex; i--) {
				ordenada[count[array[i]] - 1] = array[i];
				count[array[i]]--;
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = ordenada[i];
			}
		}
	}

}
