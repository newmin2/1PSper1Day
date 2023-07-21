import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static PriorityQueue<Puyo> pq;
    static char[][] arr;

    static int bfs() {
        Queue<Puyo> q = new ArrayDeque<>();
        boolean[][] visited;
        int ans = 0;
        loop:
        while (true) {
            int[][] realColumn = new int[12][6];
            visited = new boolean[12][6];
            int flag = 0;
            for (int x = 11; x >= 0; x--) {
                for (int y = 0; y < 6; y++) {
                    if (arr[x][y] == '.' || visited[x][y]) continue;
                    Puyo ppuyo = new Puyo(x, y, arr[x][y]);
                    q.offer(ppuyo);
                    visited[ppuyo.x][ppuyo.y] = true;
                    int[][] column = new int[12][6];
                    int cnt = 0;
                    while (!q.isEmpty()) {
                        Puyo puyo = q.poll();
                        column[puyo.x][puyo.y]++;
                        cnt++;
                        for (int i = 0; i < 4; i++) {
                            int nr = puyo.x + move[i][0];
                            int nc = puyo.y + move[i][1];
                            if (nr < 0 || nc < 0 || nr >= 12 || nc >= 6) continue;
                            if (!visited[nr][nc] && arr[nr][nc] == puyo.info) {
                                visited[nr][nc] = true;
                                q.offer(new Puyo(nr, nc, puyo.info));
                            }
                        }
                    }
                    if (cnt >= 4) {
                        for (int i = 0; i < 12; i++) {
                            for (int j = 0; j < 6; j++) {
                                realColumn[i][j] += column[i][j];
                            }
                        }
                        flag++;
                    }
                }
            }
            if (flag == 0) return ans;
            for (int i = 0; i < 6; i++) {
                int num = 0;
                for (int j = 11; j >= 0; j--) {
                    if (realColumn[j][i] == 1) {
                        num++;
                    } else {
                        if (num != 0) {
                            arr[j + num][i] = arr[j][i];
                            arr[j][i]='.';
                        }
                    }
                }
            }
            ans++;
        }
    }

    static class Puyo {
        int x, y;
        char info;

        Puyo(int x, int y, char info) {
            this.x = x;
            this.y = y;
            this.info = info;
        }
    }

    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[12][6];
        pq = new PriorityQueue<>((p1, p2) -> p1.x == p2.x ? p1.y - p2.y : p2.x - p1.x);
        for (int i = 0; i < 12; i++) {
            arr[i] = bf.readLine().toCharArray();
        }
        System.out.println(bfs());
    }
}