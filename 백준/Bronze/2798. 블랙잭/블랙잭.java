import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<N-2;i++) {
            for(int j=i+1;j<N-1;j++){
                for(int k=j+1; k<N;k++){
                    sum=arr[i]+arr[j]+arr[k];
                    if(sum<=M)
                        max=Math.max(sum,max);
                }
            }
        }
        System.out.println(max);
    }
}
