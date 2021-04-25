package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				this.data = element;
				this.next = new RecursiveDoubleLinkedListImpl<>();
				if (this.previous == null) {
					this.previous = new RecursiveDoubleLinkedListImpl<>();
				}
			} else {
				this.next.insert(element);
			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if  (element != null) {
			if (this.isEmpty()) {
				this.insert(element);
			} else {
				RecursiveDoubleLinkedListImpl<T> newNode = new RecursiveDoubleLinkedListImpl<>();
				newNode.data = this.data;
				newNode.next = this.next;

				((RecursiveDoubleLinkedListImpl<T>) this.next).previous = newNode;
				this.next = newNode;
				this.data = element;

			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			if (!this.isEmpty()) {
				if (this.data.equals(element)) {
					if (this.previous.isEmpty() && this.next.isEmpty()) {
						this.data = null;
						this.next = null;
						this.previous = null;
					} else {
						this.data = next.data;
						this.next = next.next;
						if (this.next != null) {
							((RecursiveDoubleLinkedListImpl<T>) this.next).previous = this;
						}
					}
				} else {
					this.next.remove(element);
				}
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {
			if (this.previous.isEmpty()) {
				this.data = this.next.data;
				this.next = this.next.next;
				if (this.next != null) {
					((RecursiveDoubleLinkedListImpl<T>) this.next).previous = this;
				}
			} else {
				this.previous.removeFirst();
			}
		}
	}

	@Override
	public void removeLast() {
		if (!this.isEmpty()) {
			if (this.next.isEmpty()) {
				this.data = null;
				this.next = null;

				if (this.previous.isEmpty()) {
					this.previous = null;
				}
			} else {
				((RecursiveDoubleLinkedListImpl<T>) this.next).removeLast();
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
