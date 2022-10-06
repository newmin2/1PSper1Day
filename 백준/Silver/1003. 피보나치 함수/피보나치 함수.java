import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] dp = new int[41];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=40;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        for(int i=0;i<n;i++){
            int a = Integer.parseInt(bf.readLine());
            if(a==0)
                System.out.println(1+" "+0);
            else
                System.out.println(dp[a-1]+" "+dp[a]);
        }
    }
}
