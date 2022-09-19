import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int cnt=0;
        for(int i=0; i<=6;i++){
            if((n&(1<<i))>0)
                cnt++;
        }
        System.out.println(cnt);
    }
}
