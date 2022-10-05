import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(bf.readLine());
        int[][] dp = new int[n][3];
        StringTokenizer st =new StringTokenizer(bf.readLine());
        dp[0][0]=Integer.parseInt(st.nextToken());
        dp[0][1]=Integer.parseInt(st.nextToken());
        dp[0][2]=Integer.parseInt(st.nextToken());
        for(int i=1;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+Integer.parseInt(st.nextToken());
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+Integer.parseInt(st.nextToken());
            dp[i][2]=Math.min(dp[i-1][1],dp[i-1][0])+Integer.parseInt(st.nextToken());
        }
        System.out.println(Math.min(dp[n-1][2],Math.min(dp[n-1][0],dp[n-1][1])));
    }
}
