/**
 * Created by Anand on 9/27/2015.
 */

class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void displayPerson() {
        System.out.println("   Last name: "+lastName);
        System.out.println(" , First name: "+firstName);
        System.out.println(" , Age: "+age);
    }

    public String getLast() {
        return lastName;
    }
}

class ClassDataArray {
    private Person[] a;
    private int nElems;

    public ClassDataArray(int max) {
        a = new Person[max];
        nElems = 0;
    }

    public Person find(String lastname) {
        int j=0;
        for (j = 0; j < nElems; j++) {
            if (a[j].getLast().equals(lastname)) {
                break;
            }
        }
        if (j == nElems) {
            return null;
        } else {
            return a[j];
        }
    }

    public void insert(String first, String last, int age) {
        a[nElems] = new Person(first, last, age);
        nElems++;
    }

    public boolean delete(String last) {
        int j=0;
        for (j = 0; j < nElems; j++) {
            if (a[j].getLast().equals(last)) {
                break;
            }
        }
        if (j == nElems) {
            return false;
        } else {
            for (int i = j; i < nElems; i++) {
                a[i] = a[i+1];
            }
            nElems--;
        }
        return true;
    }

}
