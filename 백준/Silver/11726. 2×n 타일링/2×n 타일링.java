import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BigInteger[] dp = new BigInteger[1001];
        dp[0]=new BigInteger("1");
        dp[1]=new BigInteger("1");
        for(int i=2;i<=1000;i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }
        System.out.println(dp[Integer.parseInt(bf.readLine())].mod(new BigInteger("10007")));
    }
}
