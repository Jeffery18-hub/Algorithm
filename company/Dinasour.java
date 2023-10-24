/* Lucid competiton */
package company; 

import java.util.*;

public class Dinasour {

    static class Node {
        int loc, distance, foodCollected;
        public Node(int loc, int distance, int foodCollected) {
            this.distance = distance;
            this.loc = loc;
            this.foodCollected = foodCollected;
        }
    }

    public static int findShortestPath(int N, int F, int[] foods, List<List<Integer>> graph) {
        Queue<Node> q = new LinkedList<>();
        Node[] visited = new Node[N + 1];
        q.add(new Node(1,0,foods[1])); // start node, location is 1

        int res = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node current = q.poll();

            if (current.loc == N &&  current.foodCollected >= F) {
                res = Math.min(res, current.distance);
            }

            for (int neighbor : graph.get(current.loc)) {
                int newDistance = current.distance + 1;
                int newFood = current.foodCollected + foods[neighbor];
                if(visited[neighbor] == null) {
                q.add(new Node(neighbor, newDistance, newFood));
            }
            
        }
        
    } 
        return res == Integer.MAX_VALUE? -1: res;
    }

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int F = sc.nextInt();

        int[] foods = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            foods[i] = sc.nextInt();
        }

        List<List<Integer>> edges = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            List<Integer> singleEdge = new ArrayList<>();
            singleEdge.add(from);
            singleEdge.add(to);
            edges.add(i, singleEdge);
        }

        // construct the graph first
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges) {
            graph.get(edge.get(0)).add(edge.get(1));
        }


        int result = findShortestPath(N, F, foods, graph);
        if (result != -1) {
            System.out.println("Shortest path length: " + result);
        } else {
            System.out.println("No valid path exists");
        }

        sc.close();
    }
}

