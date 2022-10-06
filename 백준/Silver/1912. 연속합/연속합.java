import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(bf.readLine());
        int[] arr= new int[n+1];
        int[] dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        dp[0]=arr[0];
        int tmp=arr[0];
        for(int i=1;i<=n;i++){
            dp[i]=Math.max(tmp,dp[i-1]);
            if(tmp<0)
                tmp=0;
            tmp+=arr[i];
        }
        System.out.println(dp[n]);
    }
}
