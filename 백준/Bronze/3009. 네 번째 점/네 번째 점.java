import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Integer>xpq = new PriorityQueue<>();
        PriorityQueue<Integer>ypq = new PriorityQueue<>();
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(bf.readLine());
            xpq.offer(Integer.parseInt(st.nextToken()));
            ypq.offer(Integer.parseInt(st.nextToken()));
        }
        int[] ans = new int[2];
        int first = xpq.poll();
        int second = xpq.poll();
        ans[0]=second==first?xpq.poll():first;

        first = ypq.poll();
        second = ypq.poll();
        ans[1]=second==first?ypq.poll():first;

        System.out.println(ans[0]+" "+ans[1]);
    }
}