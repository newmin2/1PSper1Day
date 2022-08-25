import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(bf.readLine());
            char[][] arr = new char[n][n];
            for (int i = 0; i < n; i++) {
                String s = bf.readLine();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }
            String ans = "NO";
            int cnt = 0;
            loop:
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 'o') {
                        for (int k = 1; k < 5; k++) {
                            if (j + k < n && arr[i][j + k] == 'o')
                                cnt++;
                        }
                        if (cnt == 4) {
                            ans = "YES";
                            break loop;
                        }
                    }
                    cnt = 0;
                    if (arr[i][j] == 'o') {
                        for (int k = 1; k < 5; k++) {
                            if (i + k < n && arr[i + k][j] == 'o')
                                cnt++;
                        }
                        if (cnt == 4) {
                            ans = "YES";
                            break loop;
                        }
                    }
                    cnt = 0;
                    if (arr[i][j] == 'o') {
                        for (int k = 1; k < 5; k++) {
                            if (i + k < n && j + k < n && arr[i + k][j + k] == 'o')
                                cnt++;
                        }
                        if (cnt == 4) {
                            ans = "YES";
                            break loop;
                        }
                    }
                    cnt = 0;
                    if (arr[i][j] == 'o') {
                        for (int k = 1; k < 5; k++) {
                            if (i + k < n && j - k >= 0 && arr[i + k][j - k] == 'o')
                                cnt++;
                        }
                        if (cnt == 4) {
                            ans = "YES";
                            break loop;
                        }
                    }
                    cnt = 0;
                }
            }
            System.out.println("#" + t + " " + ans);
        }
    }
}
