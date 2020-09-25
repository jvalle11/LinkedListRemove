package LinkedList;

public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() 
    {
        head = new Node();
        size = 0;
    }

    public void add(Object item) 
    {
        Node curr = head;
        while (curr.next != null) 
        {
            curr = curr.next;
        }
        curr.next = new Node(item);
        size++;
    }

    public void add(int index, Object item) 
    {
        if (index < 0 || index > size) 
        {
            throw new IndexOutOfBoundsException("Good luck, private Ryan!");
        }
        Node curr = head;
        int i = 0;
        while (i != index) 
        {
            curr = curr.next;
            i++;
        }
        curr.next = new Node(item, curr.next);
        size++;
    }

    public Object get(int index) 
    {
        if (index < 0) {
            index = size + index;
        }
        if (index < 0 || index >= size) 
        {
            throw new IndexOutOfBoundsException("Good luck, private Ryan!");
        }

        Node curr = head;
        int i = 0;
        while (i - 1 != index) 
        {
            curr = curr.next;
            i++;
        }
        return curr.item;
    }

    public boolean contains(Object item) 
    {
        Node curr = head.next;
        while (curr != null) {
            if (curr.item.equals(item)) 
            {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public int size() 
    {
        return size;
    }

    public String toString() 
    {
        String out = "";
        for (Node curr = head.next; curr != null; curr = curr.next) 
        {
            out += curr.item + " ";
        }
        return out;
    }

/** 
* Removes the first matched object and
* returns the position of the removed object
* from the LinkedList.
* 
* @param item represents the item the user wants to remove
* @return     position of the removed item
*/
    int remove(Object item) 
    {
        Node current = head;
        Node temp = null;
        int index;
        while (current != null)
        {
            if(item.equals(current.item))
            {
                index = current.indexOf(item); //gets index of current item
                current = current.next; //sets current to next item in the list
            }
            else 
            {
                current.next;
            }
        }
        return index;
        size--; //shortens list
    }


/**
* Removes the object given the position and
* returns the removed object from the LinkedList.
* 
* @param position represents the position of the object
*                 to be removed
* @return         the item that was removed
*/
    Object remove(int position) 
    {
        Node temp = head;
        
        if (position == 0) //if head needs to be removed
        {
            head = temp.next;
            return;
        }
        //finds node before the one to be removed
        for (int x = 0; temp != null && x<position-1; x++)
        {
            temp = temp.next; //sets temp to node before node deleted
        }
        //sets pointer to node after node to be delted
        Node next = temp.next.next; //temp.next = node to be deleted
        Node removed = temp.next; //sets removed node to node to be deleted
        temp.next = next; //links node before deleted to node after deleted.
        
        return removed;
        size--; //shortens list
    }

}

