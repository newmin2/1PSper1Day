import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge{
        int to,value;
        Edge(int to, int value){
            this.to=to;
            this.value=value;
        }
    }
    static int dijkstra(int start, int end){
        pq = new PriorityQueue<>(Comparator.comparingInt(o->o.value));
        Arrays.fill(dist,INF);
        Arrays.fill(visited,false);
        dist[start]=0;
        pq.offer(new Edge(start,0));

        while(!pq.isEmpty()){
            Edge e = pq.poll();
            if(visited[e.to])continue;
            visited[e.to]=true;
            for(int i=0;i<list[e.to].size();i++){
                Edge next = list[e.to].get(i);
                if(dist[next.to]>dist[e.to]+next.value){
                    dist[next.to]=dist[e.to]+next.value;
                    pq.offer(new Edge(next.to, dist[next.to]));
                }
            }
        }
        return dist[end];
    }
    static PriorityQueue<Edge>pq;
    static boolean[] visited;
    static List<Edge>[] list;
    static int[] info,dist;
    static final int INF = 200000000;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        info = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        list = new ArrayList[info[0]+1];
        dist= new int[info[0]+1];
        visited = new boolean[info[0]+1];

        for(int i=1;i<=info[0];i++){
            list[i]=new ArrayList<>();
        }
        int[] edgeInfo;
        for(int i=0;i<info[1];i++){
            edgeInfo = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            list[edgeInfo[0]].add(new Edge(edgeInfo[1],edgeInfo[2]));
            list[edgeInfo[1]].add(new Edge(edgeInfo[0],edgeInfo[2]));
        }
        int[] toGo = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int firstPath,secondPath;
        firstPath = dijkstra(1,toGo[0])+dijkstra(toGo[1],info[0])+dijkstra(toGo[0],toGo[1]);
        secondPath = dijkstra(1,toGo[1])+dijkstra(toGo[0],info[0])+dijkstra(toGo[1],toGo[0]);
        int ans = firstPath>=INF&&secondPath>=INF? -1:Math.min(firstPath,secondPath);
        System.out.println(ans);
    }
}
