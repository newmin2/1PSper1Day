import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n;
    static int ans;
    static void bfs(int x,int y,int state){
        if(x>=n||y>=n||arr[x][y]==1||(state==2&&(arr[x-1][y]==1||arr[x][y-1]==1)))
            return;
        if(x==n-1&&y==n-1){
            ans++;
        }
        if(state==0){
            bfs(x,y+1,0);
            bfs(x+1,y+1,2);
        }else if(state==1){
            bfs(x+1,y,1);
            bfs(x+1,y+1,2);
        }else{
            bfs(x,y+1,0);
            bfs(x+1,y,1);
            bfs(x+1,y+1,2);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<n; j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        bfs(0,1,0);
        System.out.println(ans);
    }
}
