package hw.cse214.binarytree;
public class BT {
    public static Node root;
    private int data;
    public BT(){
        this.root = null;
    }
    private class Node{
        int dataValue;
        Node left;
        Node right;
        public Node(int dataValue){
            this.dataValue = dataValue;
            left = null;
            right = null;
        }
    }

    public Node insert(int[] arr, Node root, int index){
        if(index < arr.length) {
            Node cur = new Node(arr[index]);
            root = cur;

            root.left = insert(arr, root.left, 2 * index + 1);
            root.right = insert(arr, root.right, 2 * index + 2);
        }
        return root;
        }

    public int inOrder(Node root, int[] array, int i){
        if(root == null) return i;
        i = inOrder(root.left, array, i);
        array[i++] = root.dataValue;
        i=inOrder(root.right, array , i);
        return i;
    }

    public int[] traverseInorder(BT tree, int[] s){
        int[] array = new int[s.length];
        int index = 0;
        tree.inOrder(tree.root, array, index);
        return array;
    }

    public int sortArray(int[] arr, int s){
        for(int i = 0; i <arr.length; i++){
            int min = 9999;
            int minIndex = -1;
            for(int j = i +1; j< arr.length; j++){
                if(arr[j]<min) {

                    minIndex = j;
                    min = arr[j];
                }
            }
            if(arr[i]>min){
                int temp = min;
                arr[minIndex] = arr[i];
                arr[i] = temp;
                s++;
            }
        }
        return s;
    }

}

