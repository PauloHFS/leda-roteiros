package adt.bst;

import java.util.ArrayList;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(this.getRoot(), -1);
	}

	public int height(BSTNode<T> node, int height) {
		if (!node.isEmpty()) {

			int left = height((BSTNode<T>) node.getLeft(), height + 1);
			int right = height((BSTNode<T>) node.getRight(), height + 1);
			height = Math.max(left, right);

		}

		return height;
	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> nodeResult = new BSTNode<T>();

		if (!this.isEmpty()) {

			nodeResult = this.search(this.getRoot(), element);

		}

		return nodeResult;
	}

	private BSTNode<T> search(BSTNode<T> node, T element) {
		BSTNode<T> nodeResult= new BSTNode<T>();

		if (!node.isEmpty()) {

			if (node.getData().compareTo(element) < 0) {

				nodeResult = this.search((BSTNode<T>) node.getRight(), element);

			} else if (node.getData().compareTo(element) > 0) {

				nodeResult = this.search((BSTNode<T>) node.getLeft(), element);

			} else {

				nodeResult = node;

			}

		}

		return nodeResult;
	}

	@Override
	public void insert(T element) {
		this.insert(this.getRoot(), element);
	}

	private void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) { //caso base

			node.setData(element);
			node.setLeft(new BSTNode.Builder().parent(node).build());
			node.setRight(new BSTNode.Builder().parent(node).build());

		} else if (node.getData().compareTo(element) < 0) {

			this.insert((BSTNode<T>) node.getRight(), element);

		} else if (node.getData().compareTo(element) > 0) {

			this.insert((BSTNode<T>) node.getLeft(), element);

		}
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> nodeResult = null;

		if (!this.isEmpty()) {

			nodeResult = this.maximum(this.getRoot());

		}

		return nodeResult;
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		if (!node.getRight().isEmpty()) {

			node = this.maximum((BSTNode<T>) node.getRight());

		}

		return node;
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> nodeResult = null;

		if (!this.isEmpty()) {

			nodeResult = this.minimum(this.getRoot());

		}

		return nodeResult;
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		if (!node.getLeft().isEmpty()) {

			node = this.minimum((BSTNode<T>) node.getLeft());

		}

		return node;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = this.search(element), nodeSucessor = null;

		if (!node.isEmpty()) {

			if (node.getRight().isEmpty()) {

				nodeSucessor = (BSTNode<T>) node.getParent();

				while (nodeSucessor != null && nodeSucessor.getData().compareTo(node.getData()) < 0) {

					node = nodeSucessor;
					nodeSucessor = (BSTNode<T>) node.getParent();

				}

			} else {

				nodeSucessor = this.minimum((BSTNode<T>) node.getRight());

			}

		}

		return nodeSucessor;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = this.search(element), nodePredecessor = null;

		if (!node.isEmpty()) {

			if (node.getLeft().isEmpty()) {

				nodePredecessor = (BSTNode<T>) node.getParent();

				while (nodePredecessor != null && nodePredecessor.getData().compareTo(node.getData()) > 0) {

					node = nodePredecessor;
					nodePredecessor = (BSTNode<T>) node.getParent();

				}

			} else {

				nodePredecessor = this.maximum((BSTNode<T>) node.getLeft());

			}

		}

		return nodePredecessor;
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = this.search(element);

		if (!node.isEmpty()) { //caso 1 nó vazio não fazer nada

			if (node.isLeaf()) { //caso 2 o nó é folha

				node.setData(null);

			} else if ((node.getLeft().isEmpty() && !node.getRight().isEmpty()) || (!node.getLeft().isEmpty() && node.getRight().isEmpty())) { // caso 3 o nó só tem um filho

				if (node.getParent() == null) { //o nó é root

					if (node.getLeft().isEmpty()) {

						this.root = (BSTNode<T>) node.getRight();

					} else {

						this.root = (BSTNode<T>) node.getLeft();

					}

					this.getRoot().setParent(null);

				} else { //o nó não é root

					if (!node.getParent().getLeft().equals(node)) { //o nó é filho pela direita

						if (!node.getLeft().isEmpty()) { //o filho do nó está na esquerda

							node.getParent().setRight(node.getLeft());
							node.getLeft().setParent(node.getParent());

						} else { //o filho do nó está na direita

							node.getParent().setRight(node.getRight());
							node.getRight().setParent(node.getParent());
						}

					} else { //o no é filho pela esquerda

						if (!node.getLeft().isEmpty()) { //o filho do nó está na esquerda

							node.getParent().setLeft(node.getLeft());
							node.getLeft().setParent(node.getParent());

						} else { //o filho do nó está na direita

							node.getParent().setLeft(node.getRight());
							node.getRight().setParent(node.getParent());

						}

					}

				}

			} else { //caso indutivo

				T nodeSucessorData = sucessor(node.getData()).getData();
				this.remove(nodeSucessorData);
				node.setData(nodeSucessorData);

			}

		}
	}

	@Override
	public T[] preOrder() {
		ArrayList<T> list = new ArrayList<T>();

		this.preOrder(list, this.getRoot());

		return list.toArray((T[]) new Comparable[this.size()]);
	}

	private void preOrder(ArrayList<T> array, BSTNode<T> node) {
		if (!node.isEmpty()) {

			array.add(node.getData());

			preOrder(array, (BSTNode<T>) node.getLeft());
			preOrder(array, (BSTNode<T>) node.getRight());

		}
	}

	@Override
	public T[] order() {
		ArrayList<T> list = new ArrayList<T>();

		this.order(list, this.getRoot());

		return list.toArray((T[]) new Comparable[this.size()]);
	}

	private void order(ArrayList<T> array, BSTNode<T> node) {
		if (!node.isEmpty()) {

			order(array, (BSTNode<T>) node.getLeft());

			array.add(node.getData());

			order(array, (BSTNode<T>) node.getRight());

		}
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> list = new ArrayList<T>();

		this.postOrder(list, this.getRoot());

		return list.toArray((T[]) new Comparable[this.size()]);
	}

	private void postOrder(ArrayList<T> array, BSTNode<T> node) {
		if (!node.isEmpty()) {

			postOrder(array, (BSTNode<T>) node.getLeft());
			postOrder(array, (BSTNode<T>) node.getRight());

			array.add(node.getData());

		}
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
