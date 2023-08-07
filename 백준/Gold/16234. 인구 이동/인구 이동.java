import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Nation{
        int x,y;
        Nation(int x ,int y){
            this.x=x;
            this.y=y;
        }
    }
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int bfs(){
        int cnt=0;
        Queue<Nation>q = new ArrayDeque<>();
        List<Nation>list;
        boolean[][] visited;
        boolean flag;
        while(true) {
            flag = false;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) continue;
                    int people = 0;
                    q.offer(new Nation(i, j));
                    list = new ArrayList<>();
                    visited[i][j] = true;
                    while (!q.isEmpty()) {
                        Nation nt = q.poll();
                        list.add(nt);
                        people += arr[nt.x][nt.y];
                        for (int k = 0; k < 4; k++) {
                            int nr = nt.x + dr[k];
                            int nc = nt.y + dc[k];
                            if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                            if (visited[nr][nc]) continue;
                            if (Math.abs(arr[nt.x][nt.y] - arr[nr][nc]) < left || Math.abs(arr[nt.x][nt.y] - arr[nr][nc]) > right)
                                continue;
                            flag = true;
                            visited[nr][nc] = true;
                            q.offer(new Nation(nr, nc));
                        }
                    }
                    int size = list.size();
                    for (Nation nation : list) {
                        arr[nation.x][nation.y] = people / size;
                    }
                }
            }
            if(!flag)break;
            cnt++;
        }
        return cnt;
    }
    static int n,left,right;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        left = Integer.parseInt(st.nextToken());
        right = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());

    }
}
