import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int max=0;
        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(bf.readLine());
            max=Math.max(arr[i],max);
        }
        int start=max;
        int end=1000000000;
        int mid;
        while(start<=end){
            int cnt=1;
            mid=(start+end)/2;
            int sum=0;
            for(int i:arr){
                sum+=i;
                if(sum>mid){
                    cnt++;
                    sum=i;
                }
            }
            if(cnt>M)
                start=mid+1;
            else
                end=mid-1;
        }
        System.out.println(start);
    }
}

