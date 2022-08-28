import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[8][8];
        for (int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(bf.readLine());
            for (int i = 0; i < 8; i++) {
                String s = bf.readLine();
                for (int j = 0; j < 8; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }
            int cnt = 0;
            int sum=0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < n / 2; k++) {
                        if (j + n - 1 < 8) {
                            if (arr[i][j+k] == arr[i][j + n - 1 - k])
                                sum++;
                            else
                                break;
                        }
                    }
                    if (sum==n/2)
                        cnt++;
                    sum=0;
                    for (int k = 0; k < n / 2; k++) {
                        if(i+n-1<8) {
                            if (arr[i+k][j] == arr[i + n - 1 - k][j])
                                sum++;
                            else
                                break;
                        }
                    }
                    if (sum==n/2)
                        cnt++;
                    sum=0;
                }
            }
            System.out.println("#"+t+" "+cnt);
        }
    }
}
