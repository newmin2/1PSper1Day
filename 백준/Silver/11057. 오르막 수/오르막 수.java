import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        long[][] dp = new long[1002][10];
        Arrays.fill(dp[1],1);
        long sum=10;
        for(int i=2;i<=1000;i++){
            dp[i][0]=sum;
            for(int j=1;j<=9;j++){
                dp[i][j]=dp[i][j-1]-dp[i-1][j-1];
                if(dp[i][j]<0)dp[i][j]+=10007;
                sum+=dp[i][j]%10007;
            }
            sum%=10007;
        }
        dp[1001][0]=sum;
        System.out.println(dp[n+1][0]);
    }
}