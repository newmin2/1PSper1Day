import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int r = 0;
        for (int i = 1; i <= s.length(); i++) {
            if (s.length() % i == 0) {
                if (i <= s.length() / i)
                    r = i;
                else
                    break;
            }
        }
        int k = 0;
        char[][] arr = new char[s.length()/r][r];
        for (int j = 0; j < s.length() / r; j++) {
            for (int i = 0; i < r; i++) {
                arr[j][i] = s.charAt(k++);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < s.length() / r; j++) {
                System.out.print(arr[j][i]);
            }
        }
    }
}
