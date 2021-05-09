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
			
		}

		if () {
			if (node1.getData().compareTo(node2.getData()) == 0) {

			}
		} else if (node1.isEmpty() && node2.isEmpty()) {
			isEqual = true;
		}

		return isEqual;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		// TODO Implement this method
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		// TODO Implement this method
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
