import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] arr2 = new int[N-1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(arr);
        for (int i = 0; i < N-1; i++) {
            arr2[i] = arr[i + 1] - arr[i];
        }
        int start = 1;
        int end = arr[N - 1];
        while (start <= end) {
            int mid = (start+end)/2;
            int sum = 0;
            int cnt=N;
            for (int i:arr2) {
                sum += i;
                if(sum<mid)
                    cnt--;
                else
                    sum=0;
            }
            if (cnt > C-1)
                start = mid + 1;
            else
                end = mid - 1;
        }

        System.out.println(end);
    }
}

