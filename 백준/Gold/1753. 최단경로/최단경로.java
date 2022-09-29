import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int v, weight;

        Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static List<Node>[] adjlist;
    static int[] dist;
    static int v, e;
    static void dijkstra (int st){
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight-o2.weight;
            }
        });
        boolean[] visited = new boolean[v+1];
        pq.offer(new Node(st, 0));
        dist[st] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (visited[now.v]) continue;
            visited[now.v] = true;
            for (Node node : adjlist[now.v]) {
                if (!visited[node.v] && dist[node.v] > dist[now.v] + node.weight) {
                    dist[node.v] = dist[now.v] + node.weight;
                    pq.offer(new Node(node.v, dist[node.v]));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(bf.readLine());
        v = Integer.parseInt(st1.nextToken());
        e = Integer.parseInt(st1.nextToken());
        int ori = Integer.parseInt(bf.readLine());
        adjlist = new ArrayList[v + 1];
        for (int i = 1; i < v + 1; i++)
            adjlist[i] = new ArrayList<>();
        //최단 길이 배열
        dist = new int[v+1];
        Arrays.fill(dist,INF);
        //무한대
        for (int i = 0; i < e; i++) {
            st1 = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st1.nextToken());
            int v = Integer.parseInt(st1.nextToken());
            int w = Integer.parseInt(st1.nextToken());
            adjlist[u].add(new Node(v, w));
        }
        dijkstra(ori);
        for(int i=1;i<=v;i++) {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }
    }
}
