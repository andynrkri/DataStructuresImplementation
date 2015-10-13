/**
 * Created by Anand on 9/29/2015.
 */

class StackX {
    private long[] stackArray;
    private int maxSize;
    private int top;

    public StackX(int s) {
        maxSize = s;
        stackArray = new long[maxSize];
        top = -1;
    }

    public void push(long value) {
        stackArray[++top] = value;
    }

    public long pop() {
        return stackArray[top--];
    }

    public long peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top==-1;
    }

    public boolean isFull() {
        return top==maxSize-1;
    }
}


public class StackApp {
    public static void main(String[] args) {
        StackX newStack = new StackX(10);
        if (!newStack.isFull()) {
            newStack.push(67594);
            newStack.push(637643);
        }

        if (!newStack.isEmpty()) {
            newStack.pop();
            System.out.println(newStack.peek());
        }
    }
}
