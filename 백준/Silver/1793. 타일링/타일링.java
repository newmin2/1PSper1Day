import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BigInteger[] dp = new BigInteger[251];
        dp[0]=new BigInteger("1");
        dp[1]=new BigInteger("1");
        for(int i=2;i<=250;i++){
            dp[i]=dp[i-1].add(dp[i-2].multiply(new BigInteger("2")));
        }
        while(true){
            String a = bf.readLine();
            if(a==null)
                break;
            System.out.println(dp[Integer.parseInt(a)]);
        }
    }
}
