import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 1000000000;
        int mid = 0;
        while (start <= end) {
            long sum = 0;
            mid = (start + end) / 2;
            for (int i : arr) {
                if (i - mid >= 0)
                    sum += (i - mid);
            }
            if (sum > M - 1)
                start = mid + 1;
            else
                end = mid - 1;
        }
        System.out.println(end);
    }
}
