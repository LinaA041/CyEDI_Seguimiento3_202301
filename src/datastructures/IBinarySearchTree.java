package datastructures;

public interface IBinarySearchTree<K, T> {
	
	// For testing purposes only in this exercise.
	 T getRoot();
	
	T search(K key);
	void insert( K key,T value);
	T delete(K key);
	String inOrder();
}
