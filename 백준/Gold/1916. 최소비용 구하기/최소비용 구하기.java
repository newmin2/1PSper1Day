import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Bus implements Comparable<Bus>{
        int to,pay;
        Bus(int to, int pay){
            this.to=to;
            this.pay=pay;
        }
        @Override
        public int compareTo(Bus bus){
            return pay -bus.pay;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        int[] dist = new int[N+1];
        final int INF = Integer.MAX_VALUE;
        Arrays.fill(dist,INF);

//        int visited = 0;

        List<Bus>[] list = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            list[i]=new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(bf.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int pay=Integer.parseInt(st.nextToken());
            list[from].add(new Bus(to,pay));
        }
        PriorityQueue<Bus>pq = new PriorityQueue<>();
        boolean visited[] = new boolean[N+1];
        String[] info = bf.readLine().split(" ");
        pq.offer(new Bus(Integer.parseInt(info[0]),0));
        dist[Integer.parseInt(info[0])]=0;
        while(!pq.isEmpty()){
            Bus bus = pq.poll();
            if(visited[bus.to])continue;
            visited[bus.to]=true;
            for(Bus nextBus : list[bus.to]){
                if(dist[nextBus.to]>dist[bus.to]+nextBus.pay) {
                    dist[nextBus.to] = dist[bus.to] + nextBus.pay;
                    pq.offer(new Bus(nextBus.to, dist[nextBus.to]));
                }
            }
        }
        System.out.println(dist[Integer.parseInt(info[1])]);
    }
}