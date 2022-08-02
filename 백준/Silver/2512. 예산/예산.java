import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];
        long sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(bf.readLine());
        int first = 0;
        int end = 100000;
        int mid = 0;
        if (sum <= M)
            System.out.println(arr[N - 1]);
        else {
            while (first <= end) {
                mid = (first + end) / 2;
                sum = 0;
                for (int i = 0; i < N; i++) {
                    if (arr[i] >= mid)
                        sum+=mid;
                    else
                        sum += arr[i];
                }
                if (sum > M)
                    end = mid - 1;
                else
                    first = mid + 1;

            }
            System.out.println(end);
        }
    }
}
