import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(bf.readLine());
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        for(int i=0;i<n; i++){
            pq.offer(Integer.parseInt(bf.readLine()));
        }
        int cnt=0;
        while(pq.size()!=1){
            int a=pq.poll();
            int b=pq.poll();
            pq.offer(a+b);
            cnt+=a+b;
        }
        System.out.println(cnt);
    }
}
