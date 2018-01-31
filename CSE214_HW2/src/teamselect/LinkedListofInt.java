package hw.cse214.teamselection;

public class LinkedListofInt {

    private Node head;


    private class Node{
        private int jerseyNum;
        private int height;
        private Node link;
        public Node(){
            jerseyNum =0;
            height =0;
            link = null;
        }

        public Node(int j, int h, Node linkValue){
            setData(j, h);
            link = linkValue;
        }

        public void setData(int j, int h){
            jerseyNum = j;
            height = h;

        }
        public void setLink(Node newLink){
            link = newLink;
        }

        public int getJerseyNum() {
            return jerseyNum;
        }

        public int getHeight() {
            return height;
        }

        public Node getLink(){
            return link;
        }


        public int compareTo(Node s){
            if(this.getHeight() < s.getHeight()) return 1;
            else if (this.getHeight() == s.getHeight()) return 0;
            else return -1;
        }

    }

    public LinkedListofInt(){
        head = null;
    }

    public void addToStart(int j, int h) {
        head = new Node(j, h, head);
    }

    public boolean deleteHeadNode(){
        if(head != null){
            head = head.link;
            return true;
        }
        return false;
    }

    public int size(){
        int count = 0;
        Node position = head;

        while(position != null){
            count++;
            position = position.link;
        }
        return count;
    }

    public void getOutput(){
        Node position = head;
        while(position != null){
            System.out.print(position.getJerseyNum() + " ");
            position = position.link;
        }


    }

    public boolean isShorter(Node m, Node n){
        if(m.getHeight() > n.getHeight()) return true;
        else{ return false;}
    }
    public void printShortest() {
        Node prev = null;
        Node cur = head;
        Node next = head.link;
        while ( next!= null) {


            if (!isShorter(cur, next)) {
                cur = prev.link.link;
                next = next.link;
            }
            else {
                prev = cur;
                cur = cur.link;
                next = next.link;
                System.out.print(prev.getJerseyNum() + " " );
            }
            if(next == null){
                System.out.println(cur.getJerseyNum());
            }
        }


    }

    }


