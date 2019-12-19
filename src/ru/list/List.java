package ru.list;

public class List {
    static Node first;
    static Node last;

    public void Add(int a) {
        Node newNode = new Node(a);
        if (first == null) {
            first = newNode;
            last = newNode;
            newNode.next = null;
        } else {
            newNode.next = last;
            last = newNode;
        }
    }

    public void RemoveLast() {
        Node remove = null;
        if (last.next != null) {
            remove = last;
            last = last.next;
        }
        remove.next = null;
    }


    public void Count() {
        //8 должен вывести
        int count = 0;
        Node lLast = last;
        while (lLast != null) {
            lLast = lLast.next;
            count++;
        }
        System.out.println("Общее кол-во ячеек:" + count);
    }

    public void Print() {
        Node lLast = last;
        while (lLast != null) {
            System.out.println(lLast.n);
            lLast = lLast.next;
        }
    }
}
