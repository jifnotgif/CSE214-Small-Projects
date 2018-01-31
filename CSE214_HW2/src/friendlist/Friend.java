package hw.cse214.friendlist;

public class Friend {

    private int mutualFriends;
    private String name;
    private int index;

    public Friend(int mutualFriends, String name, int index){
        this.mutualFriends = mutualFriends;
        this.name = name;
        this.index = index;
    }

    public int getMutualFriends() {
        return mutualFriends;
    }

    public String getName() {
        return name;
    }

    public int getIndex(){
        return index;
    }

}
