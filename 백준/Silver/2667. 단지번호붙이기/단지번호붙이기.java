import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1,0, -1};
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
    static int n;

    static int bfs(Pair pa) {
        int cnt=1;
        visited[pa.x][pa.y] = true;
        q.offer(pa);
        while (!q.isEmpty()) {
            Pair p=q.poll();
            for (int j = 0; j < 4; j++) {
                if (p.x + dr[j] < n && p.x + dr[j] >= 0 && p.y + dc[j] < n && p.y + dc[j] >= 0 &&
                        !visited[p.x + dr[j]][p.y + dc[j]] && arr[p.x + dr[j]][p.y + dc[j]] == 1) {
                    q.offer(new Pair(p.x + dr[j], p.y + dc[j]));
                    visited[p.x + dr[j]][p.y + dc[j]] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }

        public static void main (String[]args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            n =Integer.parseInt(bf.readLine());
            arr=new int[n][n];
            visited=new boolean[n][n];
            for(int i=0;i<n;i++){
                String s=bf.readLine();
                for(int j=0;j<n;j++){
                    arr[i][j]=s.charAt(j)-'0';
                }
            }
            ArrayList<Integer>list = new ArrayList<>();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(arr[i][j]==1&&!visited[i][j])
                        list.add(bfs(new Pair(i,j)));
                }
            }
            Collections.sort(list);
            System.out.println(list.size());
            for(int i :list)
                System.out.println(i);
        }
    }
