package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		this.last = new DoubleLinkedListNode<>();
		this.head = this.last;
	}

	@Override
	public T search(T element) {
		T result = null;
		if (!this.isEmpty()) {
			DoubleLinkedListNode<T> headAux = (DoubleLinkedListNode<T>) this.head;
			DoubleLinkedListNode<T> lastAux = (DoubleLinkedListNode<T>) this.last;

			while (headAux != lastAux && headAux.next != lastAux && !headAux.data.equals(element) && !lastAux.data.equals(element)) {
				headAux = (DoubleLinkedListNode<T>) headAux.next;
				lastAux = (DoubleLinkedListNode<T>) lastAux.previous;
			}

			if (headAux.data.equals(element)) {
				result = headAux.data;
			} else if (lastAux.data.equals(element)) {
				result = lastAux.data;
			}
		}
		return result;
	}

	@Override
	public void insert(T element) {
		DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>();
		newNode.data = element;

		newNode.previous = this.last;
		newNode.next = new DoubleLinkedListNode<>();

		if (this.last.isNIL()) {
			this.head = newNode;
		} else {
			this.last.next = newNode;
		}

		this.last = newNode;
		this.size++;
	}

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>();
		newNode.data = element;

		newNode.next = this.head;
		newNode.previous = new DoubleLinkedListNode<>();

		((DoubleLinkedListNode) this.head).previous = newNode;

		if (this.head.isNIL()) {
			this.last = newNode;
		}

		this.head = newNode;
		this.size++;
	}

	@Override
	public void remove(T element) {
		if (this.head.data.equals(element)) {
			this.removeFirst();
		} else {
			DoubleLinkedListNode<T> nodeAux = (DoubleLinkedListNode<T>) this.head;

			while (!nodeAux.isNIL() && !nodeAux.data.equals(element)) {
				nodeAux = (DoubleLinkedListNode<T>) nodeAux.next;
			}

			if (!nodeAux.isNIL()) {
				nodeAux.previous.next = nodeAux.next;
				((DoubleLinkedListNode<T>) nodeAux.next).previous = nodeAux.previous;
			}
		}
		this.size--;
	}

	@Override
	public void removeFirst() {
		if (!this.head.isNIL()) {
			this.head = this.head.next;

			if (this.head.isNIL()) {
				this.last = (DoubleLinkedListNode<T>) this.head;
			} else {
				((DoubleLinkedListNode) this.head).previous = new DoubleLinkedListNode();
			}
		}
		this.size--;
	}

	@Override
	public void removeLast() {
		if (!this.last.isNIL()) {
			this.last = this.last.previous;
			if (this.last.isNIL()) {
				this.head = this.last;
			} else {
				this.last.next = new DoubleLinkedListNode<>();
			}
		}
		this.size--;
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
