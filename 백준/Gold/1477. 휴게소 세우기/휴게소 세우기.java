import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());


        int[] road = new int[n + 1];
        if(n!=0) {
            st = new StringTokenizer(bf.readLine());
        }
        for (int i = 0; i < n; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }
        road[n] = l;
        Arrays.sort(road);

        int start = 1;
        int end = l;
        int mid;
        while (start <= end) {
            int point = 0;
            int cnt = 0;
            int add = m;
            mid = (start + end) >> 1;
            for (int i = 0; i < n + 1; i++) {
                if (road[i] <= point + mid) {
                    ++cnt;
                    point = road[i];
                } else {
                    if (add > 0) {
                        --add;
                        point += mid;
                        --i;
                    }
                }
            }
            if (cnt <= n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start);
    }
}