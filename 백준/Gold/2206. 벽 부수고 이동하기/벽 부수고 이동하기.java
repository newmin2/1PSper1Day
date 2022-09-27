import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<Pair> q = new LinkedList<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int n, m;

    static class Pair {
        int x, y;
        boolean did;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int bfs(boolean[][] arr, boolean[][] arr1) {
        int cnt = 0;
        q.offer(new Pair(0, 0));
        arr[0][0] = true;
        while (!q.isEmpty()) {
            int qsize = q.size();
            for (int j = 0; j < qsize; j++) {
                Pair p = q.poll();
                for (int i = 0; i < 4; i++) {
                    if (p.x + dr[i] < n && p.x + dr[i] >= 0 && p.y + dc[i] < m && p.y + dc[i] >= 0) {
                        if (p.did) {
                            if (!arr1[p.x + dr[i]][p.y + dc[i]]) {
                                Pair pa = new Pair(p.x + dr[i], p.y + dc[i]);
                                if (p.did)
                                    pa.did = true;
                                q.offer(pa);
                            }
                            arr1[p.x + dr[i]][p.y + dc[i]] = true;
                        } else {
                            Pair pa = new Pair(p.x + dr[i], p.y + dc[i]);
                            if (!arr[p.x + dr[i]][p.y + dc[i]]) {
                                arr[p.x + dr[i]][p.y + dc[i]] = true;
                            } else {
                                pa.did = true;
                                arr1[p.x + dr[i]][p.y + dc[i]] = true;
                            }
                            q.offer(pa);
                        }
                        if (p.x + dr[i] == n - 1 && p.y + dc[i] == m - 1) {
                            return cnt + 2;
                        }
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[n][m];
        boolean[][] arr1 = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = bf.readLine();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == '1') {
                    arr[i][j] = true;
                    arr1[i][j] = true;
                }
            }
        }
        int a = bfs(arr, arr1);
        if(n==1&&m==1)
            System.out.println(1);
        else {
            if (a == -1)
                System.out.println(-1);
            else
                System.out.println(a);
        }
    }
}
