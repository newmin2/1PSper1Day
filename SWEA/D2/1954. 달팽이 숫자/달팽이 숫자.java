import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        int[][] arr;
        for(int t=1;t<=T;t++){
            int n =Integer.parseInt(bf.readLine());
            arr = new int[n][n];
            int num=0;
            int a=0;
            loop:
            while(true){
                for(int i=a;i<n-1-a;i++){
                    arr[a][i]=++num;
                    if(num==n*n)
                        break loop;
                }
                for(int i=a;i<n-1-a;i++){
                    arr[i][n-a-1]=++num;
                    if(num==n*n)
                        break loop;
                }
                for(int i=n-a-1;i>a;i--){
                    arr[n-a-1][i]=++num;
                    if(num==n*n)
                        break loop;
                }
                for(int i=n-a-1; i>a;i--){
                    arr[i][a]=++num;
                    if(num==n*n)
                        break loop;
                }
                if(a==n-a-1){
                    arr[a][a]=++num;
                    break loop;
                }
                a++;
            }
            int cnt=0;
            System.out.println("#"+t);
            for(int[] i: arr)
                for(int j : i) {
                    System.out.print(j+" ");
                    cnt++;
                    if(cnt==n) {
                        System.out.println();
                        cnt=0;
                    }
                }
        }
    }
}
