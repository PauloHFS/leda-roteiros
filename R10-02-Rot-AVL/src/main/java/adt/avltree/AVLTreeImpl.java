package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Implementacao de uma arvore AVL
 * A CLASSE AVLTree herda de BSTImpl. VOCE PRECISA SOBRESCREVER A IMPLEMENTACAO
 * DE BSTIMPL RECEBIDA COM SUA IMPLEMENTACAO "OU ENTAO" IMPLEMENTAR OS SEGUITNES
 * METODOS QUE SERAO TESTADOS NA CLASSE AVLTREE:
 *  - insert
 *  - preOrder
 *  - postOrder
 *  - remove
 *  - height
 *  - size
 *
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		int result = 0;

		if (!node.isEmpty()) {
			result = this.height((BSTNode<T>) node.getLeft(), -1) - this.height((BSTNode<T>) node.getRight(), -1);
		}

		return result;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int balance = this.calculateBalance(node);

		if (balance < -1) {

			if (this.calculateBalance((BSTNode<T>) node.getRight()) > 0) {

				this.rightRotation((BSTNode<T>) node.getRight());

			}

			this.leftRotation(node);

		} else if (balance > 1) {

			if (this.calculateBalance((BSTNode<T>) node.getLeft()) < 0) {

				this.leftRotation((BSTNode<T>) node.getLeft());

			}

			this.rightRotation(node);
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		BSTNode<T> parent = (BSTNode<T>) node.getParent();

		while (parent != null) {

			this.rebalance(parent);
			parent = (BSTNode<T>) parent.getParent();

		}
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);

		if (!node.isEmpty()) { //caso 1 nó vazio não fazer nada

			if (node.isLeaf()) { //caso 2 o nó é folha

				node.setData(null);
				this.rebalanceUp(node);

			} else if ((node.getRight().isEmpty() && !node.getLeft().isEmpty() || node.getLeft().isEmpty() && !node.getRight().isEmpty())) { // caso 3 o nó só tem um filho

				if (node.getParent() != null) {

					if (!node.getParent().getLeft().equals(node)) { //o nó não é root

						if (!node.getLeft().isEmpty()) {

							node.getParent().setRight(node.getLeft());
							node.getLeft().setParent(node.getParent());

						} else {

							node.getParent().setRight(node.getRight());
							node.getRight().setParent(node.getParent());

						}

					} else {

						if (!node.getLeft().isEmpty()) {

							node.getParent().setLeft(node.getLeft());
							node.getLeft().setParent(node.getParent());

						} else {

							node.getParent().setLeft(node.getRight());
							node.getRight().setParent(node.getParent());

						}
					}

				} else { //o nó é root

					if (node.getLeft().isEmpty()) {

						this.root = (BSTNode<T>) node.getRight();

					} else {

						this.root = (BSTNode<T>) node.getLeft();

					}

					this.root.setParent(null);
				}

				this.rebalanceUp(node);

			} else { //caso indutivo

				T sucessorNode = sucessor(node.getData()).getData();

				this.remove(sucessorNode);
				node.setData(sucessorNode);

			}
		}
	}

	private void rightRotation(BSTNode<T> node) {
		if (node.equals(this.getRoot())) {

			this.root = Util.rightRotation(node);

		} else {

			BSTNode<T> aux = Util.rightRotation(node);

			if (aux.getData().compareTo(aux.getParent().getData()) > 0) {

				aux.getParent().setRight(aux);

			} else {

				aux.getParent().setLeft(aux);

			}
		}
	}

	protected void leftRotation(BSTNode<T> node) {
		if (node.equals(this.getRoot())) {

			this.root = Util.leftRotation(node);

		} else {

			BSTNode<T> aux = Util.leftRotation(node);

			if (aux.getData().compareTo(aux.getParent().getData()) < 0) {

				aux.getParent().setLeft(aux);

			} else {

				aux.getParent().setRight(aux);

			}
		}
	}

}
