import java.io.*;
import java.util.*;

public class Main {
    static class Village {
        int value;
        int time;

        Village(int value, int time) {
            this.value = value;
            this.time = time;
        }
    }
    static class Node {
        int startPoint;
        Village village;

        Node(int startPoint, Village village) {
            this.village = village;
            this.startPoint = startPoint;
        }
    }
    static final int INF = Integer.MAX_VALUE;
    static List<Village>[] list;
    static void saveGoDist(int startPoint,Village village) {
        for (Village next : list[village.value]) {
            if (goDist[startPoint][next.value] > goDist[startPoint][village.value] + next.time) {
                goDist[startPoint][next.value] = goDist[startPoint][village.value] + next.time;
                pq.offer(new Node(startPoint, (new Village(next.value, goDist[startPoint][next.value]))));
            }
        }
    }
    static PriorityQueue<Node> pq;
    static int[][] goDist;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        goDist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(goDist[i], INF);
        }
        int[] backDist = new int[n + 1];
        Arrays.fill(backDist, INF);

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            list[Integer.parseInt(st.nextToken())]
                    .add(new Village(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int i = 1; i <= n; i++) {
            if (goDist[i][i]==0) continue;
            goDist[i][i] = 0;
            pq = new PriorityQueue<>((o1, o2) -> o1.startPoint == o2.startPoint ? o1.village.time - o2.village.time : o1.startPoint - o2.startPoint);
            pq.offer(new Node(i, new Village(i, 0)));

            while (!pq.isEmpty()) {
                Node node = pq.poll();
                int startPoint = node.startPoint;
                Village village = node.village;

                if(goDist[village.value][village.value]==INF) {
                    goDist[village.value][village.value]=0;
                    saveGoDist(village.value,village);
                }
                saveGoDist(startPoint,village);
            }
        }

        backDist[x]=0;


        PriorityQueue<Village>backPq = new PriorityQueue<>(Comparator.comparingInt(o->o.time));
        backPq.offer(new Village(x,0));

        while(!backPq.isEmpty()){
            Village village = backPq.poll();
            for(Village next:list[village.value]){
                if(backDist[next.value]>backDist[village.value]+next.time){
                    backDist[next.value]=backDist[village.value]+next.time;
                    backPq.offer(new Village(next.value,backDist[next.value]));
                }
            }
        }
        int max =Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            max=Math.max(goDist[i][x]+backDist[i],max);
        }
        System.out.println(max);
    }
}