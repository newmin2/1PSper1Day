import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int cnt;

    static void rectang(int a) {
        int b=a;
        while(a*b<=n) {
            cnt++;
            b++;
        }
        if(b==a)
            return;
        rectang(++a);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        rectang(1);
        System.out.println(cnt);
    }
}
