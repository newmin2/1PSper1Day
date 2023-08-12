import java.util.*;
import java.io.*;


public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        long ans =n;
        int sum=0;
        boolean[] cnt = new boolean[100001];
        int start=0;
        int end=1;
        cnt[arr[start]]=true;
        while(end<n){
            if(start==end){
                cnt[arr[end++]]=true;
                continue;
            }
            if(cnt[arr[end]]){
                if(sum>0) ans+=sum--;
                cnt[arr[start++]]=false;
            }else{
                cnt[arr[end]]=true;
                end++;
                sum++;
            }
        }
        ans+=((long) sum *(sum+1))>>1;
        System.out.println(ans);
    }
}