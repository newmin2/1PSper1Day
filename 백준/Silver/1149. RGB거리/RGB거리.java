import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(bf.readLine());
        int[][] dp = new int[2][3];
        StringTokenizer st =new StringTokenizer(bf.readLine());
        dp[0][0]=Integer.parseInt(st.nextToken());
        dp[0][1]=Integer.parseInt(st.nextToken());
        dp[0][2]=Integer.parseInt(st.nextToken());
        for(int i=1;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            dp[1][0]=Math.min(dp[0][1],dp[0][2])+Integer.parseInt(st.nextToken());
            dp[1][1]=Math.min(dp[0][0],dp[0][2])+Integer.parseInt(st.nextToken());
            dp[1][2]=Math.min(dp[0][1],dp[0][0])+Integer.parseInt(st.nextToken());
            dp[0][0]=dp[1][0];
            dp[0][1]=dp[1][1];
            dp[0][2]=dp[1][2];
        }
        System.out.println(Math.min(dp[1][2],Math.min(dp[1][0],dp[1][1])));
    }
}
