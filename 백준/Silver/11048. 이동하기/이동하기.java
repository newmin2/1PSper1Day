import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] dpmove={{0,-1},{-1,-1},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr= new int[n][m];
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            st= new StringTokenizer(bf.readLine());
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0]=arr[0][0];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0&&j==0) continue;
                for(int k=0;k<3;k++){
                    if(i+dpmove[k][0]<0||i+dpmove[k][0]>=n||j+dpmove[k][1]<0||j+dpmove[k][1]>=m) continue;
                    dp[i][j]=Math.max(dp[i+dpmove[k][0]][j+dpmove[k][1]],dp[i][j]);
                }
                dp[i][j]+=arr[i][j];
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}
