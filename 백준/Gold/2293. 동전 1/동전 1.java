import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[10001][n+1];
        int[] arr = new int[n+1];
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(bf.readLine());
            min = Math.min(min,arr[i]);
        }
        Arrays.sort(arr);
        Arrays.fill(dp[min],1);
        dp[min][0]=0;
        for(int i=min+1;i<10001;i++){
            for(int j=1;j<=n;j++){
                if(i<arr[j]){
                    dp[i][j]+=dp[i][j-1];
                }else{
                    dp[i][j]=dp[i-arr[j]][n]-dp[i-arr[j]][j-1]+dp[i][j-1];
                }
                if(i==arr[j])dp[i][j]++;
            }
        }
        System.out.println(dp[k][n]);
    }
}