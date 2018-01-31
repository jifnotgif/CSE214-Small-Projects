package cse214.hw.dijkstra;
public class DijkstraGraph {
    private int V;
    private int[][] matrix;
    private int source;
    private int dest;

    public DijkstraGraph(int vertex, int s, int d, int[][] m){
        V = vertex;
        source = s;
        dest = d;
        matrix = m;
    }

    public void dijkstra(){
        int[] distance = new int[V];
        boolean[] set = new boolean[V];
        int[] parent = new int[V];
        for(int i =0; i < V; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        parent[0] = -1;
        distance[0] = 0;
        for(int count =0; count < matrix.length -1; count++){
            int initVertex = minDistance(distance, set);

            set[initVertex] = true;
            for(int adjacentV = 0; adjacentV< V; adjacentV++){
                if(!set[adjacentV] && matrix[initVertex][adjacentV] != 0 && distance[initVertex] != Integer.MAX_VALUE
                        && distance[initVertex]+ matrix[initVertex][adjacentV] < distance[adjacentV]){
                    distance[adjacentV] = distance[initVertex] + matrix[initVertex][adjacentV];
                    parent[adjacentV] = initVertex;
                }
            }
        }
        printPathLength(distance,source,dest);
        printPath(parent, dest);
        System.out.println();
    }
    public int minDistance(int[] d, boolean[] set){
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0; i < V; i++){
            if(!set[i] && d[i] <= min){
                min = d[i];
                index= i;
            }
        }
        return index;
    }

    public void printPathLength(int[] d, int source, int dest){
        System.out.println(d[dest]);

    }
    public void printPath(int[] parent, int j){
        if(parent[j] == -1) {
            System.out.print(j);
            return;
        }
        printPath(parent, parent[j]);
        System.out.print(" -> " + j);
    }
}
