import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int K= Integer.parseInt(st.nextToken());
        int N =Integer.parseInt(st.nextToken());
        long[] arr = new long[K];
        for(int i =0; i<K; i++){
            arr[i]=Long.parseLong(bf.readLine());
        }
        long start = 1;
        long end = Integer.MAX_VALUE;
        long mid=0;
        while(start<=end){
            mid = (start+end)/2;
            long sum = 0;
            for(long i :arr){
                sum+=(i/mid);
            }
            if(sum>N-1)
                start =mid+1;
            else
                end= mid-1;
        }
        System.out.println(end);
    }
}
