public class DoublyCircularLinkedList <T> {
	private Node <T> _head;

	public DoublyCircularLinkedList() {
		_head = null;
	}

	// mutation
	public void move(int spaces) {
		// Get the direction we travel and make sure we don't loop around. 
		// Right is in the direction of next. 
		// Left is in the directon of previous.
		boolean goRight = (spaces > 0)?true:false;
		int distance = Math.abs(spaces);

		// System.out.println("" + goRight + " " + distance);
		for (int x = 0; x < distance; ++x) {
			_head = (goRight)?_head.getNextLink():_head.getPreviousLink();
		}
	}

	public void insertBelow(T data) {
		Node <T> node = new Node(data);

		if (_head == null) {
			_head = node;
			_head.setNextLink(_head);
			_head.setPreviousLink(_head);
		}
		else if (_head.getNextLink().equals(_head)) {
			_head.setNextLink(node);
			_head.setPreviousLink(node);
			node.setNextLink(_head);
			node.setPreviousLink(_head);
		} 
		else {
			node.setNextLink(_head.getNextLink());
			node.setPreviousLink(_head);
			_head.getNextLink().setPreviousLink(node);
			_head.setNextLink(node);
		}
	}	

	public void insertAbove(T data) {
		Node <T> node = new Node(data);

		if (_head == null) {
			_head = node;
			_head.setNextLink(_head);
			_head.setPreviousLink(_head);
		}
		else if (_head.getPreviousLink().equals(_head)) {
			_head.setPreviousLink(node);
			_head.setNextLink(node);
			node.setPreviousLink(_head);
			node.setNextLink(_head);
		} 
		else {
			node.setNextLink(_head);
			node.setPreviousLink(_head.getPreviousLink());
			_head.getPreviousLink().setNextLink(node);
			_head.setPreviousLink(node);
		}
	}
 
	public void remove() {
		if (_head != null) {
			Node <T> currentHead = _head;

			_head.getPreviousLink().setNextLink(_head.getNextLink());
			_head.getNextLink().setPreviousLink(_head.getPreviousLink());

			_head = _head.getNextLink();


			// Takes care of edge case with only one item in the list. 
			if (_head.equals(currentHead))
				_head = null;
		}
	}

	// derived data
	public T currentData() {
		return _head.getData();
	}

	public int count() {
		Node <T> position = _head;		

		int count = 0;

		if (position != null)
			count++;

		while (position.getNextLink() != _head) {
			count++;
			position = position.getNextLink();
		}

		return count;
	}

	// Object 
	public String toString() {
		Node <T> position = _head;		
		String output = "";

		while (position.getNextLink() != _head) {
			output = String.format("%s%s,", output, position.getData());
			position = position.getNextLink();
		}
		output = output + position.getData();

		return output;
	}
}