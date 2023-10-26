import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Meeting{
        int start,end;
        Meeting(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        PriorityQueue<Meeting>pq = new PriorityQueue<>((o1,o2)->o1.start==o2.start?o1.end-o2.end:o1.start-o2.start);
        PriorityQueue<Integer>pq2 = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            pq.offer(new Meeting(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        int cnt=n;
        while(!pq.isEmpty()){
            Meeting meeting = pq.poll();
            if(!pq2.isEmpty()&&pq2.peek()<=meeting.start){
                cnt--;
                pq2.poll();
            }
            pq2.offer(meeting.end);
        }
        System.out.println(cnt);
    }
}