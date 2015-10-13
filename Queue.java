/**
 * Created by Anand on 10/2/2015.
 */
public class Queue {
    private int maxSize;
    private long[] queArray;
    private int nItems;
    private int rear;
    private int front;

    public Queue(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
        rear = -1;
        front = 0;
    }

    public void insert(long value) {
        if (rear == maxSize - 1) {
            rear=-1;
        }
        queArray[++rear] = value;
        nItems++;
    }

    public long remove() {
        long temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    public boolean isEmpty() {
        return nItems==0;
    }

    public boolean isFull() {
        return nItems==maxSize;
    }
}

class QueueApp {
    public static void main(String[] args) {
        Queue theQ = new Queue(10);
        theQ.insert(3456);
        theQ.insert(6789);

        System.out.println(theQ.remove());
        System.out.println(theQ.remove());
        System.out.println(theQ.remove());
    }
}
