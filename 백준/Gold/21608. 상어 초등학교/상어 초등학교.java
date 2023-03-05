import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pair {
        int value, emp, x, y;

        Pair(int value, int emp, int x, int y) {
            this.emp = emp;
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] arr = new int[n][n];
        int[][] like = new int[n * n + 1][4];
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.value - o2.value == 0) {
                    if (o1.emp - o2.emp == 0) {
                        if (o1.x - o2.x == 0)
                            return o1.y - o2.y;
                        else return o1.x - o2.x;
                    } else return o2.emp - o1.emp;
                } else return o2.value - o1.value;
            }
        });
        int answer = 0;
        for (int i = 0; i < n * n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int me = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) {
                like[me][j] = Integer.parseInt(st.nextToken());
            }
            if (i == 0) {
                arr[1][1] = me;
                continue;
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (arr[j][k] != 0) continue;
                    int empCnt = 0;
                    int likeCnt = 0;
                    for (int a = 0; a < 4; a++) {
                        int nr = j + dr[a];
                        int nc = k + dc[a];
                        if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                        if (arr[nr][nc] == 0) {
                            empCnt++;
                        }
                        for (int b = 0; b < 4; b++) {
                            if (arr[nr][nc] == like[me][b]) {
                                likeCnt++;
                            }
                        }
                    }
                    pq.offer(new Pair(likeCnt, empCnt, j, k));
                }
            }
            Pair p = pq.poll();
            arr[p.x][p.y] = me;
            pq.clear();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                    for (int a = 0; a < 4; a++) {
                        if (arr[nr][nc] == like[arr[i][j]][a]) {
                            cnt++;
                        }
                    }
                }
                if (cnt == 4) answer += 1000;
                else if (cnt == 3) answer += 100;
                else if (cnt == 2) answer += 10;
                else if (cnt == 1) answer += 1;
            }
        }
        System.out.println(answer);
    }
}
