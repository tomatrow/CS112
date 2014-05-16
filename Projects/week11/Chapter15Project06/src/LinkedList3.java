import java.util.ArrayList;

public class LinkedList3<T extends Comparable> {
    private Node<T> head;

    public LinkedList3() {
        head = null;
    }

    /**
     Adds a node at the start of the list with the specified data.
     The added node will be the first node in the list.
    */
    public void addToStart(T itemData) {
        head = new Node<T>(itemData, head);
    }
    public void addSorted(T itemData) {
        Node<T> position = head;

        if (head == null) {
            addToStart(itemData);
        }
        // else if (head.link == null) {
        //     boolean comesBefore = head.data.compareTo(itemData) <= 0;
        //     if (comesBefore)
        //         head.link = new Node<T>(itemData,null);
        //     else 
        //         addToStart(itemData);
        // }
        else {
            while (position != null) {
                boolean comesAfter = position.data.compareTo(itemData) <= 0;
                boolean comesBefore = position.link == null || position.link.data.compareTo(itemData) >= 0;
                // The new data is between two nodes. 
                if (comesBefore && comesAfter) {
                    position.link = new Node<T>(itemData,position.link);
                    break;
                } 
                // The new data is before the first node. 
                else if (comesBefore) {
                    addToStart(itemData);
                    break;
                }

                position = position.link;
            }
        }
    }

    /**
     Removes the head node and returns true if the list contains at least
     one node. Returns false if the list is empty.
    */
    public boolean deleteHeadNode() {
        if (head != null) {
            head = head.link;
            return true;
        }
        else
            return false;
    }

    /**
     Returns the number of nodes in the list.
    */
    public int size() {
        int count = 0;
        Node<T> position = head;
        while (position != null) {
            count++;
            position = position.link;
        }
        return count;
    }

    public boolean contains(T item) {
        return (find(item) != null);
    }

    /**
     Finds the first node containing the target item, and returns a
     reference to that node. If target is not in the list, null is returned.
    */
    private Node<T> find(T target) {
        Node<T> position = head;
        T itemAtPosition;
        while (position != null) {
            itemAtPosition = position.data;
            if (itemAtPosition.equals(target))
                return position;
            position = position.link;
        }
        return null; //target was not found
    }

    /**
     Finds the first node containing the target and returns a reference
      to the data in that node. If target is not in the list, null is returned.
    */
    public T findData(T target) {
        return find(target).data;
    }

    public void outputList() {
        Node<T> position = head;
        while (position != null) {
            System.out.println(position.data);
            position = position.link;
        }
    }

    public boolean isEmpty( ) {
        return (head == null);
    }

    public void clear( ) {
        head = null;
    }
    // Object
   public boolean equals(Object otherObject) {
        if (otherObject == null)
            return false;
        else if (getClass() != otherObject.getClass())
            return false;
        else {
            LinkedList3<T> otherList = (LinkedList3<T>)otherObject;
            if (size() != otherList.size( ))
                return false;
            Node<T> position = head;
            Node<T> otherPosition = otherList.head;
            while (position != null) {
                if (!(position.data.equals(otherPosition.data)))
                    return false;
                position = position.link;
                otherPosition = otherPosition.link;
            }
            return true; //no mismatch was not found
        }
    }
    public String toString() {
        ArrayList<T> list = new ArrayList<T>(size());
        Node<T> position = head;


        while (position != null) {
            list.add(position.data);
            position = position.link;
        } 
        return list.toString();       
    }
    private class Node<T> {
        private T data;
        private Node<T> link;

        public Node( ) {
             data = null;
             link = null;
        }

        public Node(T newData, Node<T> linkValue) {
            data = newData;
            link = linkValue;
        }
     }//End of Node<T> inner class
}
