package adt.bst;

/**
 * - Esta eh a unica classe que pode ser modificada
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		return this.equals((BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
	}

	private boolean equals(BSTNode<T> node1, BSTNode<T> node2) {
		boolean isEqual = false;

		if (node1.isEmpty() && node2.isEmpty()) {

			isEqual = true;

		} else if (!node1.isEmpty() && !node2.isEmpty()) {

			if (node1.getData().compareTo(node2.getData()) == 0) {

				isEqual = this.equals((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft());
				isEqual = isEqual && this.equals((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight());

			}

		}

		return isEqual;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		return this.isSimilar((BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
	}

	private boolean isSimilar(BSTNode<T> node1, BSTNode<T> node2) {
		boolean isSimilar = false;

		if (node1.isEmpty() && node2.isEmpty()) {

			isSimilar = true;

		} else if (!node1.isEmpty() && !node2.isEmpty()) {

			isSimilar = this.isSimilar((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft());
			isSimilar = isSimilar && this.isSimilar((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight());

		}

		return isSimilar;
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		// TODO Implement this method
		throw new UnsupportedOperationException("Not implemented yet!");
	}
}
