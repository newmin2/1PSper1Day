import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int i=0;
        int cnt=0;
        arr[i]++;
        while(arr[i]<m){
            if(arr[i]%2==1) {
                i += l;
                if (i >= n)
                    i -= n;
            }
            else{
                i-=l;
                if (i<0)
                    i+=n;
            }
            arr[i]++;
            cnt++;
        }
        System.out.println(cnt);
    }
}
