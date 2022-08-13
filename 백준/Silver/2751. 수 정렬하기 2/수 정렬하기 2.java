import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr= new int[N];
        int[] sorted = new int[N];
        int max=Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<N;i++){
            arr[i]=Integer.parseInt(bf.readLine());
            max=Math.max(arr[i],max);
            min=Math.min(arr[i],min);
        }
        int[] cnt= new int[max-min+1];
        for(int i:arr){
            cnt[i-min]++;
        }

        for(int i=0; i<cnt.length-1;i++){
            cnt[i+1]+=cnt[i];
        }
        for(int i=arr.length-1; i>=0; i--){
            sorted[--cnt[arr[i]-min]]=arr[i];
        }
        StringBuilder sb = new StringBuilder();
        for(int i: sorted)
            sb.append(i).append("\n");
        System.out.println(sb);
    }
}
