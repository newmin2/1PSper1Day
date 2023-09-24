import java.io.*;
import java.util.*;

public class Main {
    static int[][] move = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{1,1},{1,-1},{-1,1}};
    static int bfs(int[][] arr){
        Queue<Pair> q = new ArrayDeque<>();
        int cnt=0;
        for(Pair p:list){
            if(arr[p.x][p.y]==0)continue;
            q.offer(p);
            while(!q.isEmpty()){
                Pair pair = q.poll();
                arr[pair.x][pair.y]=0;
                for(int i=0;i<8;i++){
                    int nr = pair.x+move[i][0];
                    int nc = pair.y+move[i][1];
                    if(nr<0||nc<0||nr>=n||nc>=m)continue;
                    if(arr[nr][nc]==0)continue;
                    q.offer(new Pair(nr,nc));
                    arr[nr][nc]=0;
                }
            }
            cnt++;
        }
        return cnt;
    }
    static int n,m;
    static List<Pair> list;
    static class Pair{
        int x,y;
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(arr[i][j]==1)list.add(new Pair(i,j));
            }
        }
        System.out.println(bfs(arr));
    }
}