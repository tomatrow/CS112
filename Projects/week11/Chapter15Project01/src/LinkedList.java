public class LinkedList <T> {
	private Node <T> head;

	public LinkedList() {
		head = null;
	}
	public void addHeadNode(T data) {
		head = new Node<T>(data,head);
	}
	public int count() {
		int count = 0;
		
		Node<T> position = head;
		while (position != null) {
			count++;
			position = position.getNextLink();
		}

		return count;
	}

}