import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        long[] dp = new long[101];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        dp[3]=1;
        dp[4]=2;
        dp[5]=2;
        for(int i=6;i<101;i++){
            dp[i]=dp[i-5]+dp[i-1];
        }
        for(int t=0;t<T;t++){
            System.out.println(dp[Integer.parseInt(bf.readLine())]);
        }
    }
}