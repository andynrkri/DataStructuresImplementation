/**
 * Created by Anand on 9/25/2015.
 */
class LinkClass {
    public int data;
    public LinkClass next;
    public LinkClass previous;

    public LinkClass(int id) {
        data = id;
    }

    public void displayData() {
        System.out.println("{" + data + "}");
    }
}

public class FirstLastList {
    private LinkClass first;
    private LinkClass last;

    public FirstLastList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int value) {
        LinkClass newLink = new LinkClass(value);
        if (isEmpty()) {
            last = newLink;
        } else first.previous = newLink;
        newLink.next = first;
        first = newLink;
    }

    public void insertAfter(int key, int value) {
        LinkClass newLink = new LinkClass(value);
        LinkClass current = first;
        while (current.data != key) {
            current = current.next;
        }
        if (current == last) {
            last = newLink;
        } else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        newLink.previous = current;
        current.next = newLink;
    }

    public LinkClass deletefirst() {
        LinkClass temp = first;
        if (first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return temp;
    }

    public LinkClass deleteKey(int key) {
        LinkClass current = first;
        while (current != null && current.data != key) {
            current = current.next;
        }
        if (current == null) {
            return null;
        }
        if (current == first) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }
        if (current == last) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }
        return current;
    }

    public void displayList() {
        LinkClass current = first;
        while (current != null) {
            current.displayData();
            current = current.next;
        }
    }
}
class DoublyLinkList {
    public static void main(String[] args) {
        FirstLastList theList = new FirstLastList();

        theList.insertFirst(5);
        theList.insertFirst(6);
        theList.insertFirst(7);
        theList.insertFirst(8);
        theList.insertFirst(9);

        theList.insertAfter(8, 85);

        theList.deleteKey(6);

        theList.displayList();
    }
}
