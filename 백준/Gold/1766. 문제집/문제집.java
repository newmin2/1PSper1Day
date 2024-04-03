import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] outList = new ArrayList[n+1];
        int[] inDegree = new int[n+1];

        for(int i=1;i<=n;i++){
            outList[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            outList[a].add(b);
            ++inDegree[b];
        }
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        for(int i=1;i<=n;i++){
            if(inDegree[i]==0){
                pq.offer(i);
            }
        }
        StringBuilder sb= new StringBuilder();

        while(!pq.isEmpty()){
            int prob = pq.poll();
            for(int i : outList[prob]){
                if(--inDegree[i]==0){
                    pq.offer(i);
                }
            }
            sb.append(prob+" ");
        }
        System.out.println(sb);
    }
}