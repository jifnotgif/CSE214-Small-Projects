package hw.cse214.friendlist;
public class LinkedListofFriends {
    private Node first, last;
    private class Node {
        private int numMutual;
        private String friendName;
        private int index;
        private Node link;

        private Node(){
            numMutual = 0;
            friendName = "";
            index = -1;
            link = null;
        }

        private Node(int n, String data, int i, Node linkValue){
            setData(n, data, i);
            link = linkValue;
        }

        public void setData(int n, String data, int i){
            numMutual = n;
            friendName = data;
            index = i;
        }

        public int getNumMutual() {
            return numMutual;
        }

        public String getFriendName() {
            return friendName;
        }

        public Node getLink() {
            return link;
        }


    }

    public LinkedListofFriends(){
        first = null;
    }

    public void addToStart(int n, String name, int i){
        first = new Node(n, name, i, first);
    }

    public boolean deleteHeadNode(){
        if(first != null){
            first = first.link;
            return true;
        }
        return false;
    }

    public int size(){
        int count = 0;
        Node position = first;

        while(position != null){
            count++;
            position = position.link;
        }
        return count;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void enqueue(Friend p){
        Node oldLast = last;
        last = new Node();
        last.friendName = p.getName();
        last.numMutual = p.getMutualFriends();
        last.index = p.getIndex();
        last.link = null;
        if(isEmpty()) first = last;
        else oldLast.link = last;

    }

    public Friend dequeue(){
        Friend temp = new Friend(first.numMutual, first.friendName,first.index);
        first = first.getLink();
        if (isEmpty()) last = null;
        return temp;
    }

    public void sortBucket(){
        if (first == null) return;
        Node start = first;
        first = first.link;
        start.link = null;

        while(first != null){
            Node cur = first;
            first = first.link;
            if(cur.numMutual < start.numMutual){
                cur.link = start;
                start = cur;
            }
            else{
                Node position = start;
                while(position.link != null && position.link.numMutual<= cur.numMutual ){
                    position = position.link;
                }
                cur.link = position.link;
                position.link = cur;
            }

        }
        first = start;
        while (start != null){
            last = start;
            start = start.link;
        }
    }

    public void sortOutputList(){
        if (first == null) return;
        Node start = first;
        first = first.link;
        start.link = null;

        while(first != null){
            Node cur = first;
            first = first.link;
            if(cur.index < start.index){
                cur.link = start;
                start = cur;
            }
            else{
                Node position = start;
                while(position.link != null && position.link.index<= cur.index ){
                    position = position.link;
                }
                cur.link = position.link;
                position.link = cur;
            }

        }
        first = start;
        while (start != null){
            last = start;
            start = start.link;
        }
    }
    public String getFriendData(){
        return first.getFriendName();
    }

    public void printOutput(){
        if(first ==null ) return;
        while(first != null){
            System.out.print(first.friendName + " ");
            first = first.link;
        }
    }

}
