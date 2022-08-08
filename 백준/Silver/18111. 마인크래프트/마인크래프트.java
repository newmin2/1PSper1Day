import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int[][] arr2 = new int[N][M];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                arr2[i][j] = arr[i][j];
                min = Math.min(arr[i][j], min);
                max = Math.max(arr[i][j], max);
            }
        }
        int sum;
        int block = 0;
        int tmp;
        int mint = Integer.MAX_VALUE;
        while (max-min >= 0) {
            sum = 0;
            tmp = B;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    arr2[i][j] = arr[i][j] - min;
                    if(arr2[i][j]==0) {
                        continue;
                    }
                    else if (arr2[i][j] > 0) {
                        sum += arr2[i][j] * 2;
                        tmp += arr2[i][j];
                    } else {
                        sum -= arr2[i][j];
                        tmp += arr2[i][j];
                    }
                }
            }
            if (tmp >= 0) {
                if (mint>=sum){
                    mint = sum;
                    block = min;
                }
            }else{
                break;}
            min++;
        }
        System.out.println(mint+" "+block);
    }
}
