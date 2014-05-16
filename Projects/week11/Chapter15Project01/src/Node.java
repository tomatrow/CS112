public class Node <T> {
	private Node <T> _nextLink;
	private Node <T> _previousLink;
	private T _data;

	public Node() {
		this(null);
	}
	public Node(T data) {
		this(data, null);
	}
	public Node(T data, Node <T> nextLink) {
		this(data,nextLink,null);
	}
	public Node(T data, Node <T> nextLink, Node <T> previousLink) {
		setData(data);
		setNextLink(nextLink);
		setPreviousLink(previousLink);
	}
	
	// setters 
	public void setData(T data) {
		_data = data;
	}
	public void setNextLink(Node <T> nextLink ) {
		_nextLink = nextLink;
	}
	public void setPreviousLink(Node <T> previousLink) {
		_previousLink = previousLink;
	}

	// Getters 
	public T getData() {
		return _data;
	}
	public Node<T> getNextLink() {
		return _nextLink;
	}
	public Node<T> getPreviousLink() {
		return _previousLink;
	}


	// Object 
	public boolean equals(Object otherObject) {
		if (otherObject == null)
			return false;
		else if (!this.getClass().equals(otherObject.getClass()))
			return false;
		else {
			Node <T> otherNode = (Node)otherObject;
			boolean sameData = getData().equals(otherNode.getData());
			return sameData;
		}
	}
	public String toString() {
		return String.format("This:%s Next:%s Prev:%s", this.getData(), this.getNextLink().getData(), this.getPreviousLink().getData());
	}
}