package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {
		this.data = null;
		this.next = new RecursiveSingleLinkedListImpl<>();
	}

	@Override
	public boolean isEmpty() {
		return this.data == null;
	}

	@Override
	public int size() {
		if (this.isEmpty()) {
			return 0;
		}
		return 1 + this.size();
	}

	@Override
	public T search(T element) {
		T result = null;

		if (this.data.equals(element)) {
			result = this.data;
		} else {
			result = this.next.search(element);
		}

		return result;
	}

	@Override
	public void insert(T element) {
		if (this.isEmpty()) {
			this.data = element;
			this.next = new RecursiveSingleLinkedListImpl<T>();
		} else {
			this.next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if (!this.isEmpty()) {
			if (this.data.equals(element)) {
				this.data = this.next.data;
				this.next = this.next.next;
			} else {
				this.next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		return null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
