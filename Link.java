/**
 * Created by Anand on 9/21/2015.
 */

public class Link {
    public int data;
    public double data2;
    public Link next;

    public Link(int id, double dd) {
        data = id;
        data2 = dd;
    }

    public void displayData() {
        System.out.println("{" + data + " , " + data2+"}");
    }
}

class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        newLink.next = first; //old first is assigned to the next of new link
        first = newLink;
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.println("The list is:");
        Link current = first;
        while (current != null) {
            current.displayData();
            current = current.next;
        }
    }

    public void reverseList(){
        Link reversedPart = null, next = null;
        Link current = first;
        while (current != null) {
            next = current.next;
            current.next = reversedPart;
            reversedPart = current;
            current = next;
        }
        first = reversedPart;
    }
}

class LinkListApp {
    public static void main(String[] args) {
        LinkList theList = new LinkList();
        theList.insertFirst(5, 5.5);
        theList.insertFirst(6, 6.6);
        theList.insertFirst(7, 7.7);
        theList.insertFirst(8, 8.8);

        theList.reverseList();

        theList.displayList();
    }
}
