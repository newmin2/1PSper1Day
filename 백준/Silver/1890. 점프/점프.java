import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {0,1};
    static int[] dc = {1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] arr = new int[n][n];
        long[][] dp = new long[n][n];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        if(arr[0][0]>n-1) {
            System.out.println(0);
            return;
        }
        dp[0][0]=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==n-1&&j==n-1)break;

                if(arr[i][j]==0)continue;
                int jump =arr[i][j];

                for(int k=0;k<2;k++){
                    int nr = i+dr[k]*jump;
                    int nc = j+dc[k]*jump;
                    if(nr<0||nr>n-1||nc<0||nc>n-1)continue;
                    dp[nr][nc]+=dp[i][j];
                }
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}