import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int fx;
    static int fy;
    static Queue<XY>q=new LinkedList<>();
    static int n;
    static int[] dr = {-1,1,2,2,1,-1,-2,-2};//우상부터
    static int[] dc = {2,2,1,-1,-2,-2,-1,1};
    static class XY{
        int x;
        int y;
    }
    static int bfs(int x, int y){
        arr[x][y]=1;
        XY xy = new XY();
        xy.x=x;
        xy.y=y;
        q.offer(xy);
        int level=0;
        int cnt=0;
        int a=1;
        while(!q.isEmpty()){
            XY xy2=q.poll();
            if(xy2.x==fx&&xy2.y==fy)
                return level;
            for(int i=0; i<8; i++){
                cnt++;
                if(xy2.x+dr[i]>=0&&xy2.y+dc[i]>=0&&xy2.x+dr[i]<n&&xy2.y+dc[i]<n&&arr[xy2.x+dr[i]][xy2.y+dc[i]]!=1){
                    arr[xy2.x+dr[i]][xy2.y+dc[i]]=1;
                    XY xy3 = new XY();
                    xy3.x=xy2.x+dr[i];
                    xy3.y=xy2.y+dc[i];
                    q.offer(xy3);
                }
            }
            if(cnt==8*a){
                a=q.size();
                level++;
                cnt=0;
            }
        }
        return 0;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int t=0; t<T;t++){
            n = Integer.parseInt(bf.readLine());
            arr = new int[n][n];
            st = new StringTokenizer(bf.readLine());
            int sx= Integer.parseInt(st.nextToken());
            int sy=Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());
            fx = Integer.parseInt(st.nextToken());
            fy = Integer.parseInt(st.nextToken());
            System.out.println(bfs(sx,sy));
            q.clear();
        }
    }
}
