import java.io.*;
import java.util.*;

public class Main {
    static class Lecture{
        int start;
        int end;
        Lecture(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        PriorityQueue<Lecture>pq = new PriorityQueue<>((o1,o2)->o1.start==o2.start?o1.end-o2.end:o1.start-o2.start);
        PriorityQueue<Lecture>pq2 = new PriorityQueue<>(Comparator.comparingInt(o->o.end));
        for(int i=0;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            st.nextToken();
            pq.offer(new Lecture(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        pq2.offer(pq.poll());
        int sum=n;
        while(!pq.isEmpty()){
            Lecture lec = pq.poll();
            if(!pq2.isEmpty()&&pq2.peek().end<=lec.start){
                pq2.poll();
                sum--;
            }
            pq2.offer(lec);
        }
        System.out.println(sum);
    }
}