import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        int sum = 0;
        String s = bf.readLine();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                cnt++;
            else {
                cnt--;
                if (s.charAt(i - 1) == '(') {
                    sum += cnt;
                } else
                    sum += 1;
            }
        }
        System.out.println(sum);
    }
}
