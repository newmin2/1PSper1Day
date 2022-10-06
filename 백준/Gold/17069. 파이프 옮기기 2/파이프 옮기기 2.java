import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] dpmove={{0,-1},{-1,0},{-1,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] arr = new int[n][n];
        long[][][] dp = new long[n][n][3];
        dp[0][1][0] = 1;
        dp[0][1][2] = 1;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (i == 0 && j == 1) continue;
                if (arr[i][j] == 1) continue;
                for (int k = 0; k < 3; k++) {
                    int nr = i + dpmove[k][0];
                    int nc = j + dpmove[k][1];
                    if (nr<0||nc<1||nr >= n || nc >= n) continue;
                    if(dp[nr][nc][k]==0) continue;
                    if(k==0) {
                        dp[i][j][0] += dp[i + dpmove[k][0]][j + dpmove[k][1]][k];
                        dp[i][j][2] += dp[i + dpmove[k][0]][j + dpmove[k][1]][k];
                    }
                    else if(k==1) {
                        dp[i][j][1] += dp[i + dpmove[k][0]][j + dpmove[k][1]][k];
                        dp[i][j][2] += dp[i + dpmove[k][0]][j + dpmove[k][1]][k];
                    }
                    else{
                        if(arr[i-1][j]==1||arr[i][j-1]==1) {
                            continue;
                        }
                        dp[i][j][0]+= dp[i + dpmove[k][0]][j + dpmove[k][1]][k];
                        dp[i][j][1]+= dp[i + dpmove[k][0]][j + dpmove[k][1]][k];
                        dp[i][j][2]+= dp[i + dpmove[k][0]][j + dpmove[k][1]][k];
                    }
                }
            }
        }
        System.out.println(Math.max(Math.max(dp[n - 1][n - 1][0],dp[n-1][n-1][1]),dp[n-1][n-1][2]));
    }
}
