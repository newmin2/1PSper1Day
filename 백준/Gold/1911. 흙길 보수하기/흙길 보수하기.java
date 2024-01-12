import java.io.*;
import java.util.*;

public class Main {
    static class Pair{
        int start,end;
        Pair(int start, int end){
            this.start=start;
            this.end=end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        PriorityQueue<Pair>pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.start));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            pq.offer(new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())-1));
        }
        int start,end;
        int cnt =0;
        int remain = 0;
        while(!pq.isEmpty()){
            Pair trap = pq.poll();
            start = remain<trap.start?trap.start:remain+1;
            end = trap.end;
            while(!pq.isEmpty()&&end==pq.peek().start){
                end=pq.poll().end;
            }
            int tmp = (end-start+l)/l;
            cnt+= tmp;
            remain = l*tmp+start-1;
        }
        System.out.println(cnt);
    }
}
