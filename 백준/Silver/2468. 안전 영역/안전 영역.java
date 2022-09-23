import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static int n;
    static int[][] arr;

    static void dfs(int i, int j, int a) {
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            if (i + dr[k] >= 0 && i + dr[k] < n && j + dc[k] >= 0 && j + dc[k] < n && !visited[i + dr[k]][j + dc[k]] && arr[i + dr[k]][j + dc[k]] > a) {
                dfs(i + dr[k], j + dc[k], a);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        int min = 100;
        int max = 1;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, arr[i][j]);
                max = Math.max(max, arr[i][j]);
            }
        }
        int ansmin=0;
        for (int m = min-1; m <= max; m++) {
            int cnt=0;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && arr[i][j] > m) {
                        dfs(i,j,m);
                        ansmin=Math.max(ansmin,++cnt);
                    }
                }
            }
        }
        System.out.println(ansmin);
    }
}
