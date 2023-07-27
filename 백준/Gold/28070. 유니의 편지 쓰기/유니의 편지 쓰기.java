import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[96002];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String start = st.nextToken();
            String end = st.nextToken();
            arr[(Integer.parseInt(start.substring(0, 4)) - 2000) * 12 + Integer.parseInt(start.substring(5, 7))]++;
            arr[(Integer.parseInt(end.substring(0, 4)) - 2000) * 12 + Integer.parseInt(end.substring(5, 7)) + 1]--;
        }
        int max=Integer.MIN_VALUE;
        int sum=0;
        int idx=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0)continue;
            sum+=arr[i];
            if(max<sum){
                max=sum;
                idx=i;
            }
        }
        int year = idx/12+2000;
        int month = idx%12;
        if(month==0){
            year--;
            month=12;
        }
        String str = month<10?"-0":"-";
        System.out.println(year+str+month);
    }
}

