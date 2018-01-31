package hw.cse214.leakystack;

public class LinkedStackOfStrings {
    private Node first;
    private Node p1, p2;
    private int maxCapacity;
    private int size;

    private class Node{
        private String item;
        private Node next;
    }

    public LinkedStackOfStrings(int c){
        maxCapacity = c;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public void push(String item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
        if (size > maxCapacity){
            leak();
        }
    }

    public void leak(){
         p1 = first;
         p2 = first;

         while(p2.next != null){
             p2 = p2.next;

             if(p2.next == null) break;
             else p1 = p1.next;
        }
        p1.next = null;
        size--;
    }

    public String pop(){
        String item = first.item;
        first = first.next;
        size--;
        return item;
    }

}