package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	private int size;

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<>();
		this.size = 0;
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public T search(T element) {
		T result = null;

		SingleLinkedListNode<T> nodeTemp = this.getHead();

		while (nodeTemp.data != element && !nodeTemp.isNIL()) {
			nodeTemp = nodeTemp.getNext();
		}

		if (!nodeTemp.isNIL()) {
			result = nodeTemp.data;
		}

		return result;
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> nodeTemp = this.getHead();

		while (!nodeTemp.isNIL()) {
			nodeTemp = nodeTemp.getNext();
		}

		nodeTemp.data = element;
		nodeTemp.next = new SingleLinkedListNode<>();

		this.size++;
	}

	@Override
	public void remove(T element) {
		SingleLinkedListNode<T> nodeTemp = this.getHead();

		while (nodeTemp.next.data != element && !nodeTemp.isNIL()) {
			nodeTemp = nodeTemp.getNext();
		}

		if (!nodeTemp.isNIL()) {
			nodeTemp.next = nodeTemp.next.getNext();
			this.size--;
		}
	}

	@Override
	public T[] toArray() {
		T[] arr = (T[]) new Comparable[this.size];

		if (this.size != 0) {
			SingleLinkedListNode<T> nodeTemp = this.getHead();

			for (int i = 0; i < this.size; i++) {
				arr[i] = nodeTemp.data;
				nodeTemp = nodeTemp.getNext();
			}
		}

		return arr;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
