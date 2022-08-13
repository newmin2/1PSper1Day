import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        int[][] arr = new int[100][100];
        for(int i=0; i<n; i++){
            st= new StringTokenizer(bf.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            for(int j=x; j<x+10 ;j++){
                for(int k=y; k<y+10 ;k++){
                    arr[j][k]=1;
                }
            }
        }
        int sum=0;
        for(int i=0; i<=99; i++){
            for(int j=0; j<=99; j++){
                sum+=arr[i][j];
            }
        }
        System.out.println(sum);
    }
}
