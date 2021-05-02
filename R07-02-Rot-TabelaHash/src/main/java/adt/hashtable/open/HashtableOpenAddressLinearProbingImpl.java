package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;
import adt.hashtable.hashfunction.HashFunctionOpenAddress;

import java.util.LinkedList;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (element != null && !this.isFull()) {

			int hash, colisoes = 0;

			while (colisoes < this.capacity()) {
				hash = Math.abs(((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, colisoes));

				if (this.table[hash] == null || this.table[hash].equals(new DELETED())) {
					this.table[hash] = element;
					break;
				} else if (this.table[hash].equals(element)) {
					break;
				}

				colisoes++;
			}

			this.COLLISIONS += colisoes;
			this.elements++;

		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !this.isEmpty()) {

			int hash, i = 0;

			while (i < this.capacity()) {
				hash = Math.abs(((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, i));

				if (this.table[hash] != null && this.table[hash].equals(element)) {
					this.table[hash] = this.deletedElement;
					this.elements--;
					break;
				}

				i++;
			}

		}
	}

	@Override
	public T search(T element) {
		T result = null;

		if (element != null && !this.isEmpty()) {

			int hash, i = 0;

			while (i < this.capacity()) {
				hash = Math.abs(((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, i));

				if (this.table[hash] != null && this.table[hash].equals(element)) {
					result = (T) this.table[hash];
					break;
				}

				i++;
			}

		}

		return result;
	}

	@Override
	public int indexOf(T element) {
		int result = -1;

		if (element != null && !this.isEmpty()) {
			int hash, i = 0;

			while (i < this.capacity()) {
				hash = Math.abs(((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, i));

				if (this.table[hash] != null && this.table[hash].equals(element)) {
					result = hash;
					break;
				}

				i++;
			}

		}

		return result;
	}

}
