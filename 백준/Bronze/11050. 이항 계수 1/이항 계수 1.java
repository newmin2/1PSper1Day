import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        double ans=1;
        for(int i=1;i<=info[1];i++){
            ans*= (double) (info[0] - i + 1) /i;
        }
        System.out.println((int)ans);
    }
}