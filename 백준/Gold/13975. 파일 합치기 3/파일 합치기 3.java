import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for(int t=0;t<T;t++){
            int k = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            PriorityQueue<Long>pq = new PriorityQueue<>();
            for(int i=0;i<k;i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }
            long cnt=0;
            while(pq.size()!=1){
                long a = pq.poll();
                long b = pq.poll();
                pq.offer(a+b);
                cnt+=a+b;
            }
            System.out.println(cnt);
        }
    }
}
