package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		for (Integer num : array) {
			this.insert(num);
		}

		return this.floor(this.getRoot(), numero);
	}

	private Integer floor(BSTNode<Integer> node, double numero) {

		Integer floor = null;

		if (!node.isEmpty()) {

			if ((double) node.getData() == numero) {

				floor = node.getData();

			} else if (node.getData() > numero) {

				floor = this.floor((BSTNode<Integer>) node.getLeft(), numero);

			} else {

				floor = this.floor((BSTNode<Integer>) node.getRight(), numero);

				if (floor == null) {

					floor = node.getData();

				}

			}

		}

		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		for (Integer num : array) {
			this.insert(num);
		}

		return this.ceil(this.getRoot(), numero);}

	private Integer ceil(BSTNode<Integer> node, double numero) {

		Integer ceil = null;

		if (!node.isEmpty()) {

			if ((double) node.getData() == numero) {

				ceil = node.getData();

			} else if (node.getData() < numero) {

				ceil = this.ceil((BSTNode<Integer>) node.getRight(), numero);

			} else {

				ceil = this.ceil((BSTNode<Integer>) node.getLeft(), numero);

				if (ceil == null) {

					ceil = node.getData();

				}

			}

		}

		return ceil;
	}

}