import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] arr;
    static int n;
    static int [][] dp;
    static int dfs(int i, int j, int cnt){
//        System.out.println(i+" "+j+" "+cnt);
        if(dp[i][j]!=0)
            return dp[i][j]+cnt;
        for(int k=0;k<4;k++){
            int nr = i+dr[k];
            int nc = j+dc[k];
            if(nr<0||nr>=n||nc<0||nc>=n)continue;
            if(arr[nr][nc]<=arr[i][j])continue;
            dp[i][j]=Math.max(dfs(nr,nc,cnt+1)-cnt,dp[i][j]);
        }
        return dp[i][j]+cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st= new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]==0)
                    dfs(i,j,0);
            }
        }
        int answer=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                answer=Math.max(dp[i][j],answer);
            }
        }
        System.out.println(answer+1);
    }
}
