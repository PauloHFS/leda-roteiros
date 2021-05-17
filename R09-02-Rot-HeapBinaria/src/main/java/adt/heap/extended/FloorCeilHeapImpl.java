package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		Integer floor = null;

		if (array.length != 0) {
			for (Integer num :
					array) {
				this.insert(num);
			}

			floor = this.extractRootElement();

			if (this.rootElement() != null && floor > this.rootElement()) {
				// Max Heap
				while (numero < floor) {
					floor = this.extractRootElement();
				}
			} else if (this.rootElement() != null && floor < this.rootElement()) {
				// Min Heap
				while (numero > floor && this.rootElement() <= numero) {
					floor = this.extractRootElement();
				}
			}
		}

		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		Integer ceil = null;

		if (array.length != 0) {
			for (Integer num :
					array) {
				this.insert(num);
			}

			ceil = this.extractRootElement();

			if (this.rootElement() != null && ceil > this.rootElement()) {
				// Max Heap
				while (numero < ceil) {
					ceil = this.extractRootElement();
				}
			} else if (this.rootElement() != null && ceil < this.rootElement()) {
				// Min Heap
				while (numero > ceil) {
					ceil = this.extractRootElement();
				}
			}
		}

		return ceil;
	}

}
