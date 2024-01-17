import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            pq.offer(Integer.parseInt(bf.readLine()));
        }
        long cnt =0;
        for(int j=n;j>0;j--){
            cnt+=Math.abs(j-pq.poll());
        }
        System.out.println(cnt);
    }
}