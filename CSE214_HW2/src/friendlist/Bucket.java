package hw.cse214.friendlist;
public class Bucket {

    int minimum, maximum;
    LinkedListofFriends friendList;

    public Bucket(int min, int max){
        minimum = min;
        maximum = max;
        friendList = new LinkedListofFriends();
    }

    public boolean isEmpty(){
        return friendList.isEmpty();
    }

    public boolean isOneElement(){
        return friendList.size() == 1;
    }

    public Friend getFriend(){
        if(isOneElement()){
            return friendList.dequeue();
        }
        return null;
    }

    public void queueFriend(Friend p){
        friendList.enqueue(p);
    }

    public void sortFriends(){
        friendList.sortBucket();
    }

    public void deleteFriends(int k){
        while(!isOneElement()){
            for(int i =0; i<k-1;i++){
                friendList.enqueue(friendList.dequeue());
            }
            friendList.dequeue();
        }

    }
}
