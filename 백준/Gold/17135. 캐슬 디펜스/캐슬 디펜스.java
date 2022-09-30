import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
    static int n, m, d, cnt;
    static int max = Integer.MIN_VALUE;
    static int[][] arr, arr2;
    static HashSet<Pair> set;

    static void archer(int idx, int depth) {
        if (depth == 3) {
            castle();
            return;
        }
        for (int i = idx; i < m; i++) {
            arr[n][i] = -1;
            archer(i + 1, depth + 1);
            arr[n][i] = -2;
        }
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object t) {
            Pair p = (Pair) t;
            if (this.x == p.x && this.y == p.y)
                return true;
            return false;
        }

        @Override
        public int hashCode() {
            return this.x * 103 + this.y;
        }
    }

    static boolean[][] visited;
    static int[] dr = {0, -1, 0};
    static int[] dc = {-1, 0, 1};
    static Queue<Pair> q = new LinkedList<>();
    static ArrayList<Pair> list = new ArrayList<>();

    static void bfs(int x, int y) {
        boolean[][] visited = new boolean[n][m];
        q.offer(new Pair(x, y));
        int cnt = 1;
        while (!q.isEmpty()) {
            int qsize=q.size();
            for(int j=0;j<qsize;j++) {
                Pair p = q.poll();
                for (int i = 0; i < 3; i++) {
                    int nr = p.x + dr[i];
                    int nc = p.y + dc[i];
                    if (nr < 0 || nr >= x || nc < 0 || nc >= m) continue;
                    if (visited[nr][nc]) continue;
                    if (arr2[nr][nc] == 1) {
                        Pair a = new Pair(nr, nc);
                        set.add(a);
                        list.add(a);
                        return;
                    } else {
                        Pair a = new Pair(nr, nc);
                        q.offer(a);
                        visited[nr][nc] = true;
                    }
                }
            }
            cnt++;
            if (cnt > d)
                return;
        }
    }

    static void castle() {
        set = new HashSet<>();
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m;j++){
                arr2[i][j]=arr[i][j];
            }
        }
        for (int a = n; a >= 1; a--) {

            for (int k = 0; k < m; k++) {
                if (arr2[a][k] == -1) {
                    bfs(a, k);
                    q.clear();
                }
            }
            for(int i=0;i<list.size();i++){
                arr2[list.get(i).x][list.get(i).y]=0;
            }
            list.clear();
            arr2[a-1]=arr[n].clone();
        }
        max = Math.max(set.size(), max);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m];
        arr2 = new int[n + 1][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        archer(0, 0);
        System.out.println(max);

    }
}
