import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int find(int x) {
        if (planet[x] < 0) return x;
        return planet[x] = find(planet[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (planet[x] < planet[y]) {
            planet[x] += planet[y];
            planet[y] = x;
        } else {
            planet[y] += planet[x];
            planet[x] = y;
        }
    }
    static class Edge{
        int start, end, weight;
        Edge(int start, int end, int weight){
            this.start=start;
            this.end=end;
            this.weight=weight;
        }
    }

    static int[] planet;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        planet = new int[n];
        PriorityQueue<Edge>pq = new PriorityQueue<>(Comparator.comparingInt(o->o.weight));
        Arrays.fill(planet, -1);
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++){
                if(i==j) {
                    st.nextToken();
                    continue;
                }
                pq.offer(new Edge(i,j,Integer.parseInt(st.nextToken())));
            }
        }
        long sum = 0;
        while(!pq.isEmpty()){
            Edge p = pq.poll();
            if(find(p.start)==find(p.end))continue;
            union(p.start,p.end);
            sum+=p.weight;
        }
        System.out.println(sum);
    }
}
