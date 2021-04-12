package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		T element = null;

		if (!this.isEmpty()) {
			element = this.array[this.top];
		}

		return element;
	}

	@Override
	public boolean isEmpty() {
		return this.top == -1;
	}

	@Override
	public boolean isFull() {
		return this.top == this.array.length - 1;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (!this.isFull()) {
			this.array[++this.top] = element;
		} else {
			throw new StackOverflowException();
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		T result;

		if (!this.isEmpty()) {
			result = this.array[this.top--];
		} else {
			throw new StackUnderflowException();
		}

		return result;
	}

}
