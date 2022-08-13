import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        int sum=0;
        int min = 100;
        int ans=0;
        for(int i=0; i<10; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            sum += arr[i];
            min = Math.min(Math.abs(sum-100),min);
            if(min==Math.abs(sum-100))
                ans=sum;
        }
        System.out.println(ans);
    }
}
