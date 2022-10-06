import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dr= {-1,1,0,0};
    static int n,m;
    static int[] dc= {0,0,-1,1};
    static int[][] arr;
    static long[][] memo;
    static long dfs(int x, int y){
        if(x==n-1&&y==m-1){
            return 1;
        }
        if(memo[x][y]!=-1)
            return memo[x][y];
        long result=0;
        for(int i=0;i<4;i++){
            int nr = x+dr[i];
            int nc = y+dc[i];
            if(nr<0||nc<0||nr>=n||nc>=m)continue;
            if(arr[nr][nc]>=arr[x][y])continue;
            result+=dfs(nr,nc);
        }
        memo[x][y]=result;
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        arr= new int[n][m];
        memo=new long[n][m];
        for(int i=0;i<n;i++){
            st= new StringTokenizer(bf.readLine());
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                memo[i][j]=-1;
            }
        }
        System.out.println(dfs(0,0));

    }
}
