import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean isPalin(int a) {
        int n = a;
        int k = 0;
        while (n > 0) {
            k *= 10;
            k += n % 10;
            n /= 10;
        }
        if (a == k)
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        boolean[] prime = new boolean[2000000];
        prime[0] = prime[1] = true;

        for (int i = 2; i * i < 2000000; i++) {
            if (!prime[i]) {
                for (int j = i * i; j < 2000000; j += i) {
                    prime[j] = true;
                }
            }
        }
        for (int i = n; i < 2000000; i++) {
            if (!prime[i]) {
                if (isPalin(i)) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}


