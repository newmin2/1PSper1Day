import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int l = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        Queue<Integer>bridge = new ArrayDeque<>();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }
        int time=0,onBridge= 0;
        int idx=0;
        while(true){
            if(bridge.size()>=l){
                onBridge-=bridge.poll();
            }
            if(idx<n&&onBridge+arr[idx]<=w){
                bridge.offer(arr[idx]);
                onBridge+=arr[idx++];
            }else{
                bridge.offer(0);
            }
            if(onBridge==0) break;
            ++time;
        }
        System.out.println(time==0?0:time+1);
    }
}
