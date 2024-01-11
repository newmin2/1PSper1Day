import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int a =1;
        int powB= a*(a+1)/2+1;
        int[] arr = new int[31623];
        while(powB<=1_000_000_001){
            if(powB==Math.pow((int)Math.sqrt(powB),2)){
                arr[(int)Math.sqrt(powB)]++;
            }
            a++;
            powB=a*(a+1)/2+1;
        }
        for(int i=1;i<31623;i++){
            arr[i]+=arr[i-1];
        }
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int caseNum = 1;
        while(true){
            st = new StringTokenizer(bf.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if(c==0&&d==0) break;
            int start = (int)Math.sqrt(c);
            int end = (int)(Math.sqrt(d-1));
            sb.append("Case "+caseNum+++": ").append(arr[end]-arr[start]).append('\n');
        }
        System.out.println(sb);
    }
}
