package adt.hashtable.closed;

import adt.hashtable.hashfunction.HashFunction;
import adt.hashtable.hashfunction.HashFunctionClosedAddress;
import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionFactory;
import adt.hashtable.open.DELETED;
import util.Util;

import java.util.LinkedList;

public class HashtableClosedAddressImpl<T> extends
		AbstractHashtableClosedAddress<T> {

	/**
	 * A hash table with closed address works with a hash function with closed
	 * address. Such a function can follow one of these methods: DIVISION or
	 * MULTIPLICATION. In the DIVISION method, it is useful to change the size
	 * of the table to an integer that is prime. This can be achieved by
	 * producing such a prime number that is bigger and close to the desired
	 * size.
	 * 
	 * For doing that, you have auxiliary methods: Util.isPrime and
	 * getPrimeAbove as documented bellow.
	 * 
	 * The length of the internal table must be the immediate prime number
	 * greater than the given size (or the given size, if it is already prime). 
	 * For example, if size=10 then the length must
	 * be 11. If size=20, the length must be 23. You must implement this idea in
	 * the auxiliary method getPrimeAbove(int size) and use it.
	 * 
	 * @param desiredSize
	 * @param method
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public HashtableClosedAddressImpl(int desiredSize,
			HashFunctionClosedAddressMethod method) {
		int realSize = desiredSize;

		if (method == HashFunctionClosedAddressMethod.DIVISION) {
			realSize = this.getPrimeAbove(desiredSize); // real size must the
														// the immediate prime
														// above
		}
		initiateInternalTable(realSize);
		HashFunction function = HashFunctionFactory.createHashFunction(method,
				realSize);
		this.hashFunction = function;
	}

	// AUXILIARY
	/**
	 * It returns the prime number that is closest (and greater) to the given
	 * number.
	 * If the given number is prime, it is returned. 
	 * You can use the method Util.isPrime to check if a number is
	 * prime.
	 */
	int getPrimeAbove(int number) {

		while (!Util.isPrime(number)) {
			number++;
		}

		return number;
	}

	@Override
	public void insert(T element) {
		/*
		int hash = ((HashFunctionClosedAddress<T>) this.hashFunction).hash(element);

		LinkedList<T> elementsList = (LinkedList<T>) this.table[hash];

		if (elementsList == null) {
			elementsList = new LinkedList<T>();
			this.table[hash] = elementsList;
		} else {
			boolean containsElement = false;

			for (T e: elementsList) {
				if (e.equals(element)) {
					containsElement = true;
					break;
				}
			}

			if (!containsElement) {
				this.COLLISIONS++;
			}
		}

		elementsList.add(element);
		this.elements++;
		 */
		int hash = ((HashFunctionClosedAddress<T>) this.hashFunction).hash(element);

		if (this.table[hash] == null) {
			this.table[hash] = new LinkedList<T>();
		} else {
			boolean containsElement = false;

			for (T e: (LinkedList<T>) this.table[hash]) {
				if (e.equals(element)) {
					containsElement = true;
					break;
				}
			}

			if (!containsElement) {
				this.COLLISIONS++;
			}
		}

		((LinkedList<T>) this.table[hash]).add(element);
		this.elements++;
	}

	@Override
	public void remove(T element) {
		int hash = ((HashFunctionClosedAddress<T>) this.hashFunction).hash(element);

		LinkedList<T> elementsList = (LinkedList<T>) this.table[hash];

		if (elementsList != null) {
			if (elementsList.size() > 1) {
				this.COLLISIONS--;
			}

			elementsList.remove(element);
			this.elements--;

			if (elementsList.isEmpty()) {
				this.table[hash] = null;
			}

		}
	}

	@Override
	public T search(T element) {
		T result = null;

		int hash = ((HashFunctionClosedAddress<T>) this.hashFunction).hash(element);

		if (this.table[hash] != null) {
			boolean containsElement = false;

			for (T e: (LinkedList<T>) this.table[hash]) {
				if (e.equals(element)) {
					containsElement = true;
					break;
				}
			}

			if (containsElement) {
				result = ((LinkedList<T>) this.table[hash]).get(((LinkedList<T>) this.table[hash]).indexOf(element));
			}
		}

		return result;
	}

	@Override
	public int indexOf(T element) {
		int result = -1;

		int hash = ((HashFunctionClosedAddress<T>) this.hashFunction).hash(element);

		if (this.table[hash] != null) {
			boolean containsElement = false;

			for (T e: (LinkedList<T>) this.table[hash]) {
				if (e.equals(element)) {
					containsElement = true;
					break;
				}
			}

			if (containsElement) {
				result = hash;
			}
		}

		return result;
	}

}
