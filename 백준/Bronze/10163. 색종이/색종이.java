import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        int[][] arr = new int[1001][1001];
        StringTokenizer st;
        int min = Integer.MAX_VALUE;
        int min2 = min;
        int max = Integer.MIN_VALUE;
        int max2 = max;
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            min = Math.min(x, min);
            min2 = Math.min(y, min2);
            max = Math.max(x + w, max);
            max2 = Math.max(y + h, max2);
            for (int i = x; i < x + w; i++) {
                for (int j = y; j < y + h; j++) {
                    arr[i][j] = t;
                }
            }
        }
        int t = 0;
        int sum = 0;
        while (t++ < T) {
            for (int i = min; i < max; i++) {
                for (int j = min2; j < max2; j++) {
                    if (arr[i][j] == t)
                        sum += arr[i][j] / t;
                }
            }
            System.out.println(sum);
            sum = 0;
        }
    }
}

