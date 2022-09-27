import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<Pair> q = new LinkedList<>();
    static boolean[][][] arr;
    static int[] dr = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] dc = {-1, 1, 2, 2, 1, -1, -2, -2};
    static int[] mdr = {-1, 1, 0, 0};
    static int[] mdc = {0, 0, -1, 1};
    static int k, w, h;

    static class Pair {
        int x, y;
        int did;

        Pair(int x, int y,int did) {
            this.x = x;
            this.y = y;
            this.did=did;
        }
    }
    static int bfs() {
        int cnt = 0;
        q.offer(new Pair(0, 0, k));
        for(int i=0;i<=k;i++) {
            arr[0][0][i] = true;
        }
        while (!q.isEmpty()) {
            int qsize = q.size();
            for (int j = 0; j < qsize; j++) {
                Pair p = q.poll();
                if (p.did> 0) {
                    for (int i = 0; i < 8; i++) {
                        if (p.x + dr[i] < w && p.x + dr[i] >= 0 && p.y + dc[i] < h && p.y + dc[i] >= 0) {
                            if (arr[p.x + dr[i]][p.y + dc[i]][k]||arr[p.x + dr[i]][p.y + dc[i]][p.did-1])
                                continue;
                            if(p.x+dr[i]==w-1&&p.y+dc[i]==h-1)
                                return cnt;
                            q.offer(new Pair(p.x + dr[i], p.y + dc[i], p.did-1));
                            arr[p.x + dr[i]][p.y + dc[i]][p.did-1]=true;
                        }
                    }
                }
                for (int i = 0; i < 4; i++) {
                    if (p.x + mdr[i] < w && p.x + mdr[i] >= 0 && p.y + mdc[i] < h && p.y + mdc[i] >= 0) {
                        if (arr[p.x + mdr[i]][p.y + mdc[i]][k]||arr[p.x + mdr[i]][p.y + mdc[i]][p.did])
                            continue;
                        if(p.x+mdr[i]==w-1&&p.y+mdc[i]==h-1)
                            return cnt;
                        q.offer(new Pair(p.x + mdr[i], p.y + mdc[i], p.did));
                        arr[p.x + mdr[i]][p.y + mdc[i]][p.did]=true;
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        arr = new boolean[w][h][k+1];
        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < h; j++) {
                if (st.nextToken().equals("1")) {
                    arr[i][j][k] = true;
                }
            }
        }
        int a = bfs();
        if(w==1&&h==1){
            System.out.println(0);
        }else {
            if (a == -1)
                System.out.println(-1);
            else
                System.out.println(a + 1);
        }
    }
}
