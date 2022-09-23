import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
    static Queue<Pair> q = new LinkedList<>();
    static boolean[][] visited;
    static class Pair {
        int x, y;
        int idx = 0;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] arr;
    static int cnt, w, h;

    static void bfs(Pair pa) {
        visited[pa.x][pa.y] = true;
        q.offer(pa);
        while (!q.isEmpty()) {
            Pair p=q.poll();
            for (int j = 0; j < 8; j++) {
                if (p.x + dr[j] < w && p.x + dr[j] >= 0 && p.y + dc[j] < h && p.y + dc[j] >= 0 &&
                        !visited[p.x + dr[j]][p.y + dc[j]] && arr[p.x + dr[j]][p.y + dc[j]] == 1) {
                    q.offer(new Pair(p.x + dr[j], p.y + dc[j]));
                    visited[p.x + dr[j]][p.y + dc[j]] = true;

                }
            }
        }
        cnt++;
    }

        public static void main (String[]args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String s = bf.readLine();
                if (s.equals("0 0"))
                    break;
                StringTokenizer st = new StringTokenizer(s);
                h = Integer.parseInt(st.nextToken());
                w = Integer.parseInt(st.nextToken());
                arr = new int[w][h];
                visited = new boolean[w][h];
                for (int i = 0; i < w; i++) {
                    st = new StringTokenizer(bf.readLine());
                    for (int j = 0; j < h; j++) {
                        arr[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
                for (int i = 0; i < w; i++) {
                    for (int j = 0; j < h; j++) {
                        if (arr[i][j]==1&&!visited[i][j])
                            bfs(new Pair(i, j));
                    }
                }
                System.out.println(cnt);
                cnt = 0;
            }
        }
    }
