import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int ans=0;
        for(int i=0;i<n;i++){
            int start=0;
            int end=n-1;
            while(start<end){
                if(arr[start]+arr[end]==arr[i]){
                    if(start==i){
                        start++;
                        continue;
                    }if(end==i){
                        end--;
                        continue;
                    }
                    ans++;
                    break;
                }else if(arr[start]+arr[end]>arr[i]){
                    end--;
                }else start++;
            }
        }
        System.out.println(ans);
    }
}
