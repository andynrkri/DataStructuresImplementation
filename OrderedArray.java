class OrderedArray {
    private long[] arr;
    private int nElems;

    public OrderedArray(int max) {
        arr = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(long key) {
        int lowerbound = 0;
        int upperbound = nElems-1;

        while (true) {
            int currIn = (lowerbound + upperbound) / 2;

            if (arr[currIn] == key) {
                return currIn;
            } else if (lowerbound > upperbound) {
                return nElems;
            } else {
                if (key > arr[currIn]) {
                    lowerbound = currIn + 1;
                } else {
                    upperbound = currIn - 1;
                }
            }
        }
    }

    public void insert(long value) {
        int i;
        for (i = 0; i < nElems; i++) {
            if (arr[i] > value) {
                break;
            }
        }
        for (int j = i; j < nElems; j++) {
            arr[j+1] = arr[j];
        }
        arr[i] = value;
        nElems++;
    }

    public boolean delete(long key) {
        int j = find(key);
        if (j == nElems) {
            return false;
        }
        for (int i = j; i <nElems ; i++) {
            arr[i] = arr[i+1];
        }
        nElems--;
        return true;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.println(arr[i]);
        }
    }
}

class OrderedArrayApp {
    public static void main(String[] args) {
        OrderedArray orderedArray = new OrderedArray(5);
        orderedArray.insert(989);
        orderedArray.insert(444);
        orderedArray.insert(555);

        orderedArray.delete(555);
        orderedArray.display();
    }
}

