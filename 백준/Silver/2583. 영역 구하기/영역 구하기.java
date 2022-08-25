import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int m;
    static int n;
    static int k;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[] count;

    static void dfs(int x, int y, int idx) {
        if (x < 0 || y < 0 || x >= m || y >= n || arr[x][y] != 0)
            return;
        arr[x][y] = 1;
        count[idx]++;
        for (int i = 0; i < 4; i++) {
            dfs(x + dr[i], y + dc[i], idx);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        count = new int[k];
        for (int a = 0; a < k; a++) {
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    dfs(i, j, cnt);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        Arrays.sort(count);
        for(int i: count)
            if(i!=0)
                System.out.print(i+" ");
    }
}
