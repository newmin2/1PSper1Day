import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++)
            arr[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        int[] arr2 =new int[M];
        for(int i=0; i<M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch(arr2[i], 0, N-1));

        }
    }
    static int binarySearch(int find, int first, int end){
        int mid;
        while(first<=end){
            mid = (first+end)/2;
            if(find==arr[mid])
                return 1;
            else if(find>arr[mid])
                first =mid+1;
            else
                end = mid-1;
        }
        return 0;
    }
}
