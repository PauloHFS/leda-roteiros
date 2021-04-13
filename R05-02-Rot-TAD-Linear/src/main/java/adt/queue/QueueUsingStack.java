package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;
	private int elements;
	private final int size;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
		this.elements = 0;
		this.size = size;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (!this.isFull()) {

			try {
				this.stack1.push(element);
				this.elements++;

			} catch (StackOverflowException e) {
				throw new QueueOverflowException();
			}

		} else {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T element = null;

		if (!this.isEmpty()) {
			if (this.stack2.isEmpty()) {

				while (!this.stack1.isEmpty()) {
					try {
						this.stack2.push(this.stack1.pop());

					} catch (StackOverflowException e) {
						e.printStackTrace();
					} catch (StackUnderflowException e) {
						throw new QueueUnderflowException();
					}
				}

			}

			try {
				element = this.stack2.pop();
				this.elements--;

			} catch (StackUnderflowException e) {
				throw new QueueUnderflowException();
			}

		}

		return element;
	}

	@Override
	public T head() {
		T element = null;

		if (!this.isEmpty()) {
			if (this.stack2.isEmpty()) {
				while (!this.stack1.isEmpty()) {
					try {
						this.stack2.push(this.stack1.pop());

					} catch (StackOverflowException e) {
						e.printStackTrace();
					} catch (StackUnderflowException e) {
						e.printStackTrace();
					}
				}
			}

			element = this.stack2.top();
		}

		return element;
	}

	@Override
	public boolean isEmpty() {
		return this.stack1.isEmpty() && this.stack2.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.elements == this.size;
	}

}
