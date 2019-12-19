package ru.list;

public class ListMain {
    public static void main(String[] args) {
        List list = new List();
        list.Add(1);
        list.Add(2);
        list.Add(3);
        list.Print();
        list.Count();
        list.Add(12);
        list.Print();
        list.Count();
        list.RemoveLast();
        list.Print();
        list.Count();
        list.RemoveLast();
        list.Print();
        list.Count();
        list.RemoveLast();
        list.Print();
        list.Count();
    }
}
