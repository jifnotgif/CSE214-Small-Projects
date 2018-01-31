package cse214.hw.escape;

public class Graph {
    private int size;
    private int count = 0;
    private boolean[][] visited;

    public Graph(int s, int[][] arr){
        size = s;
        visited = new boolean[s][s];
    }
    public boolean isValid(int xValue, int yValue){
        if(xValue<0||yValue<0|| xValue>= size || yValue>= size){
            return false;
        }
        return true;
    }

    public void traverseMaze(int[][] maze, int xValue, int yValue){
        if (xValue == size-1 && yValue == size-1 && maze[xValue][yValue] != 1){
            count++;
            return;
        }
        visited[xValue][yValue] = true;
        if(isValid(xValue,yValue) && maze[xValue][yValue] == 0){
            if(xValue+1 <size && !visited[xValue+1][yValue])
                traverseMaze(maze, xValue+1, yValue);
            if(xValue-1 >= 0 && !visited[xValue-1][yValue])
                traverseMaze(maze, xValue-1, yValue);
            if(yValue+1 < size && !visited[xValue][yValue+1])
                traverseMaze(maze, xValue, yValue+1);
            if(yValue-1 >= 0 && !visited[xValue][yValue-1])
                traverseMaze(maze, xValue, yValue-1);

        }
        visited[xValue][yValue] =false;
    }

    public int getCount(){
        return count;
    }
}