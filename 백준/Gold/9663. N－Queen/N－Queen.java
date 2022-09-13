import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int n, ans;
    static int[] arr;

    static void queen(int cnt) {
        if (cnt == n) {
            ans++;
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < cnt; j++) {
                if (i == arr[j] || i == arr[j] + cnt - j || i == arr[j] - cnt + j) {
                    flag = false;
                    break;
                }
            }
            if (flag) arr[cnt]=i;
            else continue;
            queen(cnt + 1);
            arr[cnt]=0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr=new int[n];
        queen(0);
        System.out.println(ans);
    }
}