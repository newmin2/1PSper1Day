import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            int a = Integer.parseInt(bf.readLine());
            if(a==0) {
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            }
            else pq.offer(a);
        }
    }
}
