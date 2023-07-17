import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] s1 = bf.readLine().toCharArray();
        char[] s2 = bf.readLine().toCharArray();
        int[][] dp = new int[s1.length+1][s2.length+1];
        dp[0][0]=0;
        for(int i=0;i<=s1.length-1;i++){
            for(int j=0;j<=s2.length-1;j++){
                if(s1[i]==s2[j]){
                    dp[i+1][j+1]=dp[i][j]+1;
                }else{
                    dp[i+1][j+1]=Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        System.out.println(dp[s1.length][s2.length]);
    }
}