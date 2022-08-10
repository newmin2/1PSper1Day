import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Integer[] arr = new Integer[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,comp);
        int min=Integer.MAX_VALUE;
        int minidx=0;
        for(int i=0; i<N-1; i++){
            min=Math.min(Math.abs(arr[i]+arr[i+1]),min);
            if(min==Math.abs(arr[i]+arr[i+1]))
                minidx=i;
        }
        if(arr[minidx+1]>0)
            System.out.println(arr[minidx]+" "+arr[minidx+1]);
        else
            System.out.println(arr[minidx+1]+" "+arr[minidx]);

    }
    static Comparator<Integer> comp = (o1, o2) -> Math.abs(o1)-Math.abs(o2);
}
