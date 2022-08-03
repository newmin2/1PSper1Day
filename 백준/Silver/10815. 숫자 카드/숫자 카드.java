import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M=Integer.parseInt(bf.readLine());
        int[] arr2 = new int[M];
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<M;i++){
            arr2[i]=Integer.parseInt(st.nextToken());
            binarySearch(arr2[i]);
        }

    }
    static void binarySearch(int a){
        int first=0;
        int end=N-1;
        int mid=0;
        while(first<=end){
            mid=(first+end)/2;
            if(a==arr[mid]){
                System.out.print(1+" ");
                return;
            }else if(a>arr[mid])
                first=mid+1;
            else
                end=mid-1;
        }
        System.out.print(0+" ");
    }
}
