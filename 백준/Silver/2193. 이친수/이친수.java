import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        long[][] dp = new long[91][2];
        dp[1][0] = 0;
        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[2][1] = 0;
        for(int i=3;i<=90;i++){
            dp[i][1]=dp[i-1][0];
            dp[i][0]=dp[i-1][0]+dp[i-1][1];
        }
        System.out.println(dp[n][0]+dp[n][1]);
    }
}