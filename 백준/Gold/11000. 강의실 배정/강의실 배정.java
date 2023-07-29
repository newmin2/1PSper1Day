import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Subject{
        int start,end;
        Subject(int start,int end){
            this.start=start;
            this.end=end;
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Subject>pq = new PriorityQueue<>(Comparator.comparingInt(o->o.start));
        PriorityQueue<Integer>pq2 = new PriorityQueue<>();
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            pq.offer(new Subject(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        int cnt=N;
        while(!pq.isEmpty()){
            Subject sub = pq.poll();
            if(!pq2.isEmpty()&&pq2.peek()<= sub.start) {
                cnt--;
                pq2.poll();
            }
            pq2.offer(sub.end);
        }
        System.out.println(cnt);
    }
}