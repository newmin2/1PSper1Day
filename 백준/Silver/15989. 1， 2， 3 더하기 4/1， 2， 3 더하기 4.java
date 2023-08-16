import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        int[][] dp = new int[10001][3];
        dp[1][0]=1; dp[2][0]=2; dp[2][1]=1; dp[3][0]=3; dp[3][2]=1;
        for(int i=4;i<10001;i++){
            dp[i][1]=dp[i-2][1]+dp[i-2][2];
            dp[i][2]=dp[i-3][2];
            dp[i][0]=dp[i-1][0]+dp[i][1]+dp[i][2];
        }
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<T;t++){
            sb.append(dp[Integer.parseInt(bf.readLine())][0]).append('\n');
        }
        System.out.println(sb);
    }
}