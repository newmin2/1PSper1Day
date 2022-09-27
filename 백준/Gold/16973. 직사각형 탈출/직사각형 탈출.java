import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] arr,visited;
    static Queue<Pair> q = new LinkedList<>();
    static int h, w, fc, fr, sc, sr, n, m;

    static int bfs() {
        int cnt = 0;
        q.offer(new Pair(sr, sc));
        arr[sr][sc] = true;
        while (!q.isEmpty()) {
            int qsize = q.size();
            for (int i = 0; i < qsize; i++) {
                Pair p = q.poll();
                if (p.x == fr && p.y == fc) {
                    return cnt;
                }
                for (int j = 0; j < 4; j++) {
                    int nr = p.x + dr[j];
                    int nc = p.y + dc[j];
                    if (nr + h - 1 >= n || nr < 0 || nc + w - 1 >= m || nc < 0 ||arr[nr][nc]) continue;
                    if (check(nr, nc, j)) {
                        q.offer(new Pair(nr, nc));
                        arr[nr][nc] = true;
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
    static boolean check(int x, int y, int k) {
        if (k == 0) {
            for (int i = y; i < y + w; i++) {
                if (visited[x][i])
                    return false;
            }
        } else if(k==1){
            for (int i = y; i < y+ w; i++) {
                if (visited[x+h-1][i])
                    return false;
            }
        }else if(k==2){
            for (int i = x; i < x + h; i++) {
                if (visited[i][y])
                    return false;
            }
        }else {
            for (int i = x; i < x + h; i++) {
                if (visited[i][y+w-1])
                    return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new boolean[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                if (st.nextToken().equals("1")) {
                    arr[i][j] = true;
                    visited[i][j] = true;
                }
            }
        }
        st = new StringTokenizer(bf.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        sr = Integer.parseInt(st.nextToken()) - 1;
        sc = Integer.parseInt(st.nextToken()) - 1;
        fr = Integer.parseInt(st.nextToken()) - 1;
        fc = Integer.parseInt(st.nextToken()) - 1;
        int a = bfs();
        if (a == -1)
            System.out.println(-1);
        else
            System.out.println(a);
    }
}
