import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[] arr = new int[n+1];
        for(int i=1;i<n+1;i++){
            arr[i]= Integer.parseInt(st.nextToken())+arr[i-1];
        }
        //입력 끝
        int start,end;
        for(int i=0;i<m;i++){
            st = new StringTokenizer(bf.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            System.out.println(arr[end]-arr[start-1]);
        }
    }
}