import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        long[] bottom = new long[h+1];
        long[] top = new long[h+1];
        for(int i=0;i<n;i++){
            int each= Integer.parseInt(bf.readLine());
            if(i%2==0)bottom[each]++;
            else top[each]++;
        }

        for(int i=h;i>=2;i--){
            bottom[i-1]+=bottom[i];
            top[i-1]+=top[i];
        }
        long min = Long.MAX_VALUE;
        int cnt =0;
        for(int i=1;i<=h;i++){
            if(min>top[h-i+1]+bottom[i]){
                min=top[h-i+1]+bottom[i];
                cnt=1;
            }else if(min==top[h-i+1]+bottom[i]){
                cnt++;
            }
        }
        System.out.println(min+" "+cnt);
    }
}